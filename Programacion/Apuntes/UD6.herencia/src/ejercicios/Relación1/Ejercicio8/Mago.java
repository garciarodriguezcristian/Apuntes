package ejercicios.Relación1.Ejercicio8;

public class Mago implements Jugador {

    String nombre;
    int mana;
    String hechizo;

    public Mago(String hechizo, int mana, String nombre) {
        this.hechizo = hechizo;
        this.mana = mana;
        this.nombre = nombre;
    }

    @Override
    public String mover() {
        return "El Mago " + nombre + " se desplaza utilizando su maná " + mana + ".";
    }

    @Override
    public String atacar() {
        return "El Mago " + nombre + " lanza un hechizo " + hechizo + ".";
    }
}
