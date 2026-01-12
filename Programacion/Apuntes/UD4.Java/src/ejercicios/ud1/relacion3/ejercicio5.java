package ejercicios.ud1.relacion3;
// 5. Determinar si un número está en un rango:

// Solicita un número e indica si está entre 10 y 20 (inclusive).
import java.util.Scanner;

public class ejercicio5 {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroUsuario;

        System.out.println("Introduce un número");
        numeroUsuario = scanner.nextInt();
        scanner.close();

        if (numeroUsuario >= 10 && numeroUsuario <= 20) {
            System.out.println("El número " + numeroUsuario + " está entre 10 y 20");
        } else {
            System.out.println("El número " + numeroUsuario + "  NO está entre 10 y 20");
        }
    }
}
