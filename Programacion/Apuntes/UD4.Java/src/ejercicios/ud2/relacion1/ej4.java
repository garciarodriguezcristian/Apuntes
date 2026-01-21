//     4. Añadir elementos al inicio
// Crea un array llamado animales que contenga los elementos "perro", "gato".
// Añade "loro" y "tortuga" al inicio del array y luego imprime el array.
package ejercicios.ud2.relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class ej4 {

    public static void main(String[] args) {
        ArrayList<String> animales = new ArrayList<>(Arrays.asList("perro", "gato"));
        animales.add(0, "tortuga");
        animales.add(0, "loro");
        String mensaje = "";
        for (String color : animales) {
            mensaje += color + ",";
        }
        mensaje = mensaje.substring(0, mensaje.length() - 1);
        System.out.println(mensaje);

    }
}
