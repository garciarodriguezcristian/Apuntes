// 20. Contar palabras en una cadena
// Crea una función llamada contarPalabrasEnCadena que reciba una cadena y devuelva el número de palabras que contiene,
// asumiendo que están separadas por espacios. Investiga el uso de split().
package ejercicios.ud3.relacion0;

public class Ejercicio20 {

    public static int contarPalabrasEnCadena(String cadenaDeTexto) {
        int numeroEspacios = 0;
        cadenaDeTexto = cadenaDeTexto.trim();
        for (int i = 0; i < cadenaDeTexto.length(); i++) {
            if (cadenaDeTexto.charAt(i) == ' ') {
                numeroEspacios++;
            }
        }
        return numeroEspacios + 1;
    }

    public static int contarPalabrasEnCadena2( String cadena) {
    int numeroPalabras = cadena.split(" ").length;
    return numeroPalabras;
}

    public static void main(String[] args) {
        System.out.println(contarPalabrasEnCadena("Voy a trabajar de programador"));
        System.out.println(contarPalabrasEnCadena2("Voy a trabajar de programador"));
    }
}
