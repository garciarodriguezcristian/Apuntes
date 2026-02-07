package ejercicios.repaso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ej3_subastaTractores {

    public static int buscarIndiceArrayString(String mensaje, ArrayList<String> array, Scanner sc) {
        int indiceUsuario;
        do {
            indiceUsuario = leerInt(mensaje, sc);
            if (indiceUsuario < 0 || indiceUsuario > array.size() - 1) {
                imprimirMensaje("Introduce un indice de 0 a " + (array.size() - 1));
            }
        } while (indiceUsuario < 0 || indiceUsuario > array.size() - 1);
        return indiceUsuario;
    }

    public static void mostrar4Arrays(String mensaje, ArrayList<String> arrayTexto1, ArrayList<Integer> arrayValor1, ArrayList<Integer> arrayValor2, ArrayList<String> arrayTexto2) {
        imprimirMensaje(mensaje);

        for (int i = 0; i < arrayTexto1.size(); i++) {
            System.out.printf("%d -> %s | inicial: %d | mejor puja: %d | postor: %s\n", i, arrayTexto1.get(i), arrayValor1.get(i), arrayValor2.get(i), arrayTexto2.get(i));
        }
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
     *
     * @param mensajeAMostrar
     */
    public static void imprimirMensaje(String mensajeAMostrar) {
        System.out.println(mensajeAMostrar);
    }

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
        ArrayList<String> modelosLote = new ArrayList<>(Arrays.asList("lote1", "lote2", "lote3"));
        ArrayList<Integer> preciosIniciales = new ArrayList<>(Arrays.asList(1000, 6000, 10000));
        ArrayList<Integer> mejoresPujas = new ArrayList<>(Arrays.asList(0, 0, 0));
        ArrayList<String> mejoresPostores = new ArrayList<>(Arrays.asList("NADIE", "NADIE", "NADIE"));

        String modelo;
        int precioInicial;
        int indiceBuscar;
        String nuevoPostor;
        int nuevaPuja;
        final int PUJAINICIAL = 0;
        final String POSTORINICIAL = "NADIE";

        int opcionElegida;

        String menuOpciones = """
            <===== MENU=====>:
            1. Añadir lote
            2. Listar lotes
            3. Hacer puja (por índice)
            4. Ver ganador actual (por índice)
            5. Eliminar lote (por índice)
            0. Salir
                """;

        do {
            opcionElegida = leerOpcionMenu(menuOpciones, 0, 5, scanner);

            if (opcionElegida == 1) {
                imprimirMensaje("Añade el nombre el lote");
                modelo = scanner.nextLine();
                do {
                    precioInicial = leerInt("Introduce el precio inicial de lote", scanner);
                    if (precioInicial < 0) {
                        imprimirMensaje("Introduce un valor mayor que 0");
                    }
                } while (precioInicial < 0);
                modelosLote.add(modelo);
                preciosIniciales.add(precioInicial);
                mejoresPujas.add(PUJAINICIAL);
                mejoresPostores.add(POSTORINICIAL);

            } else if (opcionElegida == 2) {
                mostrar4Arrays("LISTADO LOTES", modelosLote, preciosIniciales, mejoresPujas, mejoresPostores);

            } else if (opcionElegida == 3) {
                indiceBuscar = buscarIndiceArrayString("Introduce el indice del lote por el que quieres pujar", modelosLote, scanner);
                imprimirMensaje("Introduce el nombre del postor");
                nuevoPostor = scanner.nextLine();
                do {
                    nuevaPuja = leerInt("Introduce la cantidad a pujar", scanner);
                    if (nuevaPuja < 0) {
                        imprimirMensaje("Introduce un valor mayor que 0");
                    }
                } while (nuevaPuja < 0);
                if (nuevaPuja >= preciosIniciales.get(indiceBuscar) && nuevaPuja > mejoresPujas.get(indiceBuscar)) {
                    imprimirMensaje("Puja aceptada");
                    mejoresPujas.set(indiceBuscar, nuevaPuja);
                    mejoresPostores.set(indiceBuscar, nuevoPostor);
                } else {
                    imprimirMensaje("¡Puja rechazada!");
                    if (nuevaPuja < preciosIniciales.get(indiceBuscar)) {
                        imprimirMensaje("Puja inferior a " + preciosIniciales.get(indiceBuscar));
                    } else {
                        imprimirMensaje("No supera la mejor puja");
                    }
                }

            } else if (opcionElegida == 4) {
                indiceBuscar = buscarIndiceArrayString("Introduce el indice para ver el ganador actual", modelosLote, scanner);
                if (mejoresPujas.get(indiceBuscar) == 0) {
                    imprimirMensaje("Este lote no aún no tiene pujas");
                } else {
                    System.out.println(mejoresPostores.get(indiceBuscar) + " es el ganador actual con una puja de " + mejoresPujas.get(indiceBuscar));
                }
            } else {
                if (opcionElegida != 0) {
                    if (modelosLote.isEmpty()) {
                        imprimirMensaje("No hay lotes para eliminar.");
                    } else {
                        indiceBuscar = buscarIndiceArrayString("Introduce el indice del lote a eliminar", modelosLote, scanner);
                        System.out.printf("Lote eliminado:\n %d -> %s | inicial: %d | mejor puja: %d | postor: %s%n",
                                indiceBuscar, modelosLote.get(indiceBuscar), preciosIniciales.get(indiceBuscar), mejoresPujas.get(indiceBuscar), mejoresPostores.get(indiceBuscar));
                        modelosLote.remove(indiceBuscar);
                        preciosIniciales.remove(indiceBuscar);
                        mejoresPujas.remove(indiceBuscar);
                        mejoresPostores.remove(indiceBuscar);
                    }
                }
            }
        } while (opcionElegida != 0);
        System.out.println("Has salido del programa");
    }
}
