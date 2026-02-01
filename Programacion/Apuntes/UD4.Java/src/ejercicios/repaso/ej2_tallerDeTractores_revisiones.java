package ejercicios.repaso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ej2_tallerDeTractores_revisiones {

    public static int buscarIndiceArrayString(ArrayList<String> array, Scanner sc) {
        int indiceUsuario;
        do {
            indiceUsuario = leerInt("Introduce el indice de la revisión para mostrar su coste", sc);
            if (indiceUsuario < 0 || indiceUsuario > array.size()) {
                imprimirMensaje("Introduce un indice de 0 a " + (array.size() - 1));
            }
        } while (indiceUsuario < 0 || indiceUsuario > array.size());
        return indiceUsuario;
    }

    public static int buscarIndiceArrayDouble(ArrayList<Double> array, Scanner sc) {
        int indiceUsuario;
        do {
            indiceUsuario = leerInt("Introduce el indice de la revisión para mostrar su coste", sc);
            if (indiceUsuario < 0 || indiceUsuario > array.size()) {
                imprimirMensaje("Introduce un indice de 0 a " + (array.size() - 1));
            }
        } while (indiceUsuario < 0 || indiceUsuario > array.size());
        return indiceUsuario;
    }

    public static void mostrar4Arrays(String mensaje, ArrayList<String> arrayTexto1, ArrayList<String> arrayTexto2, ArrayList<Integer> arrayValor1, ArrayList<Double> arrayValor2) {
        imprimirMensaje(mensaje);

        for (int i = 0; i < arrayTexto1.size(); i++) {
            System.out.printf("%d -> %s | %s | extras: %d | coste: %.2f €\n", i, arrayTexto1.get(i), arrayTexto2.get(i), arrayValor1.get(i), arrayValor2.get(i));
        }
    }

    private static boolean matriculaTieneDescuento(String matriculaComprobar) {
        boolean tieneDescuento = false;
        char caracter = matriculaComprobar.charAt(3);

        if (Character.isDigit(caracter)) {
            int numero = Character.getNumericValue(caracter);
            if (numero % 2 == 0) {
                tieneDescuento = true;
            }
        }

        return tieneDescuento;
    }

    private static double calcularCosteRevision(String matriculaTractor, String revision, int cantidadDeExtras) {
        double costeTotalRevision;
        final int COSTEBASICA = 60;
        final int COSTECOMPLETA = 120;
        final int COSTEPOREXTRA = 15;
        final int DESCUENTO = 10 / 100;
        if (revision.equals("basica")) {
            costeTotalRevision = COSTEBASICA;
        } else {
            costeTotalRevision = COSTECOMPLETA;
        }
        costeTotalRevision += (COSTEPOREXTRA * cantidadDeExtras);
        if (matriculaTieneDescuento(matriculaTractor)) {
            costeTotalRevision -= costeTotalRevision * DESCUENTO;
        }
        return costeTotalRevision;
    }

    /**
     *
     * @param mensajeAMostrar
     */
    public static void imprimirMensaje(String mensajeAMostrar) {
        System.out.println(mensajeAMostrar);
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

// ================================== MAIN ================================== //
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Declaro arrays
        ArrayList<String> matriculas = new ArrayList<>(Arrays.asList("7228HXK", "2482DMR", "3417DJP"));
        ArrayList<String> revisiones = new ArrayList<>(Arrays.asList("basica", "completa", "completa"));
        ArrayList<String> revisionesDisponibles = new ArrayList<>(Arrays.asList("basica", "completa"));
        ArrayList<Integer> cantidadExtras = new ArrayList<>(Arrays.asList(0, 2, 1));
        ArrayList<Double> costeFinal = new ArrayList<>(Arrays.asList(51.0, 127.5, 135.0));

        //Variables
        int opcionElegida;
        String matricula, tipoRevision;
        int numExtras;
        double costeRevision;
        int indiceBuscar;

        String menuOpciones = """
            <===== MENU=====>:
            1. Añadir revision
            2. Listar revisiones
            3. Mostrar coste (por índice)
            4. Eliminar revisión
            0. Salir
                """;

        do {
            opcionElegida = leerOpcionMenu(menuOpciones, 0, 4, scanner);

            if (opcionElegida == 1) {
                imprimirMensaje("Introduce la matricula");
                matricula = scanner.nextLine();
                imprimirMensaje("Introduce que revisión quieres hacer: Básica (60€) o Completa (120€).");
                do {
                    tipoRevision = scanner.nextLine().toLowerCase();
                    if (!(revisionesDisponibles.contains(tipoRevision))) {
                        imprimirMensaje("Introduce Basica o Completa");
                    }
                } while (!revisionesDisponibles.contains(tipoRevision));
                do {
                    numExtras = leerInt("Introduce el número de extras que deseas añadir", scanner);
                } while (numExtras < 0);
                costeRevision = calcularCosteRevision(matricula, tipoRevision, numExtras);
                matriculas.add(matricula);
                revisiones.add(tipoRevision);
                cantidadExtras.add(numExtras);
                costeFinal.add(costeRevision);

            } else if (opcionElegida == 2) {
                mostrar4Arrays("LISTA DE REVISIONES", matriculas, revisiones, cantidadExtras, costeFinal);

            } else if (opcionElegida == 3) {
                indiceBuscar = buscarIndiceArrayDouble(costeFinal, scanner);
                // do {
                //     indiceBuscar = leerInt("Introduce el indice de la revisión para mostrar su coste", scanner);
                //     if (indiceBuscar < 0 || indiceBuscar > costeFinal.size()) {
                //         imprimirMensaje("Introduce un indice de 0 a " + (costeFinal.size() - 1));
                //     }
                // } while (indiceBuscar < 0 || indiceBuscar > costeFinal.size());
                System.out.println("Coste de la revisión buscada");
                System.out.println(costeFinal.get(indiceBuscar) + " €");
                if (matriculaTieneDescuento(matriculas.get(indiceBuscar))) {
                    imprimirMensaje("Revisión con 10% de descuento");
                } else {
                    imprimirMensaje("Revisión sin descuento");
                }
            } else {
                if (opcionElegida != 0) {
                    indiceBuscar = buscarIndiceArrayString(matriculas, scanner);
                    matriculas.remove(indiceBuscar);
                    revisiones.remove(indiceBuscar);
                    cantidadExtras.remove(indiceBuscar);
                    costeFinal.remove(indiceBuscar);
                }
            }

        } while (opcionElegida != 0);
        System.out.println("Has salido del programa");
        scanner.close();
    }

}
