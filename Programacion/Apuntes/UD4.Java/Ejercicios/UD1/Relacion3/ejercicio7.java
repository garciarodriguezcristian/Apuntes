
import java.util.Scanner;

// 7. Simular una calculadora simple:
// Pide dos números y una operación (+, -, *, /) e imprime el resultado correspondiente.
public class ejercicio7 {

    @SuppressWarnings({"ConvertToTryWithResources", "ConvertToStringSwitch"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numero1;
        double numero2;
        String operacion;
        double resultado = 0;

        System.out.println("Introduce el primer número");
        numero1 = scanner.nextDouble();
        System.out.println("Introduce el segundo número");
        numero2 = scanner.nextDouble();
        System.out.println("Elige una de las siguentes operaciones:+, -, * o / ");
        operacion = scanner.next();
        scanner.close();

        if (operacion.equals("+")) {
            resultado = numero1 + numero2;
        } else if (operacion.equals("-")) {
            resultado = numero1 - numero2;
        } else if (operacion.equals("*")) {
            resultado = numero1 * numero2;
        } else if (operacion.equals("/")) {
            if (numero2 == 0) {
                System.out.println("No se puede dividir entre 0");
            } else {
                resultado = numero1 / numero2;
            }
        }
        System.out.printf("El resultado es: %.4f\n", resultado);
    }
}
