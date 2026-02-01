 // 6. Sistema de Seguimiento de Tareas
// Desarrolla un programa que permita hacer un seguimiento de las tareas diarias de un equipo.
// El programa debe usar dos arrays: uno para almacenar los nombres de las tareas y otro para almacenar 
// el estado de cada tarea (true = completada y false = pendiente). El menú del programa debe ofrecer las siguientes opciones:
// Añadir una nueva tarea.
// Marcar una tarea como completada.
// Ver la lista de tareas pendientes.
// Ver la lista de tareas completadas.
// Salir del programa.
package ejercicios.ud2.relacion2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ej6_seguimientoDeTareas {

    public static String capitalizarPrimeraLetra(String palabra) {
        palabra = palabra.toLowerCase();
        char primeraLetraPalabra = Character.toUpperCase(palabra.charAt(0));
        palabra = primeraLetraPalabra + palabra.substring(1);
        return palabra;
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static String mostrarTareasCompletadas(Boolean buscarCompletadas, ArrayList<String> arrayTareas, ArrayList<Boolean> arrayEstado) {
        String cabeceraCompletadas = "TAREAS COMPLETADAS";
        String cabeceraPendientes = "TAREAS PENDIENTES";
        String mensaje;
        if (!buscarCompletadas) {
            mensaje = cabeceraPendientes + "\n";
            for (int i = 0; i < arrayTareas.size(); i++) {
                if (arrayEstado.get(i) == false) {
                    mensaje += capitalizarPrimeraLetra(arrayTareas.get(i)) + "\n";
                }
            }
        } else {
            mensaje = cabeceraCompletadas + "\n";
            for (int i = 0; i < arrayTareas.size(); i++) {
                if (arrayEstado.get(i) == true) {
                    mensaje += capitalizarPrimeraLetra(arrayTareas.get(i)) + "\n";
                }
            }
        }
        return mensaje;
    }

    public static void main(String[] args) {
        ArrayList<String> nombresTareas = new ArrayList<>(Arrays.asList("cocinar", "estudiar", "limpiar"));
        ArrayList<Boolean> estadoTareas = new ArrayList<>(Arrays.asList(false, false, true));
        Scanner scanner = new Scanner(System.in);
        int opcionElegida = 0;
        String tareaSeleccionada;
        Boolean tareaEncontrada = false;

        String menuOpciones = """
        Elige una de las siguientes opciones:
            1. Añadir nueva tarea
            2. Marcar una tarea como completada
            3. Ver la lista de tareas pendientes
            4. Ver la lista de tareas completadas
            5. Salir del programa
            """;

        do {
            System.out.println(menuOpciones);
            if (scanner.hasNextInt()) {
                opcionElegida = scanner.nextInt();
                scanner.nextLine();
                if (opcionElegida == 1) {
                    System.out.println("Nombre nueva tarea");
                    nombresTareas.add(scanner.nextLine());
                    estadoTareas.add(false);

                } else if (opcionElegida == 2) {
                    System.out.println("Selecciona la tarea a completar");
                    tareaSeleccionada = (scanner.nextLine().toLowerCase());
                    if (nombresTareas.contains(tareaSeleccionada)) {
                        if (estadoTareas.get(nombresTareas.indexOf(tareaSeleccionada)) == false) {
                            estadoTareas.set(nombresTareas.indexOf(tareaSeleccionada), true);
                        } else {
                            System.out.println("Tarea ya completada");
                        }
                    } else {
                        System.out.println("Tarea no encontrada");
                    }
                } else if (opcionElegida == 3) {
                    System.out.println(mostrarTareasCompletadas(false, nombresTareas, estadoTareas));
                } else if (opcionElegida == 4) {
                    System.out.println(mostrarTareasCompletadas(true, nombresTareas, estadoTareas));
                } else {
                    if (opcionElegida != 5) {
                        System.out.println("Opción no válida");
                    }
                }

            } else {

            }
        } while (opcionElegida != 5);
        scanner.close();
    }
}
