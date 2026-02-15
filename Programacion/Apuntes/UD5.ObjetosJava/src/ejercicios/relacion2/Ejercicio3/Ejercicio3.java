// Ejercicio 3: Supermercado y Productos
// Crea una clase Producto con atributos id, nombre, descripción, precio y cantidadEnStock. Implementa los métodos get y set para cada atributo, así como el método toString(). Luego, crea una clase Supermercado con un array de productos y métodos para:
// Agregar productos
// Vender un producto (reducir cantidadEnStock)
// Mostrar el inventario
// En el main, implementa un menú para vender y reponer productos. Usa la clase Faker para generar 100 productos.
package ejercicios.relacion2.Ejercicio3;

import java.util.Scanner;

import ejercicios.relacion2.Faker;

public class Ejercicio3 {

    public static void imprimirMensaje(String mensajeAMostrar) {
        System.out.println(mensajeAMostrar);
    }

    public static int leerOpcionMenu(String mensaje, int min, int max, Scanner sc) {
        int opcion;
        boolean correcta = false;

        do {
            imprimirMensaje(mensaje);
            opcion = leerEntero("Elige una opcion:", sc);

            if (opcion >= min && opcion <= max) {
                correcta = true;
            } else {
                imprimirMensaje("Error: la opcion debe estar entre " + min + " y " + max);
            }
        } while (!correcta);
        return opcion;
    }

    public static int leerEntero(String mensaje, Scanner sc) {
        int numero = 0;
        boolean correcto = false;

        while (!correcto) {
            try {
                imprimirMensaje(mensaje);
                numero = Integer.parseInt(sc.nextLine().trim());
                correcto = true;
            } catch (NumberFormatException e) {
                imprimirMensaje("Error: introduce un número entero valido");
            }
        }
        return numero;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Producto lacteo = new Producto("PTO-101", "Leche", "Descripcion1", 1.20, 100);
        Producto galleta = new Producto("PTO-102", "Galleta", "Descripcion2", 1.30, 20);
        Supermercado Super8 = new Supermercado();
        System.out.println(lacteo);

        Super8.agregarProducto(lacteo);
        Super8.agregarProducto(galleta);
        System.out.println(Super8);

        // ======== FAKER =========//
        final int CANTIDAD_PRODUCTOS = 100;
        Producto productoAleatorio = new Producto();
        for (int i = 0; i < CANTIDAD_PRODUCTOS; i++) {
            if (i < 10) {
                productoAleatorio = new Producto("PTO-00" + i, "Producto" + i, Faker.loremCorto(), Faker.precio(0.5, 30), Faker.entero(1, 100));
            } else if (i < 100 && i >= 10) {
                productoAleatorio = new Producto("PTO-0" + i, "Producto" + i, Faker.loremCorto(), Faker.precio(0.5, 30), Faker.entero(1, 100));
            } else {
                productoAleatorio = new Producto("PTO-" + i, "Producto" + i, Faker.loremCorto(), Faker.precio(0.5, 30), Faker.entero(1, 100));
            }
            Super8.agregarProducto(productoAleatorio);
        }
        // Variables 
        String productoBuscado;
        Producto productoVender;
        int cantidadVendida;
        int cantidadReponer;
        // Menú
        int opcionElegida;
        String menuOpciones = """
            Elige una de las siguientes opciones:
            1. Vender producto
            2. Reponer producto
            0. Salir
            """;
        Super8.mostrarInventario();
        do {
            opcionElegida = leerOpcionMenu(menuOpciones, 0, 2, scanner);

            if (opcionElegida == 1) {
                System.out.println("Escribe el ID del producto a vender. Ejemplo PTO-XXX");
                productoBuscado = scanner.nextLine();
                productoVender = Super8.buscarProductoId(productoBuscado);
                if (productoVender != null) {
                    System.out.println("Introduce la cantidad a vender de " + productoVender.getNombre() + " | Stock: " + productoVender.getCantidadEnStock());
                    cantidadVendida = scanner.nextInt();
                    Super8.venderProducto(productoVender, cantidadVendida);
                    scanner.nextLine();
                } else {
                    System.err.println("Producto no encontrado");
                }
            } else {
                System.out.println("Introduce el id del producto a reponer");
                productoBuscado = scanner.nextLine();
                System.out.println("Introduce la canridada a reponer");
                cantidadReponer = scanner.nextInt();
                Super8.reponerProducto(productoBuscado, cantidadReponer);
                scanner.nextLine();
            }
        } while (opcionElegida != 0);
        System.out.println("Has salido del programa");
    }
}
