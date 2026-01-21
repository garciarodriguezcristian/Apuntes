// 9. Simulación de una cola (FIFO)
// Crea un array vacío llamado cola.
// Añade los elementos "cliente1", "cliente2" y "cliente3" al final del array.
// Simula el proceso de atender a los clientes eliminando el primero e imprime
//  el cliente atendido y el estado de la cola.
package ejercicios.ud2.relacion1;

import java.util.ArrayList;

public class ej9 {

    public static void main(String[] args) {
        ArrayList<String> cola = new ArrayList<>();
        final int CANTIDADCLIENTES = 10;
        String clienteEliminado;

        for (int i = 1; i <= CANTIDADCLIENTES; i++) {
            cola.add("cliente" + i);
        }

        while (!cola.isEmpty()) {
            clienteEliminado = cola.removeFirst();
            System.out.println("Cliente atendido: " + clienteEliminado);
            System.out.println("Clientes en espera " + String.join("|", cola));
        }
        System.out.println(cola);
    }
}
