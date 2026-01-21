// 14. Mover un elemento al final
// Dado el array numeros = [5, 10, 15, 20], mueve el primer número al final del array.
// Imprime el array después del movimiento.
package ejercicios.ud2.relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class ej14 {

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(5, 10, 15, 20));
        int numeroExtraido = numeros.removeFirst();
        numeros.add(numeroExtraido);
        System.out.println(numeros);
    }
}
