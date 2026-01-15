package ejercicios.ud1.relacion1;

// let pesoEnLaTierra = prompt("Introduzca su peso: ")
// pesoEnLaTierra = Number(pesoEnLaTierra)
// let pesoEnLaLuna = pesoEnLaTierra * 0.165 // 16.5 / 100 = 0.165
// console.log("En la Luna pesarías: " + pesoEnLaLuna + "kg")
import java.util.Scanner;

public class Ejercicio5 {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        final double GRAVEDADLUNA = 0.165;
        Scanner scanner = new Scanner(System.in);
        double pesoEnLaTierra;
        double pesoEnLaLuna;

        System.out.println("Introduce tu peso:");

        pesoEnLaTierra = scanner.nextDouble();
        pesoEnLaLuna = pesoEnLaTierra * GRAVEDADLUNA;

        System.out.println(" Tu peso en La Luna sería: " + pesoEnLaLuna + "kg");
        scanner.close();
    }
}
