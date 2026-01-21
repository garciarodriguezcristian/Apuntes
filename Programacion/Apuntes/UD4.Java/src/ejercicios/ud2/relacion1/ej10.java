// 10. Simulación de una pila (LIFO)
// Crea un array vacío llamado pila.
// Añade los números 10, 20 y 30 al final de la pila.
// Simula el proceso de extraer elementos de la pila eliminando
// el último elemento e imprime el número extraído y el estado de la pila.
package ejercicios.ud2.relacion1;

import java.util.ArrayList;
import java.util.Arrays;

public class ej10 {

    public static void main(String[] args) {
        ArrayList<Integer> pila = new ArrayList<>(Arrays.asList(10, 20, 30));
        int elementoExtraido;
        String mensaje = "";

        while (!pila.isEmpty()) {
            elementoExtraido = pila.removeLast();
            System.out.printf("Elemento extraido: %d\n", elementoExtraido);
            for (int i = 0; i < pila.size(); i++) {
                mensaje += pila.get(i);
                if (i < pila.size() - 1) {
                    mensaje += ",";
                }
            }
            if (pila.isEmpty()) {
                System.out.println("Estado de la pila: vacía");
            } else {
                System.out.println("Estado de la pila: " + mensaje);
            }
            mensaje = "";
        }
    }
}
