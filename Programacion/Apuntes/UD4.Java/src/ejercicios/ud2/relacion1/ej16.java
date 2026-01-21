// 16. Rellenar un array con elementos secuenciales
// Crea un array vacío llamado secuencia.
// Usando un bucle, añade los números del 1 al 5 al final del array.
// Imprime el array resultante.
package ejercicios.ud2.relacion1;

import java.util.ArrayList;

public class ej16 {

    public static void main(String[] args) {
        ArrayList<Integer> secuencia = new ArrayList<>();
        final int MAXNUMEROS = 5;
        for (int i = 1; i <= MAXNUMEROS; i++) {
            secuencia.add(i);
        }
        System.out.println(secuencia);
    }
}
