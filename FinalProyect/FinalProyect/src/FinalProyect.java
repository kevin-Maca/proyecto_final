
import java.util.Scanner;
import modelo.Cabin;
import controller.CabinController;
import Dto_Generics.Generic;
import controller.DoorController;
import controller.WindowController;
import modelo.Door;
import modelo.Window;

public class FinalProyect {

    private static Scanner scan = new Scanner(System.in);
    private static CabinController objCabinController = new CabinController();
    private static DoorController objDoorController = new DoorController();
    private static WindowController objWindowController = new WindowController();

    public static void main(String[] args) {

        int opcion;
        int option;

        do {
            System.out.println("Bienvenido al Sistema de información.");
            System.out.println("Esconge una opcion para consultar  para el cual deseas consultar informacion.");
            System.out.println("""
                                  1  - Cabinas
                                  2  - Puertas
                                  3  - Ventanas
                                  4  - Salir
                                  """);
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    do {

                        System.out.println("Sistema de informacion para Cabinas");
                        System.out.println("Seleccion en el menu la opcion ");
                        System.out.println("""
                                           1 - Registrar informacion.
                                           2 - Buscar informacion.
                                           3 - Listar informacion.
                                           4 - Eliminar informacion. 
                                           5 - Volver al menú Principal.
                                           """);
                        option = scan.nextInt();
                        switch (option) {
                            case 1:
                                CabinRegister();
                                break;
                            case 2:
                                CabinSearch();
                                break;
                            case 3:
                                listCabin();
                                break;
                            case 4:
                                deleteCabina();
                                break;
                            case 5:
                                System.out.println("Saliendo del programa");
                                break;

                            default:
                                System.out.println("Opción no válida, por favor intente nuevamente");
                                break;
                        }
                    } while (option != 5);
                    break;
                case 2:
                    do {

                        System.out.println("Sistema de informacion para Puertas ");
                        System.out.println("Seleccion en el menu la opcion ");
                        System.out.println("""
                                           1 - Registrar informacion.
                                           2 - Buscar informacion.
                                           3 - Listar informacion.
                                           4 - Eliminar informacion. 
                                           5 - Volver al menú Principal.
                                           """);
                        option = scan.nextInt();
                        switch (option) {
                            case 1:
                                DoorRegister();
                                break;
                            case 2:
                                DoorSearch();
                                break;
                            case 3:
                                listDoor();
                                break;
                            case 4:
                                deleteDoor();
                                break;
                            case 5:
                                System.out.println("Saliendo del programa");
                                break;

                            default:
                                System.out.println("Opción no válida, por favor intente nuevamente");
                                break;
                        }
                    } while (option != 5);
                    break;
                case 3:
                    do {

                        System.out.println("Sistema de informacion para Ventana ");
                        System.out.println("Seleccion en el menu la opcion ");
                        System.out.println("""
                                           1 - Registrar informacion.
                                           2 - Buscar informacion.
                                           3 - Listar informacion.
                                           4 - Eliminar informacion. 
                                           5 - Volver al menú Principal.
                                           """);
                        option = scan.nextInt();
                        switch (option) {
                            case 1:
                                WindowRegister();
                                break;
                            case 2:
                                WindowSearch();
                                break;
                            case 3:
                                listWindow();
                                break;
                            case 4:
                                deleteWindow();
                                break;
                            case 5:
                                System.out.println("Saliendo del programa");
                                break;

                            default:
                                System.out.println("Opción no válida, por favor intente nuevamente");
                                break;
                        }
                    } while (option != 5);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente");
                    break;
            }
        } while (opcion != 4);

    }
