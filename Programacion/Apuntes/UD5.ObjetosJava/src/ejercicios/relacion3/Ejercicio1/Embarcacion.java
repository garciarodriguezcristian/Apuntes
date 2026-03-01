package ejercicios.relacion3.Ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;

public class Embarcacion {

    private String nombre;
    private String matricula;
    private double eslora;
    private String tipo;
    private String propietario;
    private int anioFabricacion;
    public double valorEstimado;

    /**
     * Constructor de Embarcacion vacío Crea una embarcación con datos por
     * defecto
     */
    public Embarcacion() {

    }

    public Embarcacion(String nombre, String matricula, double eslora,
            String tipo, String propietario, int anioFabricacion,
            double valorEstimado) {
        this.nombre = nombre;
        setMatricula(matricula);
        setEslora(eslora);
        setTipo(tipo);
        this.propietario = propietario;
        setAnioFabricacion(anioFabricacion);
        this.valorEstimado = valorEstimado;
    }

    ArrayList<String> tiposValidos = new ArrayList<>(Arrays.asList("Velero", "Lancha", "Yate", "Catamarán", "Moto de agua"));

    // Setters y getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    /**
     *
     * @param matricula Nueva Matrícula
     * @return booleano {@code true} si se ha podido cambiar la matricula o
     * {@code false} si no
     */
    public boolean setMatricula(String matricula) {
        boolean matriculaCambiada = false;
        if (matricula != null && !matricula.isBlank()) {
            this.matricula = matricula;
            matriculaCambiada = true;
        } else {
            this.matricula = "SIN MATRICULA";
        }
        return matriculaCambiada;
    }

    public double getEslora() {
        return eslora;
    }

    public void setEslora(double eslora) {
        if (eslora > 0) {
            this.eslora = eslora;
        }
    }

    public String getPropietario() {
        return this.propietario;
    }

    public void setPropietario(String propietario) {
        if (propietario != null && !propietario.isBlank()) {
            this.propietario = propietario;
        }
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion >= 1950 && anioFabricacion <= 2026) {
            this.anioFabricacion = anioFabricacion;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tiposValidos.contains(tipo)) {
            this.tipo = tipo;
        }
    }

    @Override
    public String toString() {
        return "\n DATOS EMBARCACIÓN\n"
                + "--- " + nombre.toUpperCase() + " ---\n"
                + "Matricula = " + matricula
                + ", Eslora = " + eslora
                + ", Tipo = " + tipo
                + ", Propietario = " + propietario
                + ", Año de fabricación = " + anioFabricacion
                + ", Valor estimado = " + valorEstimado;
    }

}
