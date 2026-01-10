
import java.util.Scanner;

//Sumar los dígitos de un número de dos cifras:
public class ejercicio9 {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Declaro variable
        int numeroDosCifras, decenas, unidades;
        int suma;

        //Pido el numero al usuario
        System.out.println("Introduce un numero de 2 cifras");
        numeroDosCifras = scanner.nextInt();
        scanner.close();

        //Separo decenas y unidades en numeros independientes
        decenas = numeroDosCifras / 10;
        unidades = numeroDosCifras % 10;

        //Hago la suma de los dos digitos
        suma = decenas + unidades;
        System.out.println("La suma de los dos digitos es: " + suma);
    }
}