//        CRUD CABINA

    private static void CabinRegister() {
        char sw;

        do {
            System.out.println("Sistema de Informacion de Materiales");
            System.out.println("Ingrese el  ID de la Cabina");
            int id = scan.nextInt();
            scan.nextLine();
            System.out.println("Ingrese el nombre de la Cabina");
            String name = scan.next();
            scan.nextLine();
            System.out.println("Ingrese las dimenciones de la cabina");
            String dimension = scan.next();
            scan.nextLine();
            System.out.println("Ingrese el material de la cabina");
            String material = scan.next();
            scan.nextLine();
            System.out.println("Ingrese el  tipo de cabina, estilo de apertura");
            String openStyle = scan.next();
            scan.nextLine();
            System.out.println("Ingrese el  color de la  cabina");
            String color = scan.next();

            Cabin objCabin = new Cabin(id, name, dimension, material, openStyle, color);

            Generic<Cabin> objGeneric = new Generic<>();
            objGeneric.setContent(objCabin);

            if (objCabinController.register(id, objGeneric.getContent())) {
                System.out.println("Cabina ingresado Correctamente.");
            } else {

                System.out.println("Cabina NO se ingreso correctamente");
            }

            System.out.println("Desea ingresar otra cabina.(S/N)");
            sw = scan.next().toUpperCase().charAt(0);

        } while (sw == 'S');
    }

    private static void CabinSearch() {
        char sw;
        do {
            System.out.println("Consultar Cabina");
            System.out.println("Ingrese el ID de la cabina");
            int id = scan.nextInt();
            String result = objCabinController.search(id);
            if (result != "") {
                System.out.println("Datos encontrados con el ID " + id);
                System.out.println(result);
            } else {
                System.out.println("No se encontraron datos con el ID " + id);
            }
            System.out.println("Te gustaria realizar otra consulta! (S/N):");
            sw = scan.next().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

    private static void listCabin() {
        System.out.println("Listado de Cabinas ");

        String result = objCabinController.list();
        if (result != "") {
            System.out.println(result);
        } else {
            System.out.println("no tenemos cabinas registradas");
        }
    }

    private static void deleteCabina() {

        char sw;

        do {
            System.out.println("\nRemover Cabina");
            System.out.println("Ingrese el id de la cabina que desea remover: ");
            int id = scan.nextInt();

            String result = objCabinController.search(id);
            if (result != "") {
                System.out.println("\nDatos de la cabina");
                System.out.println(result);

                System.out.println("\nDesea remover los datos de la Cabina (S/N): ");
                sw = scan.next().toUpperCase().charAt(0);

                if (sw == 'S') {
                    if (objCabinController.remove(id)) {
                        System.out.println("\nCabina removido exitosamente!!...");
                    } else {
                        System.out.println("\nCabina no se logró remover. Verifique!!...");
                    }
                }
            } else {
                System.out.println("\nCabina no se encontro. Verifique!!...");
            }

            System.out.println("\nDesea consultar otra Cabina para remover (S/N): ");
            sw = scan.next().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

//        CRUD PUERTA    
    private static void DoorRegister() {
        char sw;

        do {
            System.out.println("Sistema de Informacion de Materiales");
            System.out.println("Ingrese el  ID de la Puerta");
            int id = scan.nextInt();
            scan.nextLine();
            System.out.println("Ingrese el nombre de la Puerta");
            String name = scan.next();
            scan.nextLine();
            System.out.println("Ingrese las dimenciones de la Puerta");
            String dimension = scan.next();
            scan.nextLine();
            System.out.println("Ingrese el material de la Puerta");
            String material = scan.next();
            scan.nextLine();
            System.out.println("Ingrese el  tipo de la Puerta");
            String tipo = scan.next();
            scan.nextLine();

            Door objDoor = new Door(tipo, id, name, dimension, material);

            Generic<Door> objGeneric = new Generic<>();
            objGeneric.setContent(objDoor);

            if (objDoorController.register(id, objGeneric.getContent())) {
                System.out.println("Cabina ingresado Correctamente.");
            } else {

                System.out.println("Cabina NO se ingreso correctamente");
            }

            System.out.println("Desea ingresar otra cabina.(S/N)");
            sw = scan.next().toUpperCase().charAt(0);

        } while (sw == 'S');
    }

    private static void DoorSearch() {
        char sw;
        do {
            System.out.println("Consultar Cabina");
            System.out.println("Ingrese el ID de la cabina");
            int id = scan.nextInt();
            String result = objDoorController.search(id);
            if (result != "") {
                System.out.println("Datos encontrados con el ID " + id);
                System.out.println(result);
            } else {
                System.out.println("No se encontraron datos con el ID " + id);
            }
            System.out.println("Te gustaria realizar otra consulta! (S/N):");
            sw = scan.next().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

    private static void listDoor() {
        System.out.println("Listado de Cabinas ");

        String result = objDoorController.list();
        if (result != "") {
            System.out.println(result);
        } else {
            System.out.println("no tenemos Puertas registradas");
        }
    }

    private static void deleteDoor() {

        char sw;

        do {
            System.out.println("\nRemover Puerta");
            System.out.println("Ingrese el id de la Puerta que desea remover: ");
            int id = scan.nextInt();

            String result = objDoorController.search(id);
            if (result != "") {
                System.out.println("\nDatos de la puerta");
                System.out.println(result);

                System.out.println("\nDesea remover los datos de la Puerta (S/N): ");
                sw = scan.next().toUpperCase().charAt(0);

                if (sw == 'S') {
                    if (objDoorController.remove(id)) {
                        System.out.println("\nPuerta removido exitosamente!!...");
                    } else {
                        System.out.println("\nPuerta no se logró remover. Verifique!!...");
                    }
                }
            } else {
                System.out.println("\nPUerta no se encontro. Verifique!!...");
            }

            System.out.println("\nDesea consultar otra Puerta para remover (S/N): ");
            sw = scan.next().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

//       CRUD VENTANA  
    private static void WindowRegister() {
        char sw;

        do {
            System.out.println("Sistema de Informacion de Materiales");
            System.out.println("Ingrese el  ID de la Ventana");
            int id = scan.nextInt();
            scan.nextLine();
            System.out.println("Ingrese el nombre de la Ventana");
            String name = scan.next();
            scan.nextLine();
            System.out.println("Ingrese las dimenciones de la Ventana");
            String dimension = scan.next();
            scan.nextLine();
            System.out.println("Ingrese el material de la Ventana");
            String material = scan.next();
            scan.nextLine();

            Window objWindow = new Window(id, name, dimension, material);

            Generic<Window> objGeneric = new Generic<>();
            objGeneric.setContent(objWindow);

            if (objWindowController.register(id, objGeneric.getContent())) {
                System.out.println("Ventana ingresado Correctamente.");
            } else {

                System.out.println("Ventana NO se ingreso correctamente");
            }

            System.out.println("Desea ingresar otra Ventana.(S/N)");
            sw = scan.next().toUpperCase().charAt(0);

        } while (sw == 'S');
    }

    private static void WindowSearch() {
        char sw;
        do {
            System.out.println("Consultar Ventana");
            System.out.println("Ingrese el ID de la Ventana");
            int id = scan.nextInt();
            String result = objWindowController.search(id);
            if (result != "") {
                System.out.println("Datos encontrados con el ID " + id);
                System.out.println(result);
            } else {
                System.out.println("No se encontraron datos con el ID " + id);
            }
            System.out.println("Te gustaria realizar otra consulta! (S/N):");
            sw = scan.next().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

    private static void listWindow() {
        System.out.println("Listado de Cabinas ");

        String result = objWindowController.list();
        if (result != "") {
            System.out.println(result);
        } else {
            System.out.println("no tenemos Puertas registradas");
        }
    }

    private static void deleteWindow() {

        char sw;

        do {
            System.out.println("\nRemover Ventana");
            System.out.println("Ingrese el id de la Ventana que desea remover: ");
            int id = scan.nextInt();

            String result = objWindowController.search(id);
            if (result != "") {
                System.out.println("\nDatos de la puerta");
                System.out.println(result);

                System.out.println("\nDesea remover los datos de la Ventana (S/N): ");
                sw = scan.next().toUpperCase().charAt(0);

                if (sw == 'S') {
                    if (objWindowController.remove(id)) {
                        System.out.println("\nVentana removido exitosamente!!...");
                    } else {
                        System.out.println("\nVentana no se logró remover. Verifique!!...");
                    }
                }
            } else {
                System.out.println("\nVentana no se encontro. Verifique!!...");
            }

            System.out.println("\nDesea consultar otra Ventana para remover (S/N): ");
            sw = scan.next().toUpperCase().charAt(0);
        } while (sw == 'S');
    }

}
