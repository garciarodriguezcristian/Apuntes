// 11. Añadir varios elementos al final y al principio

    // Crea un array llamado nombres con los valores "Ana", "Pedro".
    // Añade "Laura" al final del array y "Carlos" al inicio.
    // Imprime el array después de realizar las operaciones.

package ejercicios.ud2.relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class ej11 {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>(Arrays.asList("Ana","Pedro"));
        nombres.add("Laura");
        nombres.addFirst("Carlos");
        System.out.println(String.join(", ", nombres));
    }
}
