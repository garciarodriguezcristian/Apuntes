package ejercicios.Relación1.Ejercicio8;

public class Guerrero implements Jugador {

    String nombre;
    int fuerza;
    String arma;

    public Guerrero(String arma, int fuerza, String nombre) {
        this.arma = arma;
        this.fuerza = fuerza;
        this.nombre = nombre;
    }

    @Override
    public String mover() {
        return "El Guerrero " + nombre + " se mueve con fuerza " + fuerza + ".";
    }

    @Override
    public String atacar() {
        return "El Guerrero " + nombre + " ataca con su " + arma + ".";
    }

}
