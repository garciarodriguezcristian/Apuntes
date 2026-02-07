package ejercicios.relacion1;

//Clase Alumno

class Alumno {

    String nombre;
    String materia;
    double calificacion;

    //Constructor
    Alumno(String nombre, String materia, double calificacion) {
        this.nombre = nombre;
        this.materia = materia;
        this.calificacion = calificacion;
    }

    boolean aprobo() {
        return (calificacion >= 6);
    }
}

public class ej3_claseAlumno {

    public static void main(String[] args) {

        Alumno alumno1 = new Alumno("Cristian", "Programación", 3);

        if (alumno1.aprobo() == true) {
            System.out.println("Mayor 6");
        } else {
            System.out.println("Menor 6");
        }
    }
}
