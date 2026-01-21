package ejercicios.ud2.relacion1;
//     1. Crear un array y acceder a los elementos
// Crea un array llamado numeros que contenga los números [5, 10, 15, 20].
// Imprime en la consola el primer y el último elemento accediendo directamente por su índice.


import java.util.ArrayList;
import java.util.Arrays;

public class ej1 {

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(5, 10, 15, 20));
        System.out.println("El primer elemento del array es: " + numeros.get(0) + " y el ultimo elemento es " + numeros.get(numeros.size() - 1));
    }
}
