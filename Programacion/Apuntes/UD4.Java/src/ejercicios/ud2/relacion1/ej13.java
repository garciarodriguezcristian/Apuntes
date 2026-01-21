// 13. Invertir un array manualmente
// Crea un array llamado letras con los valores "a", "b", "c", "d".
// Imprime el array invertido.
package ejercicios.ud2.relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class ej13 {

    public static void main(String[] args) {
        ArrayList<String> letras = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        ArrayList<String> letrasInvertido = new ArrayList<>();
        while (!letras.isEmpty()) {
            letrasInvertido.add(letras.getLast());
            letras.removeLast();
        }
        System.out.println(String.join(", ", letrasInvertido));
    }
}
