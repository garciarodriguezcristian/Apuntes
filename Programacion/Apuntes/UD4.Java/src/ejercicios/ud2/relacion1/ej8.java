// 8. Intercambio de elementos del array
// Crea un array con los números [100, 200, 300].
// Usa una variable temporal para intercambiar los valores del primer y tercer elemento,
// e imprime el array después del cambio.
package ejercicios.ud2.relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class ej8 {

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(100, 200, 300));
        int temporal = numeros.getFirst();
        numeros.set(0, numeros.getLast());
        numeros.set(numeros.size() - 1, temporal);
        System.out.println(numeros);
    }
}
