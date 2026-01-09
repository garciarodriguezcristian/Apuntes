import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuántos caramelos tienes?");
        int caramelos = scanner.nextInt();
        System.out.println("¿Cuántos niños hay?");
        int ninios = scanner.nextInt();
        int reparto = caramelos / ninios;
        int sobrante = caramelos % ninios;
        System.out.println(" Cada niño toca a " + reparto + " caramelos. Y sobrarían " + sobrante + " caramelos.");
    }
}
