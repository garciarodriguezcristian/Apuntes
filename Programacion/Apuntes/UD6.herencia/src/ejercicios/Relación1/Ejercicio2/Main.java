package ejercicios.Relación1.Ejercicio2;
// Crea una clase Empleado con los atributos nombre y sueldoBase. 
// Luego, crea tres subclases: Programador, Diseñador y Gerente. 
// Cada subclase debe tener un método calcularSueldo() 
// que ajuste el sueldo base según un bonificador específico para cada tipo de empleado.
// private final double BONIFICADOR = 1.5

// Implementa una clase Main para probar la creación de objetos y la llamada al método calcularSueldo().
public class Main {

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Cristian", 1400);
        Programador programador1 = new Programador("Cris", 2000);
        Gerente gerente1 = new Gerente("Sergio", 2100);
        Diseniador diseniador1 = new Diseniador("Mayte", 1400);

        System.out.println(empleado1);
        System.out.println(programador1);
        System.out.println(empleado1.nombre);
        System.out.println(gerente1.getSueldo());
        System.out.println(diseniador1);
    }
}
