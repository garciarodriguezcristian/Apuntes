package ejercicios.Relación1.Ejercicio5;

public class Libro extends MaterialBibliografico {

    private int numPaginas;
    private String genero;

    public Libro(String autor, String titulo, int numPaginas, String genero) {
        super(autor, titulo);
        this.numPaginas = numPaginas;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro: " + getTitulo() + " por " + getAutor() + ", Género: " + genero + ", Páginas: " + numPaginas + ".";
    }

}
