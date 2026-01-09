// let pesoEnLaTierra = prompt("Introduzca su peso: ")
// pesoEnLaTierra = Number(pesoEnLaTierra)

// let pesoEnLaLuna = pesoEnLaTierra * 0.165 // 16.5 / 100 = 0.165

// console.log("En la Luna pesarías: " + pesoEnLaLuna + "kg")

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce tu peso:");
        int pesoEnLaTierra = scanner.nextInt();
        double pesoEnLaLuna = pesoEnLaTierra * (16.5 / 100);
        System.out.println(" Tu peso en la luna sería: " + pesoEnLaLuna + "kg");
        scanner.close();
    }
}