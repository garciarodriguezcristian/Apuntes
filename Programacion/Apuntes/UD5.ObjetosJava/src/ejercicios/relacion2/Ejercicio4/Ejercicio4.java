package ejercicios.relacion2.Ejercicio4;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4 {

    public static void imprimirMensaje(String mensajeAMostrar) {
        System.out.println(mensajeAMostrar);
    }

    public static int leerEntero(String mensaje, Scanner sc) {
        int numero = 0;
        boolean correcto = false;

        while (!correcto) {
            try {
                imprimirMensaje(mensaje);
                numero = Integer.parseInt(sc.nextLine().trim());
                correcto = true;
            } catch (NumberFormatException e) {
                imprimirMensaje("Error: introduce un número entero valido");
            }
        }
        return numero;
    }

    public static int leerOpcionMenu(String mensaje, int min, int max, Scanner sc) {
        int opcion;
        boolean correcta = false;

        do {
            imprimirMensaje(mensaje);
            opcion = leerEntero("Elige una opcion:", sc);

            if (opcion >= min && opcion <= max) {
                correcta = true;
            } else {
                imprimirMensaje("Error: la opcion debe estar entre " + min + " y " + max);
            }
        } while (!correcta);
        return opcion;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList cancionesDisponibles = new ArrayList<>();
        ArrayList playlistDisponibles = new ArrayList<>();

        Cancion pista1 = new Cancion("Mirlo blanco", "Shinova", 3.30);
        Cancion pista2 = new Cancion("Torre Picasso", "Arde Bogotá", 6.50);
        cancionesDisponibles.add(pista1);
        cancionesDisponibles.add(pista2);

        Playlist indie = new Playlist();

        System.out.println(pista1);
        System.out.println(pista2);
        indie.agregarCanciones(pista1);
        indie.agregarCanciones(pista2);

        System.out.println(indie.mostrarCanciones());
        System.out.println(indie.mostrarCancionesTitulo());

        // Menú
        int opcionElegida;
        String menuOpciones = """
            Elige una de las siguientes opciones:
            1. Agregar canciones
            2. Mostrar canciones
            0. Salir
            """;

        do {
            opcionElegida = leerOpcionMenu(menuOpciones, 0, 2, scanner);
            if (opcionElegida == 1) {

                System.out.print("Introduce el título: ");
                String titulo = scanner.nextLine();

                System.out.print("Introduce el artista: ");
                String artista = scanner.nextLine();

                System.out.print("Introduce la duración (en minutos): ");
                double duracion = scanner.nextDouble();
                scanner.nextLine();

                Cancion nueva = new Cancion(titulo, artista, duracion);

                indie.agregarCanciones(nueva);

                System.out.println("Canción añadida correctamente.");

            } else if (opcionElegida == 2) {
                System.out.println(indie.mostrarCancionesTitulo());

            }

        } while (opcionElegida != 0);
        System.out.println("Has salido del programa");

        System.out.println(indie.mostrarCanciones());
        System.out.println("La duración de la Playlist es " + indie.duracionPlaylist() + " min");
    }
}
