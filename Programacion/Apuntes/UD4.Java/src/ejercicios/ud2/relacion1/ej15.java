// 15. Eliminar todos los elementos de un array uno por uno
// Crea un array con los valores [1, 2, 3, 4, 5].
// Elimina todos los elementos uno por uno utilizando pop() hasta que el array quede vacío.
// Imprime el estado del array después de cada eliminación.
package ejercicios.ud2.relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class ej15 {

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        while (!numeros.isEmpty()) {
            numeros.removeLast();
            System.out.println(numeros);
        }
    }
}
