package clases;

public abstract class Usuarios {

    //enum
    public enum roles{Administrador, Monitor, Estudiante}

    //atributos
    protected final int codigo;
    protected String nombre;
    protected roles rol;
    protected String credendial;

    private static int continstancias = 0;

    //metodos abstractos


    //constructor
    public Usuarios(String credendial, String nombre, roles rol){
        this.credendial = credendial;
        this.nombre = nombre;
        this.rol = rol;

        continstancias++;
        this.codigo = continstancias;
    }
    //constructor carga
    public Usuarios(int codigo, roles rol, String credendial, String nombre){
        this.credendial = credendial;
        this.nombre = nombre;
        this.rol = rol;
        this.codigo = codigo;
    }
}
