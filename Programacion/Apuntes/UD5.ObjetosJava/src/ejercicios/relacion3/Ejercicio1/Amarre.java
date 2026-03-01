package ejercicios.relacion3.Ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Representa una plaza de amarre en un puerto
 */
public class Amarre {

    private int numero;
    private double longitudMaxima;
    public double precioDia;
    private boolean ocupado;
    public String tipoAmarre;

    private static int contador = 1;

    public Amarre(
            double longitudMaxima,
            boolean ocupado,
            String tipoAmarre) {
        this.numero = contador;
        contador++;
        this.longitudMaxima = longitudMaxima;
        this.tipoAmarre = tipoAmarre;
        if (tipoAmarre.equals("Normal")) {
            this.precioDia = 25 + (1.5 * longitudMaxima);
        }
        if (tipoAmarre.equals("Premium")) {
            this.precioDia = 60 + (2.2 * longitudMaxima);
        }
        if (tipoAmarre.equals("Megayate")) {
            this.precioDia = 120 + (3.5 * longitudMaxima);
        }
        this.ocupado = ocupado;
    }
    ArrayList<String> amarresValidos = new ArrayList<>(Arrays.asList("Normal", "Premium", "Megayate"));

    // Setters y getters
    public int getNumero() {
        return numero;
    }

    public double getLongitudMaxima() {
        return longitudMaxima;
    }

    public void setLongitudMaxima(double longitudMaxima) {
        if (longitudMaxima >= 4.0) {
            this.longitudMaxima = longitudMaxima;
        } else {
            this.longitudMaxima = 4.0;
        }
    }

    public String getTipoAmarre() {
        return tipoAmarre;
    }

    public void setTipoAmarre(String tipoAmarre) {
        if (amarresValidos.contains(tipoAmarre)) {
            this.tipoAmarre = tipoAmarre;
        } else {
            this.tipoAmarre = "Normal";
        }
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public void ocupar() {
        if (!ocupado) {
            ocupado = true;
        }
    }

    public void liberar() {
        if (ocupado) {
            ocupado = false;
        }
    }

    @Override
    public String toString() {
        String amarreOcupado;
        if (ocupado) {
            amarreOcupado = "Ocupado";
        } else {
            amarreOcupado = "Libre";
        }
        return "\nAMARRE Nº " + numero + "\n"
                + "Longitud máxima amarre = " + longitudMaxima
                + " | Precio por día = " + precioDia + " €"
                + " | Disponibilidad = " + amarreOcupado
                + " | Tipo de amarre = " + tipoAmarre;
    }

}
