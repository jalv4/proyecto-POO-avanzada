package clases;

public class Administradores extends Usuarios{

    //constructor
    public Administradores(String nombre, String credencial, roles rol){
        super(credencial, nombre, rol);
    }
    //constructor carga
    public Administradores(int codigo, roles rol, String credendial, String nombre){
        super(codigo, rol, credendial, nombre);
    }
}
