package ejercicios.relacion2.Ejercicio3;

public class Producto {

    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadEnStock;

    public Producto() {

    }

    public Producto(String id, String nombre, String descripcion, double precio, int cantidadEnStock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    @Override
    public String toString() {
        return "id = " + id + ", Nombre = " + nombre + ", Descripcion = " + descripcion + ", Precio = " + precio
                + " €, cantidadEnStock = " + cantidadEnStock + " uds.\n";
    }

}
