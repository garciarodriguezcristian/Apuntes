package ejercicios.repaso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ej4_rutasReparto {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> tractores = new ArrayList<>();
        ArrayList<Double> kilometros = new ArrayList<>();
        ArrayList<Double> litrosDisponibles = new ArrayList<>();
        ArrayList<String> terrenos = new ArrayList<>();
        ArrayList<String> terrenosValidos = new ArrayList<>(Arrays.asList("llano", "mixto", "montaña"));

        int opcionElegida;

        // String nombreTractor, terreno;
        // double kmRuta, litros;
        double litrosNecesarios;
        boolean esViable;
        double litrosFaltantes;

        final double CONSUMOLLANO = 0.12, CONSUMOMIXTO = 0.18, CONSUMOMONTANIA = 0.25;
        double consumo;
        int indiceBuscar;

        String menuOpciones = """
        Elige una de las siguientes opciones:
            1. Añadir ruta
            2. Listar rutas
            3. Calcular consumo (por índice)
            4. Elimina ruta (por indice)
            0. Salir
            """;

        do {
            opcionElegida = leerOpcionMenu(menuOpciones, 0, 4, scanner);
            
            //Añadir ruta
            if (opcionElegida == 1) {
                aniadirRuta(scanner, tractores, kilometros, litrosDisponibles, terrenos, terrenosValidos);

                // Listar rutas
            } else if (opcionElegida == 2) {
                listarRutas("LISTA DE RUTAS", tractores, kilometros, litrosDisponibles, terrenos);

            } else if (opcionElegida == 3) {
                if (terrenos.isEmpty()) {
                    imprimirMensaje("No hay rutas para calcular consumo");
                } else {
                    indiceBuscar = buscarIndiceArrayString("Introduce indice de ruta para calcular consumo", terrenos, scanner);
                    //Calcular litros necesarios
                    if (terrenos.get(indiceBuscar).equals("llano")) {
                        consumo = CONSUMOLLANO;
                    } else if (terrenos.get(indiceBuscar).equals("mixto")) {
                        consumo = CONSUMOMIXTO;
                    } else {
                        consumo = CONSUMOMONTANIA;
                    }

                    litrosNecesarios = consumo * kilometros.get(indiceBuscar);
                    if (litrosDisponibles.get(indiceBuscar) >= litrosNecesarios) {
                        esViable = true;
                    } else {
                        esViable = false;
                        litrosFaltantes = (litrosNecesarios - litrosDisponibles.get(indiceBuscar));
                        System.out.println("Faltan " + litrosFaltantes + "L para realizar el trayecto");
                    }
                    imprimirMensaje(mostrarMensajeRandom(esViable));
                }

            } else if (opcionElegida == 4) {
                if (terrenos.isEmpty()) {
                    imprimirMensaje("La lista de rutas ya está vacia");
                } else {
                    indiceBuscar = buscarIndiceArrayString("Indice de ruta a eliminar", terrenos, scanner);
                    mostrarRutaIndice("Ruta eliminada: ", tractores, kilometros, litrosDisponibles, terrenos, indiceBuscar);

                    tractores.remove(indiceBuscar);
                    kilometros.remove(indiceBuscar);
                    litrosDisponibles.remove(indiceBuscar);
                    terrenos.remove(indiceBuscar);
                }
            } else {
                imprimirMensaje("Saliendo del programa...");
            }

        } while (opcionElegida != 0);
        scanner.close();
        System.out.println("Has salido del programa");
    }

    // =============== FUNCIONES =================//
    public static void mostrarRutaIndice(String mensaje,
            ArrayList<String> arrayTexto1,
            ArrayList<Double> arrayValor1,
            ArrayList<Double> arrayValor2,
            ArrayList<String> arrayTexto2,
            int indice) {
        imprimirMensaje(mensaje);

        System.out.printf("%d -> %s | %.2f km | %.2f L | terreno: %s\n",
                indice, arrayTexto1.get(indice),
                arrayValor1.get(indice),
                arrayValor2.get(indice),
                arrayTexto2.get(indice));
    }

    public static String elementoAleatorio(ArrayList<String> array) {
        int posicion;
        String elemento;

        posicion = (int) (Math.random() * array.size());
        elemento = array.get(posicion);

        return elemento;
    }

    public static String mostrarMensajeRandom(boolean viajeViable) {
        String mensaje;
        ArrayList<String> mensajesViable = new ArrayList<>(Arrays.asList(
                "Perfecto: este tractor va sobrado para esta ruta.",
                "¡Ruta viable! Puedes ponerte en marcha sin miedo.",
                "Buen combo de km y combustible: listo para la ruta."
        ));

        ArrayList<String> mensajesNoViable = new ArrayList<>(Arrays.asList(
                "Ruta no viable: falta combustible para ese trayecto.",
                "Mejor no arriesgar: combustible insuficiente para la ruta.",
                "Demsaidos kilometros… necesitas más litros para completar la ruta."
        ));
        if (viajeViable) {
            mensaje = elementoAleatorio(mensajesViable);
        } else {
            mensaje = elementoAleatorio(mensajesNoViable);
        }

        return mensaje;
    }

    public static int buscarIndiceArrayString(String mensaje, ArrayList<String> array, Scanner sc) {
        int indiceUsuario;
        do {
            indiceUsuario = leerEntero(mensaje, sc);
            if (indiceUsuario < 0 || indiceUsuario > array.size() - 1) {
                imprimirMensaje("Introduce un indice de 0 a " + (array.size() - 1));
            }
        } while (indiceUsuario < 0 || indiceUsuario > array.size() - 1);
        return indiceUsuario;
    }

    public static String comprobarTerrenoValido(Scanner sc, ArrayList<String> terrenosValidos) {
        String terreno = "";
        boolean terrenoValido = false;

        imprimirMensaje("Terreno (llano / mixto / montaña):");
        while (!terrenoValido) {
            terreno = sc.nextLine().trim().toLowerCase();
            if (terrenosValidos.contains(terreno)) {
                terrenoValido = true;
            } else {
                imprimirMensaje("Terreno no válido. (llano / mixto / montaña)");
            }
        }
        return terreno;
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

    public static int leerEntero(String mensaje, Scanner sc) {
        int numero = 0;
        boolean correcto = false;

        while (!correcto) {
            try {
                imprimirMensaje(mensaje);
                numero = Integer.parseInt(sc.nextLine().trim());
                correcto = true;
            } catch (NumberFormatException e) {
                imprimirMensaje("Error: introduce un numero entero valido");
            }
        }
        return numero;
    }

    static double leerDoubleMayorCero(String mensaje, Scanner sc) {
        double numero = 0.0;
        boolean valido = false;

        while (!valido) {
            imprimirMensaje(mensaje);
            try {
                numero = Double.parseDouble(sc.nextLine().trim());
                valido = numero > 0;
                if (!valido) {
                    imprimirMensaje("Debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                imprimirMensaje("Introduce un valor numerico válido.");
            }
        }
        return numero;
    }

    public static void imprimirMensaje(String mensajeAMostrar) {
        System.out.println(mensajeAMostrar);
    }

    public static void listarRutas(String mensaje,
            ArrayList<String> tractores,
            ArrayList<Double> kilometros,
            ArrayList<Double> litrosDisponibles,
            ArrayList<String> terrenos) {
        if (tractores.isEmpty()) {
            imprimirMensaje("No hay rutas para listar");
        } else {
            imprimirMensaje(mensaje);

            for (int i = 0; i < tractores.size(); i++) {
                System.out.printf("%d -> %s | %.2f km | %.2f L | terreno: %s\n",
                        i, tractores.get(i), kilometros.get(i), litrosDisponibles.get(i), terrenos.get(i));
            }
        }
    }

    public static void aniadirRuta(Scanner sc, ArrayList<String> tractores,
            ArrayList<Double> kilometros,
            ArrayList<Double> litrosDisponibles,
            ArrayList<String> terrenos,
            ArrayList<String> terrenosValidos) {

        imprimirMensaje("NUEVA RUTA:\n\n\"Nombre tractor:\"");
        String nombreTractor;
        double kmRuta, litros;
        String terreno;

        nombreTractor = sc.nextLine().trim();
        tractores.add(nombreTractor);

        kmRuta = leerDoubleMayorCero("kilometros ruta: ", sc);
        kilometros.add(kmRuta);

        litros = leerDoubleMayorCero("Litros disponibles:", sc);
        litrosDisponibles.add(litros);

        terreno = comprobarTerrenoValido(sc, terrenosValidos);
        terrenos.add(terreno);

        listarRutas("RUTA AÑADIDA", tractores, kilometros, litrosDisponibles, terrenos);

    }
}
