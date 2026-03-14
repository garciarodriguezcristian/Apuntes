package ejercicios.Relación1.Ejercicio4;

public class Animal {

    protected String nombre;
    protected String tipoAlimentacion;

    public Animal(String nombre, String tipoAlimentacion) {
        this.nombre = nombre;
        this.tipoAlimentacion = tipoAlimentacion;
    }

    @Override
    public String toString() {
        return nombre.toUpperCase() + ", tipoAlimentacion=" + tipoAlimentacion;
    }
}
