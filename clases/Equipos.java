package clases;

public class Equipos {

    //enums
    public enum Tipodeequipo{Sistemas, Electronica, Manufactura, Telecomunicaciones}
    public enum Estadoactual{Disponible, Prestado, Mantenimiento}

    //atributos
    private Tipodeequipo tipo;
    private Estadoactual estado;
    private final int codigo;
    private String nombre;
    private String laboratorio;
    private int valor;
    private int contusos;

    private static int continstancias = 0;

    //getters
    public int getCodigo(){
        return this.codigo;
    }
    public int getContusos() {
        return contusos;
    }
    public Estadoactual getEstado() {
        return estado;
    }

    //setters
    public void setEstado(Estadoactual estado) {
        this.estado = estado;
    }
    public void setContusos(int contusos) {
        this.contusos++;
    }

    //metodos
    public void impresion(){
        System.out.println("Codigo:" +  this.codigo);
        System.out.println("Nombre:" +  this.nombre);
        System.out.println("Estado:" +  this.estado);
        System.out.println("Tipo:" +  this.tipo);
        System.out.println("Valor:" +  this.valor);
        System.out.println("Laboratorio:" +  this.laboratorio);
    }

    //constructores
    public Equipos(String nombre, Tipodeequipo tipo, String laboratorio, int valor){
        this.nombre = nombre;
        this.tipo = tipo;
        this.laboratorio = laboratorio;
        this.estado = Estadoactual.Disponible;
        this.valor = valor;
        this.contusos = 0;

        continstancias++;
        this.codigo = continstancias;
    }
    public Equipos(String nombre, Tipodeequipo tipo, int valor){
        this.nombre = nombre;
        this.tipo = tipo;
        this.laboratorio = "no registra a un laboratorio vinculado";
        this.estado = Estadoactual.Disponible;
        this.valor = valor;
        this.contusos = 0;

        continstancias++;
        this.codigo = continstancias;
    }
    public Equipos(String nombre, Tipodeequipo tipo){
        this.nombre = nombre;
        this.tipo = tipo;
        this.laboratorio = "no registra a un laboratorio vinculado";
        this.estado = Estadoactual.Disponible;
        this.contusos = 0;

        continstancias++;
        this.codigo = continstancias;
    }

    //constructor de carga
    public Equipos(Tipodeequipo tipo, Estadoactual estado, int codigo, String nombre, String laboratorio, int valor, int contusos){
        this.tipo = tipo;
        this.estado = estado;
        this.codigo = codigo;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.valor = valor;
        this.contusos = contusos;
    }
}
