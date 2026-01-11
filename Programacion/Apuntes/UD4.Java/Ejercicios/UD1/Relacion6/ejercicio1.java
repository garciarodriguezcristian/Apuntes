// 1. Calificaciones de estudiantes

// Crea un programa que reciba las calificaciones de N estudiantes (se piden calificaciones hasta que el usuario introduzca un "-1")
// y calcule el promedio.
// Luego muestra cuántos estudiantes están aprobados (>=5) y cuántos suspensos.
// Ejemplo:
// Introduce la calificacion del alumno 1: 4
// Introduce la calificacion del alumno 2: 1
// Introduce la calificacion del alumno 3: 10
// Introduce la calificacion del alumno 4: 8
// Introduce la calificacion del alumno 5: -1
// Hay 2 alumnos aprobados y 2 alumnos suspensos.
// La calificación media es 5.75
import java.util.Scanner;

public class ejercicio1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numeroAlumno = 1;
        double calificacion = 0;
        double sumaCalificaciones = 0;
        double promedio;
        int aprobados = 0, suspensos = 0;

        while (calificacion != -1) {
            System.out.println("Introduce la clasificación del alumno " + numeroAlumno);
            calificacion = scanner.nextDouble();

            while ((calificacion < 0 || calificacion > 10) && calificacion != -1) {
                System.out.println("Calificación Incorrecta. Introduce la calificación del alumno" + numeroAlumno + "(o -1 para terminar)");
                calificacion = scanner.nextDouble();
                scanner.close();
            }
            if (calificacion != -1) {
                if (calificacion >= 5) {
                    aprobados++;
                } else {
                    suspensos++;
                }
                numeroAlumno++;
                sumaCalificaciones += calificacion;
            }
        }
        promedio = sumaCalificaciones / (numeroAlumno - 1);
        System.out.println("Hay " + aprobados + " alumnos aprobados y " + suspensos + " alumnos suspensos");
        System.out.println("La calificación media de los alumnos es " + promedio);
    }
}
