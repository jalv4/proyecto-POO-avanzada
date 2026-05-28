package clases;

public class Estudiantes extends Usuarios {

    //constructor
    public Estudiantes(String nombre, String credencial, roles rol){
        super(credencial, nombre, rol);
    }
    //constructor carga
    public Estudiantes(int codigo, roles rol, String credendial, String nombre){
        super(codigo, rol, credendial, nombre);
    }
}
