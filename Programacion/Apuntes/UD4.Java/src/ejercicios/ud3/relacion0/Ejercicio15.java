// 15. Filtrar números mayores a un valor
// Crea una función llamada filtrarNumerosMayores que reciba un array de números y un valor, y devuelva un nuevo array con los números mayores que el valor dado.
package ejercicios.ud3.relacion0;

import java.util.ArrayList;
import java.util.Arrays;


public class Ejercicio15 {

    public static String imprimirArrayEnteros(ArrayList<Integer> arrayEnteros) {
        String mensaje = "";
        for (int i = 0; i < arrayEnteros.size(); i++) {
            mensaje += (arrayEnteros.get(i));
            if (i < arrayEnteros.size() - 1) {
                mensaje += (", ");
            }
        }
        return mensaje;
    }

    public static ArrayList<Integer> filtrarNumerosMayores(ArrayList<Integer> arrayNumeros, int valor) {
        ArrayList<Integer> arrayNuevo = new ArrayList<>();
        for (Integer numero : arrayNumeros) {
            if (numero > valor) {
                arrayNuevo.add(numero);
            }
        }
        return arrayNuevo;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(12, 36, 8, 2, 56, 89));
        
        System.out.println(imprimirArrayEnteros(filtrarNumerosMayores(numeros, 50)));
    }
}
