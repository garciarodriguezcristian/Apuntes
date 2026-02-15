package ejercicios.relacion2.Ejercicio2;

import java.util.ArrayList;

public class Biblioteca {

    ArrayList<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        this.libros.add(libro);
    }

    public void prestarLibro(Libro libro) {
        if (libro.getDisponible()) {
            libro.setDisponible(false);
        } else {
            System.err.println("Libro no disponible");
        }
    }

    public void devolverLibro(Libro libro) {
        if (!libro.getDisponible()) {
            libro.setDisponible(true);
        } else {
            System.err.println("El libro no habia sido prestado");
        }
    }
}
