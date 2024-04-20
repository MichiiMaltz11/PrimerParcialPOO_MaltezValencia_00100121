import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static ArrayList<ArticuloElectronico> inventario = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n-----------Bienvenido al sistema de Inventario--------------");
            System.out.println("1. Agregar articulo");
            System.out.println("2. Modificar articulo");
            System.out.println("3. Ver lista de articulos");
            System.out.println("4. Salir del sistema");
            System.out.print("Seleccione una opcion: ");

            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    agregarArticulo();
                    break;
                case 2:
                    modificarArticulo();
                    break;
                case 3:
                    mostrarListaArticulos();
                    break;
                case 4:
                    System.out.println("Ssaliendo del sistema....");
                    return;
                default:
                    System.out.println("Porfavor selecione una opcion valida");
            }

        }


    }

    private static void modificarArticulo() {
        System.out.println("\nIngrese el numero de articulo que desea modificar:");
        int numArticulo = scanner.nextInt();
        scanner.nextLine();

        if (numArticulo >= 1 && numArticulo <= inventario.size()) {
            ArticuloElectronico articulo = inventario.get(numArticulo - 1);
            System.out.println("\nArticulo seleccionado:");
            System.out.println("Nombre: " + articulo.nombre);

            System.out.println("\nIngrese la modificacion del articulo:");
            System.out.print("Nuevo modelo: ");
            String nuevoModelo = scanner.nextLine();
            System.out.print("Nuevo precio: ");
            double nuevoPrecio = scanner.nextDouble();
            scanner.nextLine();

            if (articulo instanceof TelefonoMovil) {
                TelefonoMovil telefonoMovil = (TelefonoMovil) articulo;
                telefonoMovil.modelo = nuevoModelo;
                telefonoMovil.precio = nuevoPrecio;
            } else if (articulo instanceof Laptop) {
                Laptop laptop = (Laptop) articulo;
                laptop.modelo = nuevoModelo;
                laptop.precio = nuevoPrecio;
            }

            System.out.println("Articulo modificado correctamente.");
        } else {
            System.out.println("El numero de articulo no existe");
        }


    }


    private static void mostrarListaArticulos() {

        System.out.println("\nLista de articulos:");
        if (inventario.isEmpty()) {
            System.out.println("El inventario no posee nigun articulo");
        } else {
            for (int i = 0; i < inventario.size(); i++) {
                ArticuloElectronico articulo = inventario.get(i);
                System.out.println("\nArticulo " + (i + 1) + ":");
                System.out.println("Nombre: " + articulo.nombre);
                System.out.println("Modelo: " + articulo.modelo);
                System.out.println("Descripcion: " + articulo.obtenerDescripcion());
                System.out.println("Precio: " + articulo.obtenerPrecio());
            }
        }
    }

    private static void agregarArticulo() {
        System.out.println("\nIngrese los datos del articulo:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Seleccione el tipo de articulo (1 - Telefono Movil, 2 - Laptop): ");
        int tipoArticulo = scanner.nextInt();
        scanner.nextLine();

        switch (tipoArticulo) {
            case 1:
                System.out.print("Sistema operativo del telefono movil: ");
                String sistemaOperativo = scanner.nextLine();
                inventario.add(new TelefonoMovil(nombre, modelo, descripcion, precio, sistemaOperativo));
                break;
            case 2:
                System.out.print("Sistema operativo de la laptop: ");
                String sistemaOperativoLaptop = scanner.nextLine();
                System.out.print("Tamanio de pantalla de la laptop: ");
                String tamanoPantalla = scanner.nextLine();
                inventario.add(new Laptop(nombre, modelo, descripcion, precio, sistemaOperativoLaptop, tamanoPantalla));
                break;
            default:
                System.out.println("Selecciona una opcion valida");
        }

        System.out.println("Se ha agregado el articulo correctamente");
    }
}
