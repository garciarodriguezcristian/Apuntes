// 12. Eliminar varios elementos del inicio y del final
// Usando el array nombres del ejercicio anterior, elimina el primer y el último elemento.
// Imprime el array resultante y los valores eliminados.
package ejercicios.ud2.relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class ej12 {

    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>(Arrays.asList("Carlos", "Ana", "Pedro", "Laura"));
        String primerValor = nombres.removeFirst();
        String segundoValor = nombres.removeLast();
        System.out.println(String.join(" | ", nombres));
        System.out.println("Los valores eliminados son " + primerValor + ", " + segundoValor);
    }
}
