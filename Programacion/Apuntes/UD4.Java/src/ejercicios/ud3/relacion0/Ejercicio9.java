// 9. Obtener el menor de tres números
// Crea una función llamada menorDeTres que reciba tres números y devuelva el menor de los tres
package ejercicios.ud3.relacion0;

public class Ejercicio9 {

    public static int menorDeTres(int numero1, int numero2, int numero3) {
        int menor = numero1;
        if (numero2 < menor) {
            menor = numero2;
        }
        if (numero3 < menor) {
            menor = numero3;
        }
        return menor;
    }

    public static void main(String[] args) {
        System.out.println("El numero más pequeño es " + menorDeTres(7, 10, 8));
    }
}
