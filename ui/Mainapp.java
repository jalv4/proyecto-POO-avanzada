package ui;

import service.manejadormemoriaactiva;
import model.Equipos;
import model.Usuarios;
import model.Administradores;
import model.Monitores;
import model.Estudiantes;
import service.Comprobador;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        manejadormemoriaactiva manejador = new manejadormemoriaactiva();
        Scanner sc = new Scanner(System.in);
        boolean adminAutenticado = false;
        int opcion = -1;

        while (opcion != 14) {
            System.out.println("\n Sistema de Gestion de Equipos de Laboratorio ");
            System.out.println("1.  Login de administrador");
            System.out.println("2.  Registrar un equipo de laboratorio (Administrador)");
            System.out.println("3.  Registrar un usuario (Administrador)");
            System.out.println("4.  Cargar equipos desde archivo de texto (Administrador)");
            System.out.println("5.  Cargar usuarios desde archivo de texto (Administrador)");
            System.out.println("6.  Guardar el estado completo del sistema (Administrador)");
            System.out.println("7.  Recuperar el estado completo del sistema (Administrador)");
            System.out.println("8.  Mostrar inventario de equipos por laboratorio");
            System.out.println("9.  Programar una sesion de uso de un equipo");
            System.out.println("10. Cerrar una sesion y calcular penalizacion");
            System.out.println("11. Mostrar los equipos con mayor uso por laboratorio");
            System.out.println("12. Mostrar los usuarios con mayor indice de uso indebido");
            System.out.println("13. Gestion de administradores(crear,listar)");
            System.out.println("14. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Usuario: ");
                    String usuario = sc.nextLine();
                    System.out.print("Contrasena: ");
                    String contra = sc.nextLine();
                    if (Comprobador.comprobacionadmin(contra, usuario)) {
                        adminAutenticado = true;
                        System.out.println("Login exitoso. Bienvenido administrador.");
                    } else {
                        adminAutenticado = false;
                        System.out.println("Credenciales incorrectas. Acceso denegado.");
                    }
                    break;
                
                case 2:
                    if (!adminAutenticado) { System.out.println("Debe iniciar sesion como administrador."); break; }
                    System.out.print("Nombre del equipo: ");
                    String nombreEquipo = sc.nextLine();
                    System.out.println("Tipos disponibles: Sistemas, Electronica, Manufactura, Telecomunicaciones");
                    System.out.print("Tipo: ");
                    String tipoStr = sc.nextLine();
                    System.out.print("Laboratorio: ");
                    String lab = sc.nextLine();
                    System.out.print("Valor estimado: ");
                    int valor = Integer.parseInt(sc.nextLine());
                    Equipos nuevoEquipo = new Equipos(nombreEquipo, Equipos.Tipodeequipo.valueOf(tipoStr), lab, valor);
                    manejador.getEquiposs().add(nuevoEquipo);
                    System.out.println("Equipo registrado con codigo: " + nuevoEquipo.getCodigo());
                    break;

                case 3:
                    if (!adminAutenticado) { System.out.println("Debe iniciar sesion como administrador."); break; }
                    System.out.print("Nombre completo: ");
                    String nombreUsuario = sc.nextLine();
                    System.out.println("Roles disponibles: Administrador, Monitor, Estudiante");
                    System.out.print("Rol: ");
                    String rolStr = sc.nextLine();
                    System.out.print("Credencial: ");
                    String cred = sc.nextLine();
                    Usuarios.roles rol = Usuarios.roles.valueOf(rolStr);
                    Usuarios nuevoUsuario = null;
                    switch (rol) {
                        case Administrador:
                            nuevoUsuario = new Administradores(nombreUsuario, cred, rol);
                            break;
                        case Monitor:
                            nuevoUsuario = new Monitores(nombreUsuario, cred, rol);
                            break;
                        case Estudiante:
                            nuevoUsuario = new Estudiantes(nombreUsuario, cred, rol);
                            break;
                    }
                    manejador.getUsuarioss().add(nuevoUsuario);
                    System.out.println("Usuario registrado con codigo: " + nuevoUsuario.codigo);
                    break;

                case 4:
                    if (!adminAutenticado) { System.out.println("Debe iniciar sesion como administrador."); break; }
                    manejador.ejecutarCargaequipos();
                    break;

                case 5:
                    if (!adminAutenticado) { System.out.println("Debe iniciar sesion como administrador."); break; }
                    manejador.ejecutarCargausuarios();
                    break;

                case 6:
                    if (!adminAutenticado) { System.out.println("Debe iniciar sesion como administrador."); break; }
                    manejador.guardarEstado();
                    break;

                case 7:
                    if (!adminAutenticado) { System.out.println("Debe iniciar sesion como administrador."); break; }
                    manejador.recuperarEstado();
                    break;

                case 8:
                    manejador.mostrarInventario();
                    break;

                case 9:
                    System.out.print("Ingrese el codigo del equipo: ");
                    int codEquipo = Integer.parseInt(sc.nextLine());
                    System.out.print("Ingrese el codigo del usuario: ");
                    int codUsuario = Integer.parseInt(sc.nextLine());
                    manejador.programarSesion(codEquipo, codUsuario);
                    break;

                case 10:
                    break;

                case 11:
                    break;

                 case 12:
                    break;
             
                 case 13:
                    break;

                case 14:
                    System.out.println("Cerrando el sistema. Hasta luego.");
                    break;

                default:
                    System.out.println("Opcion no valida. Ingrese un numero entre 1 y 14.");
            }
        }
    }
}
