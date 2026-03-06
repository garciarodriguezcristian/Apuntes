package ejercicios.Relación1.Ejercicio2;

public class Diseniador extends Empleado {

    private final double BONIFICADOR = 1.2;

    private double sueldo;

    public Diseniador(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
        this.sueldo = calcularSueldo();
    }

    private double calcularSueldo() {
        return this.sueldoBase * BONIFICADOR;
    }

    @Override
    public String toString() {
        return "Diseñador: " + super.toString() + " Sueldo = " + sueldo + " euros";
    }

}
