package ui;

import model.*;
import exceptions.*;
import service.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Mainapp {

    public static void main(String[] args) {
        manejadormemoriaactiva datos = new manejadormemoriaactiva();
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
                    if (Comprobador.comprobacion(usuario) == false){throw new datosinvalidos("el usuario no puede estar vacio");}
                    else {bandera = true;}
                }catch (datosinvalidos e){e.mensajegeneral(); e.mensajesingular();}
            }while (bandera == false);
            bandera = false;
            do {
                System.out.println("Ingrese contraseña");
                try {
                    contrasenia = input.nextLine();
                    if (Comprobador.comprobacion(usuario) == false){throw new datosinvalidos("la contraseña no puede estar vacia");}
                    else {bandera = true;}
                }catch (datosinvalidos e){e.mensajegeneral(); e.mensajesingular();}
            }while (bandera == false);
            bandera = false;
            if (Comprobador.comprobacionadmin(contrasenia, usuario) == true){System.out.println("usuario administardor confirmado"); bandera = true;}
            else{
                System.out.println("usuario administardor negativo");
                do {
                    System.out.println("Desea volver a intentar? true/false");
                    try {
                        inputboolvolver = input.nextLine();

                        if (Comprobador.comprobacionbool(inputboolvolver) == false){throw new datosinvalidos("los booleanos deben ser solo true o false");}
                        else {volver = Boolean.parseBoolean(inputboolvolver); bandera =true;}

                    }catch (datosinvalidos e){e.mensajegeneral(); e.mensajesingular();}
                }while (bandera == false);
            }

            if (volver == true){bandera = false;}
            if (volver == false){bandera = true;}

        }while (bandera == false);

        if (Comprobador.comprobacionadmin(contrasenia, usuario) == true){
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
                if (Comprobador.comprobacion(eleccion) == false){throw new datosinvalidos("la eleccion no puede ser 0 ni negativa");}
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
                datos.ejecutarCargausuarios();
                break;
            case 4:
                datos.ejecutarCargaequipos();
                break;
        }
    }
}
