package ejercicios.relacion2.Ejercicio1;

import java.util.Scanner;

import ejercicios.relacion2.Faker;

//Crea una clase Estudiante con atributos nombre, edad y número de matrícula. 
// Implementa los métodos get y set para cada atributo, así como el método toString()

public class Ejercicio1 {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        String matriculaABuscar;
        Scanner input = new Scanner(System.in);
        Estudiante buscado;
        Estudiante estudiante1 = new Estudiante("Carlota", 5, "STEM0067");
        Estudiante estudiante2 = new Estudiante("Miguel", 25);
        Estudiante estudiante3 = new Estudiante("Raul", "STE0068");

        Universidad uni = new Universidad();
        uni.agregarEstudiante(estudiante1);
        uni.agregarEstudiante(estudiante2);
        uni.agregarEstudiante(estudiante3);

        System.out.println(uni);
        matriculaABuscar = input.nextLine();
        buscado = uni.buscarEstudiante(matriculaABuscar);
        if (buscado != null) {
            System.out.println(buscado);
        } else {
            System.err.println("Estudiante no encontrado");
        }

        input.close();

        final int CANTIDAD_ALUMNOS = 100;

        Universidad laRioja = new Universidad();
        Estudiante aleatorio = new Estudiante();

        for (int i = 0; i < CANTIDAD_ALUMNOS; i++) {
            aleatorio = new Estudiante(Faker.nombre(), Faker.edad(), "STEM" + i);
            laRioja.agregarEstudiante(aleatorio);
        }

        System.out.println(laRioja);

    }
}