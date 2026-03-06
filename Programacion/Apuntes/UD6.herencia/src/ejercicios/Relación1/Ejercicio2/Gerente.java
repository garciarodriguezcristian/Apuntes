package ejercicios.Relación1.Ejercicio2;

public class Gerente extends Empleado {

    private final double BONIFICADOR = 2;

    private double sueldo;

    public Gerente(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
        this.sueldo = calcularSueldo();
    }

    private double calcularSueldo() {
        return this.sueldoBase * BONIFICADOR;
    }

    @Override
    public String toString() {
        return "Gerente: " + super.toString() + " Sueldo = " + sueldo + " euros";
    }

}
