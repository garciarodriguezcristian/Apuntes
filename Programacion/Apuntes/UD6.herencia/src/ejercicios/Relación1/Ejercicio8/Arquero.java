package ejercicios.Relación1.Ejercicio8;

public class Arquero implements Jugador {

    String nombre;
    int agilidad;
    String arco;

    public Arquero(String arco, int agilidad, String nombre) {
        this.arco = arco;
        this.agilidad = agilidad;
        this.nombre = nombre;
    }

    @Override
    public String mover() {
        return "El Arquero " + nombre + " se mueve ágilmente con agilidad " + agilidad + ".";
    }

    @Override
    public String atacar() {
        return "El Arquero " + nombre + " dispara una flecha con su " + arco + ".";
    }
}
