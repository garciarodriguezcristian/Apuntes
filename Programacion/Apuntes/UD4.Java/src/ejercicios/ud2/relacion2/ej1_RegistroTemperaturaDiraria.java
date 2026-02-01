// 1. Registro de Temperatura Diaria
// Escribe un programa que permita al usuario ingresar las temperaturas registradas durante una semana (7 días).
//  Una vez ingresadas las temperaturas, el programa debe mostrar al usuario un menú con las siguientes opciones:
// 1. Mostrar la temperatura más alta registrada.
// 2. Mostrar la temperatura más baja registrada.
// 3. Calcular la temperatura promedio de la semana.
// 4. Salir del programa.
// El programa debe ejecutarse hasta que el usuario elija la opción de salir.
package ejercicios.ud2.relacion2;

import java.util.ArrayList;
import java.util.Scanner;

public class ej1_RegistroTemperaturaDiraria {

    @SuppressWarnings({"UseSpecificCatch", "ConvertToTryWithResources"})
    public static void main(String[] args) {

        //Variables
        Scanner scanner = new Scanner(System.in);
        final int DIASSEMANA = 7;
        ArrayList<Double> temperaturasSemana = new ArrayList<>();
        int opcionElegida = 0;
        double temperaturaMaxima = 0;
        double temperaturaMinima = 0;
        double temperaturaPromedio;
        double sumaTemperaturas = 0;
        String menu = """
                      Elige una de las siguientes opciones:

                      1. Mostrar la temperatura más alta registrada.
                      2. Mostrar la temperatura más baja registrada.
                      3. Calcular la temperatura promedio de la semana.
                      4. Salir del programa.""";

        for (int i = 1; i <= DIASSEMANA; i++) {
            System.out.println("Introduce la temperatura del dia " + i);
            temperaturasSemana.add(scanner.nextDouble());
        }
        while (opcionElegida != 4) {
            try {
                System.out.println(menu);
                scanner.nextLine();
                opcionElegida = Integer.parseInt(scanner.nextLine());

                if (opcionElegida == 1) {
                    for (Double temperatura : temperaturasSemana) {
                        temperaturaMaxima = temperatura;
                        if (temperatura > temperaturaMaxima) {
                            temperaturaMaxima = temperatura;
                        }
                    }
                    System.out.println("La temperatura más alta es " + temperaturaMaxima + " ºC");
                } else if (opcionElegida == 2) {
                    for (Double temperatura : temperaturasSemana) {
                        temperaturaMinima = temperatura;
                        if (temperatura < temperaturaMinima) {
                            temperaturaMinima = temperatura;
                        }
                    }
                    System.out.println("La temperatura más baja es " + temperaturaMinima + " ºC");
                } else if (opcionElegida == 3) {
                    for (Double valor : temperaturasSemana) {
                        sumaTemperaturas += valor;
                    }
                    temperaturaPromedio = sumaTemperaturas / temperaturasSemana.size();
                    System.out.printf("La temperatura media de la semana es %.2f ºC", temperaturaPromedio);
                } else {
                    if (opcionElegida != 4) {
                        System.out.println(" Opción no valida ");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: debes introducir un número entero válido.");
            }
        }
        scanner.close();
    }

}
