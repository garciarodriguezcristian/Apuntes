package ejercicios.Relación1.Ejercicio5;

public class MaterialBibliografico {

    private String titulo;
    private String autor;

    public MaterialBibliografico(String autor, String titulo) {
        this.autor = autor;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return titulo + " --> Autor: " + autor;
    }

}
