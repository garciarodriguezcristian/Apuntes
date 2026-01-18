// 17. Revertir una cadena
// Crea una función llamada revertirCadena que reciba una cadena de texto y devuelva la misma cadena con los caracteres en orden inverso.
package ejercicios.ud3.relacion0;

public class Ejercicio17 {

    public static String revertirCadena(String cadena) {
        String cadenaRevertida = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            cadenaRevertida += cadena.charAt(i);
        }
        return cadenaRevertida;
    }

    public static void main(String[] args) {
        System.out.println(revertirCadena("Cristian"));
    }
}
