package ejercicios.relacion2.Ejercicio5;

import java.util.ArrayList;

public class Cine {

    ArrayList<Pelicula> peliculas = new ArrayList<>();

    public Cine() {
        this.peliculas = new ArrayList<>();
    }

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public void mostrarPeliculas() {
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.toString()); // No poner system.out en los métodos
        }
    }

    
    public Pelicula buscarPeliculaTitulo(String titulo) {
        Pelicula buscada = null;
        boolean encontrada = false;
        for (int i = 0; i < peliculas.size() && !encontrada; i++) {
            if (peliculas.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                buscada = peliculas.get(i);
                encontrada = true;
            }
        }
        return buscada;
    }

    public int duracionMediaPeliculas() {
        int duracion = 0;
        int cantidadPeliculas = peliculas.size();
        for (Pelicula pelicula : peliculas) {
            duracion += pelicula.getDuracion();
        }

        return duracion / cantidadPeliculas;
    }
}
