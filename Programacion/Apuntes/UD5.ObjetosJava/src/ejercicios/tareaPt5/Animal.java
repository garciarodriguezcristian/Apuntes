package ejercicios.tareaPt5;

/**
 * Clase que representa un Animal dentro del sistema.
 *
 * Cada animal tiene un nombre, un código identificativo único, una cantidad de
 * ejemplares y un precio.
 *
 * El código se genera automáticamente utilizando un contador estático.
 */
public class Animal {

    public String nombre;

    /**
     * Código identificativo único del animal.
     */
    private String codigo;
    private int cantidad;
    private double precio;
    /**
     * Contador estático utilizado para generar códigos únicos de animal.
     */
    private static int numeroAnimal = 1;

    /**
     * Constructor de la clase Animal.
     *
     * Genera automáticamente un código único para cada animal creado.
     *
     * @param nombre Nombre del animal
     * @param cantidad Cantidad ejemplares
     * @param precio Precio del animal
     */
    public Animal(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        setCodigo();
        setCantidad(cantidad);
        this.precio = precio;
    }

    /**
     * Devuelve el código identificativo del animal.
     *
     * @return Código del animal
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Asigna el código al animal en formato "A-n".
     *
     * Incrementa el contador estático para el siguiente animal.
     *
     * @param numeroAnimal Número utilizado para generar el código
     */
    private void setCodigo() {
        this.codigo = "A-" + numeroAnimal;
        numeroAnimal++;
    }

    /**
     * Devuelve el nombre del animal.
     *
     * @return Nombre del animal
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Modifica el nombre del animal.
     *
     * @param nombre Nuevo nombre del animal
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la cantidad disponible del animal.
     *
     * @return Cantidad disponible
     */
    public int getCantidad() {
        return this.cantidad;
    }

    /**
     * Modifica la cantidad disponible del animal.
     *
     * @param cantidad Nueva cantidad disponible
     */
    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            cantidad = 0;
        }
        this.cantidad = cantidad;
    }

    /**
     * Devuelve el precio del animal.
     *
     * @return Precio del animal
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Modifica el precio del animal.
     *
     * @param precio Nueva precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nombre: " + nombre + " | Cantidad: " + cantidad + " | Precio: " + precio + " €";
    }

}
