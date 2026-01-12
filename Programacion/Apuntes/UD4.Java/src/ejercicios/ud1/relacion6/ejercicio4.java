package ejercicios.ud1.relacion6;

//     4. Calculadora de combustible
// Crea un programa que pida una cantidad de litros inicial, un precio por litro y un consumo cada 100 km, 
// y vaya calculando el precio de cada viaje (pidiendo los kilómetros) y el combustible restante. 
// Si no hay combustible suficiente, debe avisar al usuario.
// Ejemplo:
// Introduce el combustible inicial: 50
// Precio del litro de combustible: 1.45
// Consumo cada 100km: 5.6
// Introduce los kilómetros del viaje 1: 50
// Precio del viaje: 4.06€
// Combustible restante: 47.2 litros
// Introduce los kilómetros del viaje 2: 200
// Precio del viaje: 16.24€
// Combustible restante: 36 litros
// Introduce los kilómetros del viaje 3: 1000
// ¡Combustible insuficiente!
//-----------------------------------------------------------------------------------------------------//
import java.util.Scanner;

public class ejercicio4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double precioCombustible;
        double consumoCada100Km;
        double combustibleRestante;
        int kmViaje;
        double precioViaje;
        int numeroViaje = 1;
        double litrosGastadosViaje;

        System.out.println("Introduce el combustible inicial:");
        combustibleRestante = scanner.nextInt();
        System.out.println("Introduce el precio del litro de combustible:");
        precioCombustible = scanner.nextDouble();
        System.out.println("Introduce el consumo cada 100 Km:");
        consumoCada100Km = scanner.nextDouble();

        while (combustibleRestante > 0) {
            System.out.println("Introduce los kilómetros del viaje " + numeroViaje + ":");
            kmViaje = scanner.nextInt();
            scanner.close();
            litrosGastadosViaje = (consumoCada100Km * kmViaje / 100);
            precioViaje = litrosGastadosViaje * precioCombustible;
            combustibleRestante -= litrosGastadosViaje;

            if (litrosGastadosViaje <= combustibleRestante) {
                System.out.println("Precio del viaje " + numeroViaje + ": " + precioViaje + " €");
                System.out.println("Combustible restante: " + combustibleRestante + " L");
                numeroViaje++;
            } else {
                System.out.println("¡Combustible insuficiente");
            }
        }
    }
}
