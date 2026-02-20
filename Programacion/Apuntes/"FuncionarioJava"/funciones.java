package apuntes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class funciones {

    // =============================================== MOSTRAR ARRAYS O MENSAJES =======================================
    /**
     *
     * @param mensajeAMostrar
     */
    public static void imprimirMensaje(String mensajeAMostrar) {
        System.out.println(mensajeAMostrar);
    }

    /**
     * Imprimir array de enteros
     *
     * @param arrayEnteros
     * @param separador
     * @return Devuelve un mensaje con el resultado de imprimir el array
     */
    public static String imprimirArrayEnteros(ArrayList<Integer> arrayEnteros, String separador) {
        String mensaje = "";
        for (int i = 0; i < arrayEnteros.size(); i++) {
            mensaje += (arrayEnteros.get(i));
            if (i < arrayEnteros.size() - 1) {
                mensaje += separador;
            }
        }
        return mensaje;
    }

    /**
     * Imprime un array de String
     *
     * @param arrayString Array a imprimir
     * @param separador Separador que se va a mostrar
     */
    public static void imprimirArrayString(ArrayList<String> arrayString, String separador) {
        System.out.println(String.join(separador, arrayString));
    }

    /**
     * Muestra un ArrayList de Strings numerado por pantalla
     *
     * @param mensaje Texto que se muestra antes del listado
     * @param array ArrayList de Strings a mostrar
     */
    public static void mostrarArrayString(String mensaje, ArrayList<String> array) {
        imprimirMensaje(mensaje);

        for (int i = 0; i < array.size(); i++) {
            System.out.println("Elemento " + (i + 1) + " : " + array.get(i));
        }
    }

    /**
     * Muestra dos ArrayList relacionados por indice
     *
     * @param mensaje Texto que se muestra antes del listado
     * @param arrayTexto ArrayList de Strings (nombres)
     * @param arrayValor ArrayList de numeros (cantidad, precio, etc)
     */
    public static void mostrarArrayDoble(String mensaje,
            ArrayList<String> arrayTexto,
            ArrayList<Integer> arrayValor) {
        imprimirMensaje(mensaje);

        for (int i = 0; i < arrayTexto.size(); i++) {
            System.out.println("Elemento " + (i + 1) + ": " + arrayTexto.get(i) + " -> " + arrayValor.get(i));
        }
    }

    /**
     * Imprime un mesaje personalizado para mostrar datos de 4 arrays
     * relacionados por su indice.
     *
     * @param mensaje Mensaje a mostrar en la cabecera
     * @param arrayTexto1 Array de String 1
     * @param arrayValor1 Array Integer 1
     * @param arrayValor2 Array de Integer 2
     * @param arrayTexto2 Array de String 2
     */
    public static void mostrar4Arrays(String mensaje,
            ArrayList<String> arrayTexto1,
            ArrayList<Integer> arrayValor1,
            ArrayList<Integer> arrayValor2,
            ArrayList<String> arrayTexto2) {
        imprimirMensaje(mensaje);

        for (int i = 0; i < arrayTexto1.size(); i++) {
            System.out.printf("%d -> %s | inicial: %d | mejor puja: %d | postor: %s\n",
                    i, arrayTexto1.get(i), arrayValor1.get(i), arrayValor2.get(i), arrayTexto2.get(i));
        }
    }

    /**
     * Muestra el menu con sus opciones
     */
    public static void mostrarMenuOpciones() {
        System.out.println("""
        Elige una de las siguientes opciones:
            1.
            2.
            3.
            4.
            5.
            """);
    }

    public static String mostrarMensajeRandom2opciones(boolean viable) {
        String mensaje;
        ArrayList<String> mensajesViable = new ArrayList<>(Arrays.asList(
                "Mensaje viable 1",
                "Mensaje viable 2",
                "Mensaje viable 3"
        ));

        ArrayList<String> mensajesNoViable = new ArrayList<>(Arrays.asList(
                "Mensaje no viable 1",
                "Mensaje no viable 2",
                "Mensaje no viable 3"
        ));
        if (viable) {
            mensaje = mostrarElementoAleatorio(mensajesViable);
        } else {
            mensaje = mostrarElementoAleatorio(mensajesNoViable);
        }

        return mensaje;
    }

    public static String mostrarMensajeRandom() {
        String mensaje;
        ArrayList<String> arrayMensajes = new ArrayList<>(Arrays.asList(
                "Mensaje viable 1",
                "Mensaje viable 2",
                "Mensaje viable 3"));
        mensaje = mostrarElementoAleatorio(arrayMensajes);
        return mensaje;
    }
//================================================================ CONTROL DE ERRORES ==============================================================

    /**
     * Lee un numero entero del usuario con control de errores
     *
     * @param mensaje Mensaje que se muestra al usuario
     * @param sc Scanner ya creado en el main
     * @return numero entero valido introducido por el usuario
     */
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

    static double leerEnteroMayorCero(String mensaje, Scanner sc) {
        double numero = 0.0;
        boolean valido = false;

        while (!valido) {
            imprimirMensaje(mensaje);
            try {
                numero = Integer.parseInt(sc.nextLine().trim());
                valido = numero > 0;
                if (!valido) {
                    imprimirMensaje("Debe ser mayor que 0.");
                }
            } catch (NumberFormatException e) {
                imprimirMensaje("Número no válido.");
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
                imprimirMensaje("Número no válido.");
            }
        }
        return numero;
    }

    /**
     * Lee un numero decimal del usuario con control de errores
     *
     * @param mensaje Mensaje que se muestra al usuario
     * @param sc Scanner ya creado en el main
     * @return numero double valido introducido por el usuario
     */
    public static double leerDouble(String mensaje, Scanner sc) {
        double numero = 0;
        boolean correcto = false;

        while (!correcto) {
            try {
                imprimirMensaje(mensaje);
                numero = Double.parseDouble(sc.nextLine());
                correcto = true;
            } catch (NumberFormatException e) {
                imprimirMensaje("Error: introduce un numero decimal valido");
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
            opcion = leerEntero("Elige una opcion:", sc);

            if (opcion >= min && opcion <= max) {
                correcta = true;
            } else {
                imprimirMensaje("Error: la opcion debe estar entre " + min + " y " + max);
            }
        } while (!correcta);
        return opcion;
    }

    /**
     * Añade a un array comprobando si esta duplicado
     */
    public static boolean aniadirSinDuplicados(String posibleDuplicado, ArrayList<String> array) {
        boolean duplicadosEncontrado = false;

        for (int i = 0; i < array.size() && !duplicadosEncontrado; i++) {
            if (array.get(i).equalsIgnoreCase(posibleDuplicado)) {
                duplicadosEncontrado = true;
            }
        }
        if (!duplicadosEncontrado) {
            array.add(posibleDuplicado);
        } else {
            imprimirMensaje("No se añade " + posibleDuplicado + " ya que está en el array");
        }
        return duplicadosEncontrado;
    }

    /**
     * Comprueba si el String del usuario ya está en el ArrayList, si no está lo
     * añade y devuelve false, si si está no lo añade y devuelve true
     *
     * @param mensajeString mensaje a mostrar como "añade un nombre"
     * @param array array donde comprueba si esta el String
     * @param sc
     */
    public static void leerStringArray(String mensajeString, ArrayList<String> array, Scanner sc) {
        String stringUsuario;
        do {
            imprimirMensaje(mensajeString);
            stringUsuario = sc.nextLine();
        } while (aniadirSinDuplicados(stringUsuario, array));
    }

// ====================================================== BUSCAR EN ARRAYLIST =====================================================================
    /**
     * Lee un indice pasado por el usuario, lo valida y lo devuelve si ese
     * indice está en el array pasado como parámetro.
     *
     * @param mensaje Mensaje mostrado para la entrada del usuario
     * @param array Donde se busca el indice
     * @param sc
     * @return Devuelve el indice validado
     */
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

    /**
     * Elegir elemento aleatorio de un ArrayList, devuelve ese elemento
     *
     * @param array Array donde se elige el elemento aleatorio
     */
    public static String mostrarElementoAleatorio(ArrayList<String> array) {
        int posicion;
        String elemento;

        posicion = (int) (Math.random() * array.size());
        elemento = array.get(posicion);

        return elemento;
    }

    /**
     * Buscar un int en un ArrayList<Integer>, devuelve true si esta o false si
     * no
     *
     * @param array ArrayList de int donde buscar
     * @param numero int a buscar
     * @return true si se encuentra, false si no
     */
    public static boolean buscarEntero(ArrayList<Integer> array, int numero) {
        boolean encontrado = false;

        for (int i = 0; i < array.size() && !encontrado; i++) {
            if (array.get(i) == numero) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    /**
     * Busca un String en un ArrayList, devuelve true si esta o false si no
     *
     * @param array ArrayList de Strings donde buscar
     * @param texto String a buscar
     * @return true si se encuentra, false si no
     */
    public static boolean buscarString(ArrayList<String> array, String texto) {
        boolean encontrado = false;

        for (int i = 0; i < array.size() && !encontrado; i++) {
            if (array.get(i).equalsIgnoreCase(texto)) {
                encontrado = true;
            }
        }
        return encontrado;
    }

// ====================================================== RELLENAR ARRAYLIST =====================================================================
    /**
     * Rellenar un ArrayList con números aleatorios
     *
     * @param array el array a rellenar
     * @param tamanio tamaño maximo del array
     * @param minimo numero minimo del aleatorio
     * @param maximo numero maximo del aleatorio
     */
    public static void rellenarArrayRandom(ArrayList<Integer> array, int tamanio, int minimo, int maximo) {
        int numero;

        for (int i = 0; i < tamanio; i++) {
            numero = (int) (Math.random() * (maximo - minimo + 1)) + minimo;
            array.add(numero);
        }
    }

    /**
     * Rellenar ArrayList con números aleatorios sin repetir
     *
     * @param array el array a rellenar
     * @param tamanio tamaño maximo del array
     * @param minimo numero minimo del aleatorio
     * @param maximo numero maximo del aleatorio tamanio tiene que ser >= a
     * maximo - minimo + 1
     */
    public static void rellenarArrayRandomSinRepetir(ArrayList<Integer> array, int tamanio, int minimo, int maximo) {
        int numero;

        while (array.size() < tamanio) {
            numero = (int) (Math.random() * (maximo - minimo + 1)) + minimo;

            if (!array.contains(numero)) {
                array.add(numero);
            }
        }
    }

    /**
     * Rellena array con un elemento que le pasemos
     *
     * @param arrayIntroducida array del tablero
     * @param tamanio tamaño del tablero
     * @param simbolo con el que se va a rellenar el tablero, puede ser numero
     * pero cambiar valor String por Int o Double
     */
    public static void construyeTablero(ArrayList<String> arrayIntroducida, int tamanio, String simbolo) {
        for (int i = 0; i < tamanio; i++) {
            arrayIntroducida.add(simbolo);
        }
    }

    /**
     * Rellena los numeros aleatoriamente en un tablero de posiciones. Mete un
     * numero aleatorio de "1"/bombas entre el máximo y el mínimo
     *
     * @param arrayOculta Tablero
     * @param minimo Mínimo introducido posible de algo
     * @param maximo Máximo introducido posible de algo
     */
    public static void randomizaTablero(ArrayList<String> arrayOculta, int minimo, int maximo) {
        final int CANTIDAD = (int) (Math.floor(Math.random() * (maximo - minimo + 1)) + minimo);
        int contador = 0;
        int posicion;
        while (contador != CANTIDAD) {
            posicion = (int) (Math.floor(Math.random() * (arrayOculta.size())));

            // Si la posicion randomizada no tiene el elemento, añade elemento
            if (arrayOculta.get(posicion).equals("0")) {
                arrayOculta.set(posicion, "1");
                contador++;
            }
        }
    }
    // ====================================================== NUMERO ALEATORIO =====================================================================

    /**
     * Genera un numero aleatorio entre 2 valores
     *
     * @param minimo
     * @param maximo
     * @return int aleatorio
     */
    public static int randomEntre(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1)) + minimo;
    }
}
