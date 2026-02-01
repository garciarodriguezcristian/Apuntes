package ejercicios.repaso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ej1_tractoMatch {

    public static void mensajeRandomizadoEvaluacion(Boolean esApto) {
        ArrayList<String> mensajesApto = new ArrayList<>(Arrays.asList(
                "Perfecto: este tractor va sobrado para ese trabajo.",
                "¡Apto! Puedes ponerte a trabajar sin miedo.",
                "Buen combo de potencia y tarea: listo para el campo."
        ));

        ArrayList<String> mensajesNoApto = new ArrayList<>(Arrays.asList(
                "No apto: le falta fuerza para ese trabajo.",
                "Mejor no arriesgar: potencia insuficiente para la tarea.",
                "Se queda corto… necesitarías un tractor más potente."
        ));
        if (esApto) {
            System.out.println(mensajesApto.get((int) (Math.random() * mensajesApto.size())));
        } else {
            System.out.println(mensajesNoApto.get((int) (Math.random() * mensajesNoApto.size())));
        }
    }

    /**
     * imprime APTO o NO APTO
     *
     * @param aptoBoolean
     */
    public static void imprimirResultadoEvaluacion(Boolean aptoBoolean) {
        if (aptoBoolean) {
            imprimirMensaje("APTO");
        } else {
            imprimirMensaje("NO APTO");
        }
    }

    /**
     *
     * @param mensajeAMostrar
     */
    public static void imprimirMensaje(String mensajeAMostrar) {
        System.out.println(mensajeAMostrar);
    }

    /**
     * Lee una opcion valida de un menu
     *
     * @param mensaje Mensaje del menu a mostrar
     * @param min Valor minimo permitido
     * @param max Valor maximo permitido
     * @param sc Scanner ya creado en el main
     * @return opcion valida elegida por el usuario
     */
    public static int leerOpcionMenu(String mensaje, int min, int max, Scanner sc) {
        int opcion;
        boolean correcta = false;

        do {
            imprimirMensaje(mensaje);
            opcion = leerInt("Elige una opcion:", sc);

            if (opcion >= min && opcion <= max) {
                correcta = true;
            } else {
                imprimirMensaje("Error: la opcion debe estar entre " + min + " y " + max);
            }
        } while (!correcta);
        return opcion;
    }

    /**
     * Lee un numero entero del usuario con control de errores
     *
     * @param mensaje Mensaje que se muestra al usuario
     * @param sc Scanner ya creado en el main
     * @return numero entero valido introducido por el usuario
     */
    public static int leerInt(String mensaje, Scanner sc) {
        int numero = 0;
        boolean correcto = false;

        while (!correcto) {
            try {
                imprimirMensaje(mensaje);
                numero = Integer.parseInt(sc.nextLine());
                correcto = true;
            } catch (NumberFormatException e) {
                imprimirMensaje("Error: introduce un numero entero valido");
            }
        }
        return numero;
    }

    public static void mostrarArrayTriple(String mensaje, ArrayList<String> arrayTexto1, ArrayList<Integer> arrayValor, ArrayList<String> arrayTexto2) {
        imprimirMensaje(mensaje);

        for (int i = 0; i < arrayTexto1.size(); i++) {
            System.out.printf("%d -> %s | %d CV | trabajo: %s \n", i, arrayTexto1.get(i), arrayValor.get(i), arrayTexto2.get(i));
        }
    }
// ================================== MAIN ================================== //

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Arrays
        ArrayList<String> marcasTractores = new ArrayList<>(Arrays.asList("Fendt", "Claas", "Yamaha", "Kubota"));
        ArrayList<Integer> potenciaTractorCv = new ArrayList<>(Arrays.asList(200, 110, 100, 60));
        ArrayList<String> trabajoTractor = new ArrayList<>(Arrays.asList("arado", "transporte", "siembra", "transporte"));
        ArrayList<String> trabajosValidos = new ArrayList<>(Arrays.asList("arado", "transporte", "siembra"));

// Variables
        int opcionElegida;
        String tractor, tipoTrabajo;
        int potencia;
        int indiceEvaluar, potenciaEvaluar;
        String trabajoEvaluar, tractorEvaluar;
        int indiceTractorEliminar;
        Boolean apto = false;

// Menú
        String menuOpciones = """
            <===== MENU=====>:
            1. Añadir tractor
            2. Listar tractores
            3. Evaluar tractor (por índice)
            4. Eliminar tractor
            0. Salir
                """;

        do {
            opcionElegida = leerOpcionMenu(menuOpciones, 0, 4, scanner);

            // 1. Añadir tractor
            if (opcionElegida == 1) {

                //Pedir marca
                imprimirMensaje("Introduce la marca");
                tractor = scanner.nextLine();

                //Pedir potencia > 0
                do {
                    potencia = leerInt("Introduce la potencia", scanner);
                } while (potencia < 0);

                imprimirMensaje("Introduce tipo trabajo");

                //Pedir trabajo válido
                do {
                    tipoTrabajo = scanner.nextLine().toLowerCase();
                    if (!(trabajosValidos.contains(tipoTrabajo))) {
                        imprimirMensaje("Introduce un trabajo válido");
                    }
                } while (!(trabajosValidos.contains(tipoTrabajo)));

                marcasTractores.add(tractor);
                potenciaTractorCv.add(potencia);
                trabajoTractor.add(tipoTrabajo);

                // 2. Listar tractores
            } else if (opcionElegida == 2) {
                mostrarArrayTriple("Listado de tractores", marcasTractores, potenciaTractorCv, trabajoTractor);

                // 3. Evaluar tractor (por índice)
            } else if (opcionElegida == 3) {
                do {
                    indiceEvaluar = leerInt("Introduce un indice para evaluar el tractor", scanner);
                    if (indiceEvaluar < 0 || indiceEvaluar > potenciaTractorCv.size() - 1) {
                        System.out.println("Selecciona un indice entre 0 y " + (potenciaTractorCv.size() - 1));
                    }
                } while (indiceEvaluar < 0 || indiceEvaluar > potenciaTractorCv.size() - 1);
                potenciaEvaluar = potenciaTractorCv.get(indiceEvaluar);
                trabajoEvaluar = trabajoTractor.get(indiceEvaluar);
                tractorEvaluar = marcasTractores.get(indiceEvaluar);

                if (trabajoEvaluar.equalsIgnoreCase("arado") && potenciaEvaluar >= 120) {
                    apto = true;
                } else if (trabajoEvaluar.equalsIgnoreCase("transporte") && potenciaEvaluar >= 90) {
                    apto = true;
                } else if (trabajoEvaluar.equalsIgnoreCase("siembra") && potenciaEvaluar >= 70) {
                    apto = true;
                }
                imprimirMensaje("RESULTADO EVALUACIÓN");
                System.out.println("Tractor evaluado: " + tractorEvaluar);
                System.out.print("Evaluado para " + trabajoEvaluar + ": ");
                imprimirResultadoEvaluacion(apto);
                mensajeRandomizadoEvaluacion(apto);

                // 4. Eliminar tractor    
            } else {
                if (opcionElegida != 0) {
                    do {
                        indiceTractorEliminar = leerInt("Introduce el indice del tractor a eliminar", scanner);
                        if (!(indiceTractorEliminar < marcasTractores.size())) {
                            imprimirMensaje("Introduce un indice entre 0 y " + (marcasTractores.size() - 1));
                        }
                    } while (!(indiceTractorEliminar < marcasTractores.size()));
                    System.out.printf("Tractor < " + marcasTractores.get(indiceTractorEliminar) + " > ha sido eliminado de la lista \n");
                    marcasTractores.remove(indiceTractorEliminar);
                    potenciaTractorCv.remove(indiceTractorEliminar);
                    trabajoTractor.remove(indiceTractorEliminar);
                    mostrarArrayTriple("Listado de tractores", marcasTractores, potenciaTractorCv, trabajoTractor);
                }
            }

        } while (opcionElegida != 0);
        System.out.println("Has salido del programa");
        scanner.close();
    }
}
