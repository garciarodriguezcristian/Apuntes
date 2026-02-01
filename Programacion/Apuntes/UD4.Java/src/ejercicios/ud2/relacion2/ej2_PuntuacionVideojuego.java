// 2. Sistema de Puntuación de un Videojuego
// Escribe un programa que gestione las puntuaciones de los jugadores en un videojuego utilizando dos arrays:
//  uno para los nombres de los jugadores y otro para sus respectivas puntuaciones. El programa debe funcionar de la siguiente manera:
// Crea dos arrays:
// Uno para almacenar los nombres de los últimos 5 jugadores.
// Otro para almacenar las puntuaciones correspondientes de esos jugadores.
// El programa debe mostrar un menú con las siguientes opciones:
//  1. Añadir un nuevo jugador y su puntuación: El usuario debe poder ingresar el nombre del jugador y su puntuación. 
// La información del jugador más antiguo (el primer elemento de ambos arrays) debe ser eliminada y 
// los nuevos datos deben añadirse al final de ambos arrays.
//  2. Mostrar los jugadores y sus puntuaciones actuales: Se deben mostrar los nombres de los jugadores junto con sus respectivas puntuaciones.
//  3. Salir del programa: Terminar la ejecución del programa.
package ejercicios.ud2.relacion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ej2_PuntuacionVideojuego {

    /**
     *
     * @param mensaje1 Pedir cadena
     * @param mensaje2 Pedir un número
     * @param arrayCadena
     * @param arrayNumero
     * @param scan
     */
    public static void aniadirElementosArrays(String mensaje1, String mensaje2, ArrayList<String> arrayCadena, ArrayList<Integer> arrayNumero, Scanner scan) {
        System.out.println(mensaje1);
        scan.nextLine();
        String nuevoJugador = scan.nextLine();
        int nuevaPuntuacion = -1;

        arrayCadena.add(nuevoJugador);
        do {
            System.out.println(mensaje2 + arrayCadena.getLast());
            if (scan.hasNextInt()) {
                nuevaPuntuacion = scan.nextInt();
                if (nuevaPuntuacion < 0 || nuevaPuntuacion > 100) {
                    System.out.println("Introduce un numero entre 0 y 100");
                } else {
                    arrayNumero.add(nuevaPuntuacion);
                }
            } else {
                scan.nextLine();
                System.out.println("Introduce solo valores numéricos");
            }
        } while (nuevaPuntuacion < 0 || nuevaPuntuacion > 100);
    }
//--------------------------------- MAIN ---------------------------------//

    public static void main(String[] args) {

        //Variables
        ArrayList<String> nombres = new ArrayList<>(Arrays.asList("Javi", "Ruben", "Alex", "Sem", "Iker"));
        ArrayList<Integer> puntuaciones = new ArrayList<>(Arrays.asList(70, 50, 60, 98, 78));
        Scanner scanner = new Scanner(System.in);
        int opcionElegida = 0;
        String menuOpciones = """
        Elige una de las siguientes opciones:
            1. Añadir nuevo jugador
            2. Mostrar jugadores
            3. Salir del programa
            """;
        do {
            System.out.println(menuOpciones);
            if (scanner.hasNextInt()) {
                opcionElegida = scanner.nextInt();
                if (opcionElegida == 1) {
                    
                    aniadirElementosArrays("Introduce el nombre del nuevo jugador", "Introduce la nueva puntuacion de ", nombres, puntuaciones, scanner);
                    nombres.removeFirst();
                    puntuaciones.removeFirst();
                    
                } else if (opcionElegida == 2) {
                    for (int i = 0; i < puntuaciones.size(); i++) {
                        System.out.println("Jugador: " + nombres.get(i) + "  ==>  " + puntuaciones.get(i) + " puntos.");
                    }
                } else {
                    if (opcionElegida != 3) {
                        System.out.println(" Opcion no válida");
                    }
                }
            } else {
                scanner.nextLine();
                System.out.println("Introduce un valor numérico");
            }
        } while (opcionElegida != 3);
        scanner.close();
    }
}
