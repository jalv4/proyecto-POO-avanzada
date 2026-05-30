package model;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Sesiones  implements Serializable{

private static final long serialVersionUID = 1L;

    private final int codigo;
    private Equipos equipo;
    private Usuarios usuario;
    private LocalDateTime fechainicio;
    private LocalDateTime fechafin;
    private double penalizacion;
    private boolean activa;
    private static int continstancias = 0;

    //Getters

    public int getCodigo() {
        return codigo;
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public LocalDateTime getFechainicio() {
        return fechainicio;
    }

    public LocalDateTime getFechafin() {
        return fechafin;
    }

    public double getPenalizacion() {
        return penalizacion;
    }

    public boolean isActiva() { 
        return activa;
    }

    //Setters

    public void setFechafin(LocalDateTime fechafin) {
        this.fechafin = fechafin;
    }

    public void setPenalizacion(double penalizacion) {
        this.penalizacion = penalizacion;
    }

    public void setActiva(boolean activa) { 
        this.activa = activa; 
    }

//Constructores

/**
 * Constructor para programar una nueva sesion en el momento actual
 * @param equipo   equipo que se va a usar
 * @param usuario  usuario responsable de la sesion
 */
    public Sesiones(Equipos equipo, Usuarios usuario) {
        this.equipo = equipo;
        this.usuario = usuario;
        this.fechainicio = LocalDateTime.now();
        this.fechafin = null;
        this.penalizacion = 0;
        continstancias++;
        this.codigo = continstancias;
    }
//Carga
    public Sesiones(int codigo, Equipos equipo, Usuarios usuario, LocalDateTime fechainicio, LocalDateTime fechafin, double penalizacion) {
        this.codigo = codigo;
        this.equipo = equipo;
        this.usuario = usuario;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.penalizacion = penalizacion;
    }

    @Override
    public String toString() {
        return "Sesiones{" +
                "codigo=" + codigo +
                ", equipo=" + equipo +
                ", usuario=" + usuario +
                ", fechainicio=" + fechainicio +
                ", fechafin=" + fechafin +
                ", penalizacion=" + penalizacion +
                '}';
    }
}
