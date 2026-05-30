package service;

public class Comprobador {

    public static boolean comprobacionbool(String booleano) {
        if (booleano.equals("true") || booleano.equals("false")) {return true;}
        else {return false;}
    }
    public static boolean comprobacion(int numero) {
        if (numero <= 0) {return false;}
        else {return true;}
    }
    public static boolean comprobacion(String cadena) {
        if (cadena == "" || cadena == null) {return false;}
        else {return true;}
    }
    public static boolean comprobacionadmin(String contra, String usuario){
        if(contra.equals("1234contrasenia") && usuario.equals("admin")){return true;}
        else{return false;}
    }
}
