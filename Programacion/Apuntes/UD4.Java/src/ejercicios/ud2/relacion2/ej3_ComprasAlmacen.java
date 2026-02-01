// 3. Sistema de Compras en Almacén
// Desarrolla un programa que gestione las compras en un almacén. Para esto:
// Crea un array que contenga los nombres de 10 productos disponibles en el almacén.
// Crea otro array que contenga los precios correspondientes a esos 10 productos.
// El programa debe permitir al usuario realizar una compra solicitando el nombre del producto y la cantidad deseada.
// El programa debe buscar el precio del producto seleccionado, multiplicarlo por la cantidad y añadirlo al total de la compra.
// Si el usuario escribe "FIN", el programa debe finalizar la compra, mostrando un resumen con todos los productos adquiridos,
//  sus cantidades, y el costo total a pagar.
package ejercicios.ud2.relacion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ej3_ComprasAlmacen {

    public static String capitalizarPrimeraLetra(String palabra) {
        palabra = palabra.toLowerCase();
        char primeraLetraPalabra = Character.toUpperCase(palabra.charAt(0));
        palabra = primeraLetraPalabra + palabra.substring(1);
        return palabra;
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        //Variables
        ArrayList<String> productos = new ArrayList<>(Arrays.asList("arroz", "leche", "aceite", "azucar", "harina", "pasta", "atun", "tomate", "cafe", "galletas"));
        ArrayList<Double> precioProductos = new ArrayList<>(Arrays.asList(1.20, 0.90, 6.50, 1.10, 0.95, 1.00, 1.30, 1.50, 3.80, 1.75));
        ArrayList<String> productosComprados = new ArrayList<>();
        ArrayList<Integer> cantidadComprada = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String productoSeleccionado;
        int cantidadSeleccionada;
        double precioProductoSeleccionado;
        double totalProducto;
        double totalCompra = 0;

        do {
            System.out.println("Introduce el producto deseado");
            productoSeleccionado = (scanner.nextLine().toLowerCase());
            
            if (productos.contains(productoSeleccionado)) {
                System.out.println("Introduce la cantidad deseada");
                cantidadSeleccionada = scanner.nextInt();
                productosComprados.add(capitalizarPrimeraLetra(productoSeleccionado));
                cantidadComprada.add(cantidadSeleccionada);
                precioProductoSeleccionado = precioProductos.get(productos.indexOf(productoSeleccionado));
                totalProducto = precioProductoSeleccionado * cantidadSeleccionada;
                totalCompra += totalProducto;
                scanner.nextLine();
            } else {
                if (!productoSeleccionado.equals("fin")) {
                    System.out.println("Producto no encontrado");
                }
            }
        } while (!productoSeleccionado.equals("fin"));
        scanner.close();
        System.out.println("INFORMACION DE LA COMPRA");
        for (int i = 0; i < productosComprados.size(); i++) {
            System.out.println(productosComprados.get(i) + " = " + cantidadComprada.get(i) + " uds");
        }
        System.out.println(" Total compra = " + totalCompra + " €");
    }
}
