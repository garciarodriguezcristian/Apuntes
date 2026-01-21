//     3. Eliminar el último elemento
// Usando el array colores del ejercicio anterior, elimina el último color.
// Muestra el array resultante y el valor del color eliminado.
package ejercicios.ud2.relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class ej3 {

    public static void main(String[] args) {
        ArrayList<String> colores = new ArrayList<>(Arrays.asList("rojo", "verde", "azul"));
        String colorEliminado = colores.remove(colores.size() - 1);
        String mensaje = "";
        for (String color : colores) {
            mensaje += color + ",";
        }
        mensaje = mensaje.substring(0, mensaje.length() - 1);
        System.out.println(mensaje);
        System.out.println("Color eliminado: " + colorEliminado);

    }
}
