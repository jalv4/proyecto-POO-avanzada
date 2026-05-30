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
                        Equipos.Tipodeequipo.valueOf(datos[0]),
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
}
