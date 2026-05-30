package model;

public class Monitores extends Usuarios{

    //constructor
    public Monitores(String nombre, String credencial, roles rol){
        super(credencial, nombre, rol);
    }
    //constructor carga
    public Monitores(int codigo, roles rol, String credendial, String nombre){
        super(codigo, rol, credendial, nombre);
    }
}
