package ejercicios.relacion3.Ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Representa una plaza de amarre en un puerto
 */
public class Amarre {

    private int numero;
    private double longitudMaxima;
    private double precioDia;
    private boolean ocupado;
    private String tipoAmarre;

    private static int contador = 1;
    private final static ArrayList<String> TIPOSVALIDOS = new ArrayList<>(
            Arrays.asList("NORMAL", "PREMIUM", "MEGAYATE"));

    public Amarre(
            double longitudMaxima,
            boolean ocupado,
            String tipoAmarre) {
        this.numero = contador;
        contador++;
        setLongitudMaxima(longitudMaxima);
        this.tipoAmarre = tipoAmarre;
        //preciodia se crea por defecto a 0.0
        this.ocupado = ocupado;
    }

    private void calcularPrecioDia() {
        if (tipoAmarre != null && longitudMaxima != 0.0) {

            if (tipoAmarre.equals(TIPOSVALIDOS.get(0))) {
                precioDia = 25 + (1.5 * longitudMaxima);
            } else if (tipoAmarre.equals(TIPOSVALIDOS.get(1))) {
                precioDia = 60 + (2.2 * longitudMaxima);
            } else {
                precioDia = 120 + (3.5 * longitudMaxima);
            }
        }
    }

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
        calcularPrecioDia();
    }

    public String getTipoAmarre() {
        return tipoAmarre;
    }

    public void setTipoAmarre(String tipoAmarre) {
        if (TIPOSVALIDOS.contains(tipoAmarre.toUpperCase())) {
            this.tipoAmarre = tipoAmarre;
        } else {
            this.tipoAmarre = "NORMAL";
        }
        calcularPrecioDia();
    }

    public double getPrecioDia() {
        return precioDia;
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
