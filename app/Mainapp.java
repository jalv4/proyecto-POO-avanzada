package app;

import clases.*;
import excepciones.datosinvalidos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Mainapp {

    static ArrayList<Equipos> equiposs = new ArrayList<Equipos>();
    static ArrayList<Usuarios> usuarioss = new ArrayList<Usuarios>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String contrasenia = null, usuario = null, inputboolvolver = null;
        boolean bandera = false, volver = false;
        int eleccion = 0;

        do {
            //inicio de sesion
            bandera = false;
            System.out.println("-------------------INICIO DE SESION---------------------");
            do {
                System.out.println("Ingrese el usuario administrador");
                try {
                    usuario = input.nextLine();
                    if (comprobacion(usuario) == false){throw new datosinvalidos("el usuario no puede estar vacio");}
                    else {bandera = true;}
                }catch (datosinvalidos e){e.mensajegeneral(); e.mensajesingular();}
            }while (bandera == false);
            bandera = false;
            do {
                System.out.println("Ingrese contraseña");
                try {
                    contrasenia = input.nextLine();
                    if (comprobacion(usuario) == false){throw new datosinvalidos("la contraseña no puede estar vacia");}
                    else {bandera = true;}
                }catch (datosinvalidos e){e.mensajegeneral(); e.mensajesingular();}
            }while (bandera == false);
            bandera = false;
            if (comprobacionadmin(contrasenia, usuario) == true){System.out.println("usuario administardor confirmado"); bandera = true;}
            else{
                System.out.println("usuario administardor negativo");
                do {
                    System.out.println("Desea volver a intentar? true/false");
                    try {
                        inputboolvolver = input.nextLine();

                        if (comprobacionbool(inputboolvolver) == false){throw new datosinvalidos("los booleanos deben ser solo true o false");}
                        else {volver = Boolean.parseBoolean(inputboolvolver); bandera =true;}

                    }catch (datosinvalidos e){e.mensajegeneral(); e.mensajesingular();}
                }while (bandera == false);
            }

            if (volver == true){bandera = false;}
            if (volver == false){bandera = true;}

        }while (bandera == false);

        if (comprobacionadmin(contrasenia, usuario) == true){
            System.out.println("-------------------MENU---------------------");
            System.out.println("1. Crear nuevo usuario");
            System.out.println("2. Crear nuevo equipo");
            System.out.println("3. Cargar usuarios");
            System.out.println("4. Cargar equipos");
            // resto de menu admin
        }
        else{
            // resto de menu no admins
        }

        do {
            try {
                eleccion = input.nextInt();
                input.nextLine();
                if (comprobacion(eleccion) == false){throw new datosinvalidos("la eleccion no puede ser 0 ni negativa");}
                else {bandera = true;}
            }catch (datosinvalidos e){e.mensajegeneral(); e.mensajesingular();}
        }while (bandera == false);
        bandera = false;

        switch (eleccion){
            case 1:
                break;
            case 2:
                break;
            case 3:
                cargausuarios();
                if(equiposs.isEmpty()){System.out.println("Usuarios no tiene registros");}
                else {System.out.println("Usuarios cargados con exito");}
                break;
            case 4:
                cargaequipos();
                if(equiposs.isEmpty()){System.out.println("Equipos no tiene registros");}
                else {System.out.println("Equipos cargados con exito");}
                break;
        }

    }
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
    //Tipodeequipo;Estadoactual;codigo;nombre;laboratorio;valor;contusos
    public static void cargaequipos(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("archivos/equipos.txt"));
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
                equiposs.add(equipo);
            }
            br.close();
        }catch (IOException e){
            System.out.println("error cargando equipos");
        }
    }
    //Codigo;Rol;Credencial;Nombre
    public static void cargausuarios(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("archivos/usuarios.txt"));
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
                usuarioss.add(usuario);
            }
            br.close();

        }catch (IOException e){
            System.out.println("error cargando usuarios");
        }
    }
}
