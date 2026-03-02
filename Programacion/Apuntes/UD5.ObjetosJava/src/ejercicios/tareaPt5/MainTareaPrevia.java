package ejercicios.tareaPt5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainTareaPrevia {

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
     * Permite mostrar todos los animales de un Zoologico
     *
     * @param zoo Zoologico del cual se obtinen los animales a mostrar
     */
    public static void mostrarTodosLosAnimales(Zoologico zoo) {
        imprimirMensaje(zoo.mostrarAnimales());
    }

    /**
     * Permite buscar un animal por su código único. Se muestra por consola el
     * animal encontrado con todos sus atributos
     *
     * @param sc Scanner para que el ususario introduzca el código del animal
     * @param zoo Zoologico donde buscar al animal deseado
     */
    public static void buscarAnimalCodigo(Scanner sc, Zoologico zoo) {
        String codigoAnimal;
        Animal animalBuscado;
        imprimirMensaje("Introduce el código del animal a buscar");
        codigoAnimal = sc.nextLine();
        animalBuscado = zoo.buscarAnimalCodigo(codigoAnimal);
        if (animalBuscado == null) {
            imprimirMensaje("Animal no encontrado");
        } else {
            imprimirMensaje(animalBuscado.toString());
        }
    }

    /**
     * Solicita por consola el código de un animal y la cantidad de ejemplares a
     * añadir, y actualiza los ejemplares de ese animal si el código es válido.
     *
     * @param sc objeto Scanner para la lectura de datos
     * @param zoo instancia del Zoologico donde se añadirán los ejemplares
     * @return Array con los errores produccios o no al agregar ejemplares Ver
     * {@link Zoologico#agregarEjemplares(int, String)} para saber los errores
     * que se devuelven
     */
    public static ArrayList<Boolean> agregarEjemplares(Scanner sc, Zoologico zoo) {
        int ejemplaresSumar;
        String codigoAnimal;
        // Mi primera condición es validar el código, configuro mi array inicial de errores para el error de animal no encontrado.
        // 
        ArrayList<Boolean> erroresAlAgregar = new ArrayList<Boolean>(Arrays.asList(false, true, false));

        //Pido el codigo del animal a buscar
        imprimirMensaje("Introduce el codigo del animal para sumar ejemplares");
        codigoAnimal = sc.nextLine();
        //Si válido el codigo del animal, pido la cantidad
        if (zoo.validarCodigo(codigoAnimal)) {
            imprimirMensaje("Introduce el numero de ejemplares a sumar");
            ejemplaresSumar = sc.nextInt();

            erroresAlAgregar = zoo.agregarEjemplares(ejemplaresSumar, codigoAnimal);

            sc.nextLine();
        }
        return erroresAlAgregar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoologico zoilogico = new Zoologico();

        // =============== F A K E R ===============
        final int MAXANIMALES = 1000;
        //final int MAXEJEMPLARES = 1000;
        Animal aleatorio;
        for (int i = 0; i < MAXANIMALES; i++) {
            aleatorio = new Animal(Faker.nombreAnimal(), Faker.cantidadAnimal(), Faker.precioAnimal());
            zoilogico.agregarAnimal(aleatorio);
        }

        //Faker que agrega animales hasta que el numero de ejemplares llegue al maximo
        // int cantidadEjemplaresAnimal;
        // int sumaEjemplares = 0;
        // for (int i = 0; i < MAXANIMALES && sumaEjemplares < MAXEJEMPLARES; i++) {
        //     cantidadEjemplaresAnimal = Faker.cantidadAnimal();
        //     if (cantidadEjemplaresAnimal + sumaEjemplares > MAXEJEMPLARES) {
        //         cantidadEjemplaresAnimal = MAXEJEMPLARES - sumaEjemplares;
        //     }
        //     aleatorio = new Animal(Faker.nombreAnimal(), cantidadEjemplaresAnimal, Faker.precioAnimal());
        //     zoilogico.agregarAnimal(aleatorio);
        //     sumaEjemplares += cantidadEjemplaresAnimal;
        // }
        String codigoAnimalBuscar;
        Animal animalEncontrado;
        int opcionElegida;
        String menuOpciones = """
                ===== GESTIÓN DE ZOOLÓGICO =====
                1. Mostrar todos los animales
                2. Buscar un animal por código
                3. Agregar ejemplares a un animal
                4. Retirar ejemplares de un animal
                5. Eliminar un animal
                6. Salir
                """;
        do {
            opcionElegida = leerOpcionMenu(menuOpciones, 1, 6, scanner);

            //  ======== 1. Mostrar todos los animales ========
            if (opcionElegida == 1) {
                mostrarTodosLosAnimales(zoilogico);

                // ======== 2. Buscar un animal por código ========
            } else if (opcionElegida == 2) {
                buscarAnimalCodigo(scanner, zoilogico);

                // ======== 3. Agregar ejemplares a un animal ========
            } else if (opcionElegida == 3) {
                ArrayList<Boolean> erroresAgregarEjemplares = agregarEjemplares(scanner, zoilogico);
                if (erroresAgregarEjemplares.get(0)) {
                    System.out.println("Ejemplares añadidos con éxito");
                } else {
                    if (!erroresAgregarEjemplares.get(1)) {
                        System.out.println("Ejemplares no añadidos, la cantidad a agregar tiene que ser mayor que 0");
                    } else if (!erroresAgregarEjemplares.get(2)) {
                        System.out.println("Animal no encontrado");
                    }
                }

                // ======== 4. Retirar ejemplares de un animal ========
            } else if (opcionElegida == 4) {
                System.out.println("Introduce el código del animal al que deseas retirar ejemplares");
                codigoAnimalBuscar = scanner.nextLine();

                //Si el código del animal se valida(exite), pido la cantidad a retirar
                if (zoilogico.validarCodigo(codigoAnimalBuscar)) {
                    int cantidadRetirar;
                    System.out.println("Introduce la cantidad de ejemplares que deseas retirar");
                    cantidadRetirar = scanner.nextInt();
                    scanner.nextLine();

                    ArrayList<Boolean> erroresRetirarEjemplares = zoilogico.retirarEjemplares(cantidadRetirar, codigoAnimalBuscar);
                    if (erroresRetirarEjemplares.get(0)) {
                        System.out.println("Ejemplares retirados con éxito");
                    } else {
                        if (!erroresRetirarEjemplares.get(1)) {
                            System.err.println("No se han podido retirar ejemplares. La cantidad a retirar es negativa o igual a 0");
                        } else if (!erroresRetirarEjemplares.get(2)) {
                            System.err.println("La cantidad a retirar es mayor que la cantidad disponible");
                        }
                    }
                } else {
                    System.err.println("Animal no encontrado");
                }

                // ======== 5. Eliminar un animal ========    
            } else if (opcionElegida == 5) {
                ArrayList<Boolean> erroresEliminarAnimal;

                System.out.println("Introduce el codigo del animal a eliminar");
                codigoAnimalBuscar = scanner.nextLine();

                animalEncontrado = zoilogico.buscarAnimalCodigo(codigoAnimalBuscar);
                erroresEliminarAnimal = zoilogico.eliminarAnimales(animalEncontrado);
                if (erroresEliminarAnimal.get(0)) {
                    System.out.println(animalEncontrado.nombre + " eliminado con exito");
                } else if (!erroresEliminarAnimal.get(1)) {
                    System.err.println("Animal no encontrado");
                } else if (!erroresEliminarAnimal.get(2)) {
                    System.err.println("No se puede eliminar un animal con ejemplares disponibles.");
                }

            }
        } while (opcionElegida != 6);
        System.out.println(
                "Has salido del programa");
    }
}
