// 10. Calcular el área de un triángulo
// Crea una función llamada areaTriangulo que reciba la altura y la altura de un triángulo y devuelva 
// su área calculada con la fórmula (altura * altura) / 2.
package ejercicios.ud3.relacion0;

import java.util.Scanner;

public class Ejercicio10 {

    public static double areaTriangulo(double base, double altura) {
        return base * altura / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base;
        double altura;

        do {
            try {
                System.out.println("Introduce la base: ");
                base = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Error al leer el número");
                base = -1;
                if (base < 0) {
                    System.out.println("La base debe de ser un número mayor que 0");
                }
            }
        } while (base < 0);
        do {
            try {
                System.out.println("Introduce la altura: ");
                altura = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Error al leer el número");
                altura = -1;
                if (altura < 0) {
                    System.out.println("La altura debe de ser un número mayor que 0");
                }
            }
        } while (altura < 0);
        scanner.close();
        System.out.println(" Área del triangulo = " + areaTriangulo(base, altura));
    }
}
