package excepciones;

public class datosinvalidos extends Exception {
    private String mensaje;

    public void mensajegeneral(){ System.out.println("Dato no valido, volver a intentar");}

    public void mensajesingular(){ System.out.println(this.mensaje);}

    public datosinvalidos(String mensaje){ this.mensaje = mensaje;}
}
