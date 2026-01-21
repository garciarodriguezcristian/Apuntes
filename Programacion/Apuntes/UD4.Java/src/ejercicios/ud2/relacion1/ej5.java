// 5. Eliminar el primer elemento
// Usando el array animales del ejercicio anterior, elimina el primer elemento.
// Muestra el array después de la eliminación y el valor del elemento eliminado.
package ejercicios.ud2.relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class ej5 {

    public static void main(String[] args) {
        ArrayList<String> animales = new ArrayList<>(Arrays.asList("tortuga", "loro", "perro", "gato"));
        String elementoEliminado = animales.remove(0);
        String mensaje = "";
        for (String animal : animales) {
            mensaje += animal + ",";
        }
        mensaje = mensaje.substring(0, mensaje.length() - 1);
        System.out.println(mensaje);
        System.out.println("Elemento eliminado: " + elementoEliminado);
    }
}
