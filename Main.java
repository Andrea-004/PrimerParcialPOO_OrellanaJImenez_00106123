import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    static ArrayList<Articulo>lista = new ArrayList<Articulo>();
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        while (true){
            mostrarMenu();
            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion){
                    case 1:
                        crearArticulo();
                        break;
                    case 2:
                        modificarArticulo();
                        break;
                    case 3:
                        consultarArticuloEspecifico();
                        break;
                    case 4:
                        mostrarLista();
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                        break;
                }

                if (opcion == 0){
                    System.out.println("Programa finalizado");
                    break;
                }

            }catch(InputMismatchException e){
                sc.nextLine();
                System.out.println("Ingrese una opcion valida");
            }
        }
    }

    private static void mostrarLista() {
        for (Articulo lista : lista){
            System.out.println("-----------------");
            System.out.println("ID: " + lista.getId());
            System.out.println("Nombre: " + lista.getNombre());
            System.out.println("Modelo: " + lista.getModelo());
            System.out.println("Descripcion: " + lista.obtenerDescripcion());
            System.out.println("Precio: " + lista.obtenerPrecio());
            System.out.println("-----------------");
        }
    }

    private static void consultarArticuloEspecifico() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del articulo del cual desea observar sus datos: ");
        String ID = sc.nextLine();

        for (Articulo lista: lista){
            if (lista.getId().equals(ID)){
                System.out.println("-----------------");
                System.out.println("ID: " + lista.getId());
                System.out.println("Nombre: " + lista.getNombre());
                System.out.println("Modelo: " + lista.getModelo());
                System.out.println("Descripcion: " + lista.obtenerDescripcion());
                System.out.println("Precio: " + lista.obtenerPrecio());
                System.out.println("-----------------");
            }
        }

    }

    private static void modificarArticulo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del articulo del cual desea cambiar el precio: ");
        String ID = sc.nextLine();

        for (Articulo lista: lista){
            if (lista.getId().equals(ID)){
                System.out.println("Ingrese el nuevo nombre del articulo: ");
                lista.setNombre(sc.nextLine());
            }

        }

    }

    private static void crearArticulo() {
        Scanner sc = new Scanner(System.in);
        int opcion = ObtenerTipoArticulo();

        System.out.println("Ingrese el ID de su articulo:");
        String ID = sc.nextLine();
        System.out.println("Ingrese el nombre de su articulo:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el modelo de su articulo:");
        String modelo = sc.nextLine();
        System.out.println("Ingrese la descripcion de su articulo:");
        String descripcion = sc.nextLine();
        System.out.println("Ingrese el precio de su articulo:");
        double precio = sc.nextDouble();



        switch (opcion){
            case 1:
                sc.nextLine();
                System.out.println("Ingrese el tipo de telefono (plegable o tactil):");
                String tipo = sc.nextLine();
                System.out.println("Ingrese el año de salida del telefono (si el año excede el 2015, se le cobraran 200 dolares extra:");
                double anioSalida = sc.nextDouble();

                TelefonoMovil telefonoMovil = new TelefonoMovil(ID, nombre, modelo, descripcion, precio, tipo, anioSalida);
                lista.add(telefonoMovil);
                break;
            case 2:
                System.out.println("Ingrese el almacenamiento de su laptop (si su almacenamiento excede los 120, se le cobraran 20 dolares adicionales): ");
                double almacenamiento = sc.nextDouble();
                sc.nextLine();
                System.out.println("Ingrese la RAM de su laptop");
                String RAM = sc.nextLine();

                Laptop laptop = new Laptop(ID, nombre, modelo, descripcion, precio, almacenamiento, RAM);
                lista.add(laptop);
                break;
            default:
                break;
        }


    }

    private static int ObtenerTipoArticulo() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        while (true){
            System.out.println("Ingrese el tipo de articulo que desea comprar:");
            System.out.println("1. Telefono");
            System.out.println("2. Laptop");

            try {
                opcion = sc.nextInt();
                sc.nextLine();
                if (opcion <= 2 && opcion >= 1)return opcion;
            }catch(InputMismatchException e){
                sc.nextLine();
                System.out.println("Ingrese una opcion valida");
            }
        }

    }

    private static void mostrarMenu() {
        System.out.println("Seleccione la opcion que desea realizar: ");
        System.out.println("1. Crear un articulo");
        System.out.println("2. Modificar el nombre de un articulo");
        System.out.println("3. Consultar un articulo en especifico en base a su ID");
        System.out.println("4. Mostrar la lista comṕleta de articulos registrados");
        System.out.println("0. Salir del programa");
    }
}

