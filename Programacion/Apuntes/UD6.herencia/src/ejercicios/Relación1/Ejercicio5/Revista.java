package ejercicios.Relación1.Ejercicio5;

public class Revista extends MaterialBibliografico {

    private int edicion;
    private String periodicidad;

    public Revista(String autor, String titulo, int edicion, String periodicidad) {
        super(autor, titulo);
        this.edicion = edicion;
        this.periodicidad = periodicidad;
    }

    @Override
    public String toString() {
        return "Revista: " + getTitulo() + " por " + getAutor() + ", Edición: " + edicion + ", Periodicidad: " + periodicidad + ".";
    }

}
