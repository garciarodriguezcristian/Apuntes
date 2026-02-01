// 16. Verificar si un número está en un array
// Crea una función llamada verificarNumeroEnArray que reciba un número y un array, y devuelva true si el número está presente en el array o false si no lo está.
package ejercicios.ud3.relacion0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio16 {

    public static Boolean verificarNumeroEnArray(int numero, ArrayList<Integer> array) {
        boolean encontrado = false;
        for (int i = 0; i < array.size() && !encontrado; i++) {
            if (numero == array.get(i)) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(12, 36, 8, 2, 56, 89));
        System.out.println("Selecciona número a buscar");
        Scanner scanner = new Scanner(System.in);
        int numeroBuscar = scanner.nextInt();

        if (verificarNumeroEnArray(numeroBuscar, numeros)) {
            System.out.println("Numero encontrado");
        } else {
            System.out.println("Numero NO encontrado");
        }
    }
}