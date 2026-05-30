package service;

import model.Equipos;
import model.Usuarios;
import persistence.gestordecargadearchivos;

import java.util.ArrayList;

public class manejadormemoriaactiva {

    private ArrayList<Equipos> equiposs;
    private ArrayList<Usuarios> usuarioss;

    private gestordecargadearchivos cargador;

    public manejadormemoriaactiva() {
        this.equiposs = new ArrayList<Equipos>();
        this.usuarioss = new ArrayList<Usuarios>();
        this.cargador = new gestordecargadearchivos();
    }

    public void ejecutarCargausuarios() {
        System.out.println("Iniciando carga de usuarios");

        ArrayList<Usuarios> usuariosCargados = this.cargador.cargausuarios();

        if (usuariosCargados != null && !usuariosCargados.isEmpty()) {
            this.usuarioss.addAll(usuariosCargados);
            System.out.println("Completado: " + usuariosCargados.size() + " usuarios subidos a memoria activa");
        } else {
            System.out.println("No se cargaron usuarios o el archivo estaba vacío");
        }
    }

    public void ejecutarCargaequipos() {
        System.out.println("Iniciando carga de equipos");

        ArrayList<Equipos> equiposCargados = this.cargador.cargaequipos();

        if (equiposCargados != null && !equiposCargados.isEmpty()) {
            this.equiposs.addAll(equiposCargados);
            System.out.println("Completado: " + equiposCargados.size() + " equipos subidos a memoria activa");
        } else {
            System.out.println("No se cargaron equipos o el archivo estaba vacío");
        }
    }

    public ArrayList<Equipos> getEquiposs() {
        return this.equiposs;
    }

    public ArrayList<Usuarios> getUsuarioss() {
        return this.usuarioss;
    }
}