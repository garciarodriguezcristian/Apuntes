package ejercicios.Relación1.Ejercicio2;

public class Empleado {

    String nombre;
    double sueldoBase;

    public Empleado(String nombre, double sueldoBase) {
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre + " | Sueldo base = " + sueldoBase + " euros";
    }

}
