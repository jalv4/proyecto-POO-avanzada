package persistence;

import model.*;

import java.io.*;
import java.util.ArrayList;

public class gestordecargadearchivos {

    //Tipodeequipo;Estadoactual;codigo;nombre;laboratorio;valor;contusos
    public ArrayList<Equipos> cargaequipos(){
        ArrayList<Equipos> listaTemporal = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("persistence/equipos.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                Equipos equipo = new Equipos(
                        Equipos.tipodeequipo.valueOf(datos[0]),
                        Equipos.Estadoactual.valueOf(datos[1]),
                        Integer.parseInt(datos[2]),
                        datos[3],
                        datos[4],
                        Integer.parseInt(datos[5]),
                        Integer.parseInt(datos[6])
                );
                listaTemporal.add(equipo);
            }
            br.close();

        }catch (IOException e){
            System.out.println("error cargando equipos");
        }
        return listaTemporal;
    }
    //Codigo;Rol;Credencial;Nombre
    public ArrayList<Usuarios> cargausuarios(){
        ArrayList<Usuarios> listaTemporal = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("persistence/usuarios.txt"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                Usuarios usuario = null;

                Usuarios.roles rol = Usuarios.roles.valueOf(datos[1]);

                switch (rol){
                    case Administrador:
                        usuario = new Administradores(
                                Integer.parseInt(datos[0]),
                                Usuarios.roles.valueOf(datos[1]),
                                datos[2],
                                datos[3]
                        );
                        break;
                    case Monitor:
                        usuario = new Monitores(
                                Integer.parseInt(datos[0]),
                                Usuarios.roles.valueOf(datos[1]),
                                datos[2],
                                datos[3]
                        );

                        break;
                    case Estudiante:
                        usuario = new Estudiantes(
                                Integer.parseInt(datos[0]),
                                Usuarios.roles.valueOf(datos[1]),
                                datos[2],
                                datos[3]
                        );
                        break;
                }
                listaTemporal.add(usuario);
            }
            br.close();

        }catch (IOException e){
            System.out.println("error cargando usuarios");
        }
        return listaTemporal;
    }
    // Opcion 6: guardar estado completo
    //Guarda el estado completo del sistema en un archivo binario para esto serializa las listas de equipos, usuarios y sesiones
    public void guardarEstado(ArrayList<Equipos> equipos, ArrayList<Usuarios> usuarios, ArrayList<Sesiones> sesiones) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persistence/estado.dat"));
            oos.writeObject(equipos);  // guarda lista de equipos
            oos.writeObject(usuarios); // guarda lista de usuarios
            oos.writeObject(sesiones); // guarda lista de sesiones
            oos.close();
            System.out.println("Estado guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    // Opcion 7: recuperar estado completo
    //Recupera el estado del sistema desde el archivo binario por lo que deserializa las listas y las retorna en un arreglo de objetos
    public Object[] recuperarEstado() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persistence/estado.dat"));
            ArrayList<Equipos> equipos   = (ArrayList<Equipos>)  ois.readObject();  // lee equipos
            ArrayList<Usuarios> usuarios = (ArrayList<Usuarios>) ois.readObject();  // lee usuarios
            ArrayList<Sesiones> sesiones = (ArrayList<Sesiones>) ois.readObject();  // lee sesiones
            ois.close();
            System.out.println("Estado recuperado correctamente.");
            return new Object[]{equipos, usuarios, sesiones}; // retorna las tres listas juntas en un arreglo
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al recuperar: " + e.getMessage());
            return null;
        }
    }

}
