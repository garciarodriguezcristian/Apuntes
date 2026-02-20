package ejercicios.relacion2.Ejercicio5;
// titulo, sinopsis, director, duracion

public class Pelicula {

    private String sinopsis;
    private String director;
    private int duracion;
    private String titulo;

    public Pelicula(String sinopsis, String director, int duracion, String titulo) {
        this.sinopsis = sinopsis;
        this.director = director;
        setDuracion(duracion);
        this.titulo = titulo;
    }

    public Pelicula() {
        
    }

    public String getSinopsis() {
        return this.sinopsis;
    }

    /**
     * Cambia la sinopsis actual de al pelicula a la nueva sinopsis pasada
     *
     * @param sinopsis Nueva sinopsis Si sinopsis esta vacío o es null, no la
     * actualiza
     */
    public void setSinopsis(String sinopsis) {
        if (sinopsis != null && !sinopsis.isBlank()) {
            this.sinopsis = sinopsis;
        } else {
            this.sinopsis = "SIN SINOPSIS";
        }
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return this.duracion;
    }

    /**
     * Permite cambiar la duracion de la peliculo. La duracion se introduce en
     * minutos
     *
     * @param duracion Nueva duración en minutos
     * @return Nueva duracción
     */
    public void setDuracion(int duracion) {
        if (duracion >= 0) {
            this.duracion = duracion;
        } else {
            this.duracion = 0;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    /**
     * Método para cambiar el título Si el titulo pasado es null o está en
     * blanco no se cambia y se devuelve false para su posterior tratamiento en
     * el main.
     *
     * @param titulo Nuevo titulo. No puede ser null ni estar vacío.
     * @return {@code true} si se ha cambiado el titulo o {@code false si no se ha cambiado.
     */
    public boolean setTitulo(String titulo) {
        boolean tituloCambiado = false;
        if (titulo != null && !titulo.isBlank()) {
            this.titulo = titulo;
            tituloCambiado = true;
        }
        return tituloCambiado;
    }

    @Override
    public String toString() {
        return "- - - " + titulo.toUpperCase() + " - - -\nSinopsis: " + this.sinopsis + "\nDirector: "
                + this.director + "\nDuración: " + this.duracion + " minutos";
    }

}
