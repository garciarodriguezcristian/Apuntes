// Escribe un programa que pida al usuario un número entero positivo y muestre la tabla de multiplicar de ese número (del 1 al 10) usando un bucle for.
// 👉 Ejemplo de salida si el usuario introduce 3:
// 3 x 1 = 3  
// 3 x 2 = 6  
// 3 x 3 = 9  
// ...  
// 3 x 10 = 30

import java.util.Scanner;

public class ejercicio1 {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Variables
        int numeroUsuario;
        int resultado;

        //Pido el numero
        System.out.println("Introduce un número entero positivo");
        numeroUsuario = scanner.nextInt();
        scanner.close();

        for (int i = 1; i <= 10; i++) {
            resultado = numeroUsuario * i;
            System.out.println(numeroUsuario + " X " + i + " = " + resultado);
        }
    }
}
