package ejercicios.relacion2.Ejercicio3;

import java.util.ArrayList;

public class Supermercado {

    ArrayList<Producto> productos;

    public Supermercado() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto nuevoProducto) {
        this.productos.add(nuevoProducto);
    }

    public void venderProducto(Producto producto, int cantidadVendida) {
        int cantidadProducto = producto.getCantidadEnStock();
        if (cantidadProducto < cantidadVendida) {
            System.out.println("Cantidad de " + producto.getNombre() + " insuficiente. Solo hay " + producto.getCantidadEnStock() + " disponibles");
        } else {
            cantidadProducto -= cantidadVendida;
            producto.setCantidadEnStock(cantidadProducto);
        }
    }

    public Producto buscarProductoId(String idProducto) {
        Producto encontradoId = null;
        for (Producto producto : productos) {
            if (producto.getId().equalsIgnoreCase(idProducto)) {
                encontradoId = producto;
            }
        }
        return encontradoId;
    }

    public Producto buscarProducto(String nombreProducto) {
        Producto encontrado = null;
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                encontrado = producto;
            }
        }
        return encontrado;
    }

    public void reponerProducto(String idProducto, int cantidadReponer) {
        Producto encontrado;
        encontrado = buscarProductoId(idProducto);
        if (encontrado != null) {
            encontrado.setCantidadEnStock(encontrado.getCantidadEnStock() + cantidadReponer);
            System.out.println("Producto repuesto");
            System.out.println("Producto: " + encontrado.getNombre() + "| Nuevo stock disponible: " + encontrado.getCantidadEnStock());
        } else {
            System.out.println("Producto no encontrado en el supermercado, añádelo al stock para poder reponerlo");
        }
    }

    public void mostrarInventario() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el supermercado");
        } else {
            for (Producto producto : this.productos) {
                System.out.println(producto);
            }
        }
    }

    @Override
    public String toString() {
        return " Inventario supermercado: \n " + productos + ".\n";
    }

}
