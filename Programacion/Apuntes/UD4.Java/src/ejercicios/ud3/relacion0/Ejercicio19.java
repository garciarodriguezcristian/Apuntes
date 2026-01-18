// 19. Capitalizar la primera letra de una palabra
// Crea una función llamada capitalizarPrimeraLetra que reciba una palabra y devuelva la misma palabra con la primera letra en mayúscula.
// Investiga el uso de toUpperCase().
package ejercicios.ud3.relacion0;

public class Ejercicio19 {

    public static String capitalizarPrimeraLetra(String palabra) {
        palabra = palabra.toLowerCase();
        char primeraLetraPalabra = Character.toUpperCase(palabra.charAt(0));
        palabra = primeraLetraPalabra + palabra.substring(1);
        return palabra;
    }

    public static void main(String[] args) {
        System.out.println(capitalizarPrimeraLetra("PROgramaCIon"));
    }
}
