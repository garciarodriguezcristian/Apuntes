
// Ejercicio 2 – Bucle while
// Escribe un programa que pida al usuario un número secreto (entre 1 y 10).
// Después, el programa debe pedir al jugador que adivine el número hasta que lo consiga, mostrando un mensaje de “Intenta de nuevo” cuando falle.
// Cuando acierte, debe mostrar:
// ¡Correcto! Has adivinado el número.
import java.util.Scanner;

public class ejercicio2 {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numeroSecreto;
        int numeroUsuario;

        System.out.println("Introduce un número del 1 al 10");
        numeroSecreto = scanner.nextInt();

        System.out.println("Introduce un numero del 1 al 10 para adivinar el número secreto");
        numeroUsuario = scanner.nextInt();
        
        while (numeroSecreto != numeroUsuario) {
            System.out.println("Intenta de nuevo");
            numeroUsuario = scanner.nextInt();
        }
        scanner.close();
        System.out.println("¡Correcto! Has adivinado el número");
    }
}
