import java.util.Scanner;

public class ejercicio9 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caramelos;
        int ninios;
        int reparto;
        int sobrante;

        System.out.println("¿Cuántos caramelos tienes?");
        caramelos = scanner.nextInt();
        System.out.println("¿Cuántos niños hay?");
        ninios = scanner.nextInt();
        scanner.close();

        reparto = caramelos / ninios;
        sobrante = caramelos % ninios;
        System.out.println(" Cada niño toca a " + reparto + " caramelos. Y sobrarían " + sobrante + " caramelos.");
    }
}
