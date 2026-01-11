
import java.util.Scanner;

//     6. Calculadora básica
// Crea una calculadora básica de dos números. El programa pide dos números y luego una operación (+, -, *, /). 
// El programa pide números hasta que el usuario indique "SALIR".
// Ejemplo:
// Introduce el primer número: 4
// Introduce el segundo número: 5
// Introduce la operación: +
// El resultado de 4 + 5 es 9
// Introduce el primer número: 3
// Introduce el segundo número: 4
// Introduce la operación: *
// El resultado de 3 * 4 es 12
// Introduce el primer número: SALIR
public class ejercicio6 {

    @SuppressWarnings({"ConvertToStringSwitch", "ConvertToTryWithResources"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double numero1;
        double numero2;
        String operacion;
        double resultado = 0;
        String entrada = "";

        while (!entrada.equalsIgnoreCase("SALIR")) {
            System.out.println("Introduce el primer número");
            entrada = scanner.nextLine();
            if (!entrada.equalsIgnoreCase("SALIR")) {
                numero1 = Double.parseDouble(entrada);
                System.out.println("Introduce el segundo número");
                numero2 = scanner.nextDouble();
                System.out.println("Elige una de las siguentes operaciones:+, -, * o / ");
                operacion = scanner.next();

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
                scanner.nextLine();
                System.out.printf("El resultado es: %.2f\n", resultado);
            }
        }
        scanner.close();
    }
}
