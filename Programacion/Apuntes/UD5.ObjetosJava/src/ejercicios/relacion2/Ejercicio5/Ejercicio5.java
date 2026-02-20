package ejercicios.relacion2.Ejercicio5;

import java.util.Scanner;

import ejercicios.relacion2.Faker;

public class Ejercicio5 {

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
        Cine Kinepolis = new Cine();

        Pelicula pelicula1 = new Pelicula("Zohan deja su trabajo de espía para cumplir su sueño",
                "Dennis Dugan", 113, "No te metas con el ZOHAN");
        Pelicula pelicula2 = new Pelicula("Un drama romántico que narra la turbulenta relación entre Heathcliff y Catherine desde la infancia hasta la adultez.",
                "Esmerald Fennell", 136, "Cumbres borrascosas");

        Kinepolis.agregarPelicula(pelicula1);
        Kinepolis.agregarPelicula(pelicula2);

        System.out.println("Pruebo buscarPeliculaTitulo()");
        System.out.println(Kinepolis.buscarPeliculaTitulo("Ori"));
        // ======= FAKER ========= // 
        Pelicula aleatoria = new Pelicula();
        final int MAXIMO_PELICULAS = 5;
        for (int i = 0; i < MAXIMO_PELICULAS; i++) {
            aleatoria = new Pelicula(Faker.loremCorto(), Faker.nombreCompleto(), Faker.entero(90, 400), "Pelicula" + i);
            Kinepolis.agregarPelicula(aleatoria);
        }

        // Menú
        int opcionElegida;
        String menuOpciones = """
            Elige una de las siguientes opciones:
            1. Agregar peliculas
            2. Mostrar todas las peliculas
            3. Busca una película por su título
            4. Ver duración media de las peliculas del cine
            0. Salir
            """;
        String titulo = "";
        do {
            opcionElegida = leerOpcionMenu(menuOpciones, 0, 4, scanner);
            // 1. Agregar peliculas
            if (opcionElegida == 1) {
                System.out.print("Introduce el título: ");
                titulo = scanner.nextLine();

                System.out.print("Introduce el director: ");
                String director = scanner.nextLine();

                System.out.print("Introduce la duración (en minutos): ");
                int duracion = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Introduce la sinopsis");
                String sinopsis = scanner.nextLine();
                Pelicula nueva = new Pelicula(sinopsis, director, duracion, titulo);

                Kinepolis.agregarPelicula(nueva);
                System.out.println("Película añadida correctamente.");

                // 2. Mostrar todas las peliculas
            } else if (opcionElegida == 2) {
                Kinepolis.mostrarPeliculas();

                // 3. Busca una película por su título
            } else if (opcionElegida == 3) {
                System.out.print("Introduce el título de la pelicula a buscar: ");
                titulo = scanner.nextLine();
                Pelicula buscada = Kinepolis.buscarPeliculaTitulo(titulo);

                if (buscada != null) {
                    System.out.println(buscada);
                } else {
                    System.err.println("La película no existe");
                }

                //4. Ver duración media de las peliculas del cine
            } else if (opcionElegida == 4) {
                System.out.println("La duración media de las peliculas del cine es " + Kinepolis.duracionMediaPeliculas() + " minutos aprox");
            }

        } while (opcionElegida != 0);
        System.out.println("Has salido del programa");
    }
}
