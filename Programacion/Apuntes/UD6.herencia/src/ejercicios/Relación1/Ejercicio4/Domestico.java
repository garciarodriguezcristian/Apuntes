package ejercicios.Relación1.Ejercicio4;

public class Domestico extends Animal {

    public String duenio;

    public Domestico(String nombre, String tipoAlimentacion, String duenio) {
        super(nombre, tipoAlimentacion);
        this.duenio = duenio;
    }

    @Override
    public String toString() {
        return super.toString() + "Dueño = " + duenio;
    }

    public String convivirConHumanos() {
        String mensaje = "El animal doméstico " + nombre
                + " convive con su dueño " + duenio
                + " y se alimenta de " + tipoAlimentacion;

        return mensaje;
    }
}
