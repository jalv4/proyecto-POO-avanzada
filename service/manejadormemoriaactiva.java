package service;

import model.Equipos;
import model.Usuarios;
import model.Sesiones;
import persistence.gestordecargadearchivos;

import java.util.ArrayList;

public class manejadormemoriaactiva {

    private ArrayList<Equipos> equiposs;
    private ArrayList<Usuarios> usuarioss;
    private gestordecargadearchivos cargador;
    private ArrayList<Sesiones> sesioneess;

    public manejadormemoriaactiva() {
        this.equiposs = new ArrayList<Equipos>();
        this.usuarioss = new ArrayList<Usuarios>();
        this.cargador = new gestordecargadearchivos();
        this.sesioneess = new ArrayList<Sesiones>();    
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
    public ArrayList<Sesiones> getSesioneess() {
    return this.sesioneess;
}

 // Opcion 8 Muestra el inventario de equipos agrupado por laboratorio y estado.
public void mostrarInventario() {
    
    // si no hay equipos en memoria avisamos y salimos
    if (equiposs.isEmpty()) {
        System.out.println("No hay equipos registrados en memoria");
        return;
    }
    // lista para guardar los nombres de laboratorios sin repetir
    ArrayList<String> laboratorios = new ArrayList<>();
    for (Equipos e : equiposs) {
        // solo agrega el laboratorio si todavia no esta en la lista
        if (!laboratorios.contains(e.getLaboratorio())) {
            laboratorios.add(e.getLaboratorio());
        }
    }
    // por cada laboratorio imprime los equipos que le pertenecen
    for (String lab : laboratorios) {
        System.out.println("=== Laboratorio: " + lab + " ===");
        for (Equipos e : equiposs) {
            // si el equipo pertenece a este laboratorio lo imprime
            if (e.getLaboratorio().equals(lab)) {
                System.out.println("  Codigo: " + e.getCodigo()
                        + " | Nombre: " + e.getNombre()
                        + " | Estado: " + e.getEstado()
                        + " | Usos: " + e.getContusos());
            }
        }
        System.out.println(); 
    }
}
  // Toma las listas que estan en memoria y se las manda al gestor de archivos para guardarlas en el archivo
public void guardarEstado() {
    cargador.guardarEstado(equiposs, usuarioss, sesioneess);
}
// Le pide al gestor de archivos que lea el archivo y con lo que retorna actualiza las listas en memoria
// el sistema vuelve a como estaba antes de cerrar el programa
public void recuperarEstado() {
    Object[] resultado = cargador.recuperarEstado();
    // si el archivo existia y se leyo bien, reemplaza las listas con lo que habia guardado
    if (resultado != null) {
        equiposs   = (ArrayList<Equipos>) 
                      resultado[0]; // recupera la lista de equipos
        usuarioss  = (ArrayList<Usuarios>) 
                      resultado[1]; // recupera la lista de usuarios
        sesioneess = (ArrayList<Sesiones>) 
                      resultado[2]; // recupera la lista de sesiones
    }
}
}
