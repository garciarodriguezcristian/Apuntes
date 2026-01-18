package ejercicios.ud3.relacion0;

public class Ejercicio18 {

    public static int contarVocales(String texto) {
        int numeroDeVocales = 0;
        texto = texto.toUpperCase();
        for (int i = 0; i < texto.length(); i++) {
            if ((texto.charAt(i)) == 'A'
                    || texto.charAt(i) == 'E'
                    || texto.charAt(i) == 'I'
                    || texto.charAt(i) == 'O'
                    || texto.charAt(i) == 'U') {
                numeroDeVocales++;
            }
        }
        return numeroDeVocales;
    }

    public static void main(String[] args) {
        System.out.println("El número de vocales es: " + contarVocales("ELisaBeth"));
    }
}
