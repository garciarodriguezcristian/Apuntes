// 7. Acceso y modificación directa
// Crea un array llamado dias que contenga los días de la semana de lunes a domingo.
// Cambia el valor del día "domingo" por "Domingo (fin de semana)" accediendo directamente al índice.
package ejercicios.ud2.relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class ej7 {

    public static void main(String[] args) {
        ArrayList<String> dias = new ArrayList<>(Arrays.asList("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"));
        dias.set(dias.size() - 1, "Domingo (fin de semana)");
        System.out.println(String.join("|", dias));
    }
}
