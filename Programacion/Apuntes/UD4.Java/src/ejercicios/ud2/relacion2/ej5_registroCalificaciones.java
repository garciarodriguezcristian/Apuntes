// 5. Sistema de Registro de Calificaciones
// Desarrolla un programa que permita registrar y gestionar las calificaciones de los estudiantes en una clase. Usa dos arrays:
// uno para los nombres de los estudiantes y otro para sus calificaciones. El programa debe ofrecer al usuario un menú con las siguientes opciones:
// Añadir un estudiante y su calificación.
// Mostrar la calificación promedio de la clase.
// Mostrar la calificación más alta y el nombre del estudiante correspondiente.
// Mostrar la calificación más baja y el nombre del estudiante correspondiente.
// Salir del programa.
package ejercicios.ud2.relacion2;

import java.util.ArrayList;
import java.util.Scanner;

public class ej5_registroCalificaciones {

    /**
     *
     * @param mensajeAMostrar
     */
    public static void imprimirMensaje(String mensajeAMostrar) {
        System.out.println(mensajeAMostrar);
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

    public static String obtenerNotaAlta(Boolean notaAlta, ArrayList<String> arrayAlumnos, ArrayList<Double> arrayNotas) {
        String mensaje;
        Double nota;
        String alumno;
        if (notaAlta) {
            nota = arrayNotas.get(0);
            alumno = arrayAlumnos.get(0);
            for (int i = 0; i < arrayAlumnos.size(); i++) {
                if (nota < arrayNotas.get(i)) {
                    nota = arrayNotas.get(i);
                    alumno = arrayAlumnos.get(i);
                }
            }
        } else {
            nota = arrayNotas.get(0);
            alumno = arrayAlumnos.get(0);
            for (int i = 0; i < arrayAlumnos.size(); i++) {
                if (nota > arrayNotas.get(i)) {
                    nota = arrayNotas.get(i);
                    alumno = arrayAlumnos.get(i);
                }
            }
        }
        mensaje = alumno + " | " + nota;
        return mensaje;
    }

    public static Double promedio(ArrayList<Double> array) {
        Double suma = 0.0;
        for (Double nota : array) {
            suma += nota;
        }
        return suma / array.size();
    }

    public static void main(String[] args) {
        ArrayList<String> listaAlumnos = new ArrayList<>();
        ArrayList<Double> notasAlumnos = new ArrayList<>();
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int opcionElegida;
        Double calificacionEstudiante;
        String menuOpciones = """
        Elige una de las siguientes opciones:
            1. Añadir nuevo estudiante
            2. Calificacion promedio
            3. Mostrar alumno con nota más alta
            4. Mostrar alumno con nota más baja
            5. Salir del programa
            """;
        do {
            System.out.println(menuOpciones);
            opcionElegida = scanner.nextInt();
            scanner.nextLine();

            if (opcionElegida == 1) {
                System.out.println("Nombre nuevo estudiante");
                listaAlumnos.add(scanner.nextLine());
                calificacionEstudiante = leerDouble("Calificacion nuevo estudiante", scanner);
                notasAlumnos.add(calificacionEstudiante);
            } else if (opcionElegida == 2) {
                System.out.println(promedio(notasAlumnos));
            } else if (opcionElegida == 3) {
                System.out.println(obtenerNotaAlta(true, listaAlumnos, notasAlumnos));
            } else if (opcionElegida == 4) {
                System.out.println(obtenerNotaAlta(false, listaAlumnos, notasAlumnos));
            } else {
                System.out.println("Opción no válida");
            }
        } while (opcionElegida != 5);
    }
}
