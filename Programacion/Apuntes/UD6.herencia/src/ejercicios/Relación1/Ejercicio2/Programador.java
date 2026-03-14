package ejercicios.Relación1.Ejercicio2;

public class Programador extends Empleado {

    private final double BONIFICADOR = 1.5;

    private final double sueldo;

    public Programador(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
        this.sueldo = calcularSueldo();
    }

    public double getSueldo() {
        return sueldo;
    }

    private double calcularSueldo() {
        return this.sueldoBase * BONIFICADOR;
    }

    @Override
    public String toString() {
        return "Programador: " + super.toString() + " Sueldo = " + sueldo + " euros";
    }

}
