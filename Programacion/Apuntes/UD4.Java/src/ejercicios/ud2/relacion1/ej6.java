// 6. Añadir y eliminar elementos simultáneamente
// Crea un array llamado frutas que contenga los elementos "manzana", "banana", "naranja".
// Elimina el primer elemento y añade "fresa" al final.
// Imprime el array resultante.
package ejercicios.ud2.relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class ej6 {

    public static void main(String[] args) {
        ArrayList<String> frutas = new ArrayList<>(Arrays.asList("manzana", "banana", "naranja"));
        frutas.removeFirst();
        frutas.add("fresa");
        String mensaje = "";
        for (String fruta : frutas) {
            mensaje += fruta + ",";
        }
        mensaje = mensaje.substring(0, mensaje.length() - 1);
        System.out.println(mensaje);
    }
}
