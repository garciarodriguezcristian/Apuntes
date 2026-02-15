package ejercicios.relacion2.Ejercicio2;

public class Libro {

    private String id;
    private String titulo;
    private String autor;
    private String sinopsis;
    private boolean disponible;

    public Libro(String id, String titulo, String autor, String sinopsis, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.disponible = disponible;
    }
//Setters y getters
    // Id

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //titulo
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //autor
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    //sinopsis
    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    //disponible
    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        String estadoLibro;
        if (this.disponible) {
            estadoLibro = "Disponible";
        } else {
            estadoLibro = "Prestado";
        }
        String libroString = "ID = " + id + "\nTitulo = " + titulo + "\nAutor = " + autor
                + "\nSinopsis = " + sinopsis + "\nDisponibilidad = " + estadoLibro;

        return libroString;
    }

}
