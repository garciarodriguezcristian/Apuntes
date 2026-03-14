package ejercicios.Relación1.Ejercicio4;

public class Salvaje extends Animal {

    public String habitat;

    public Salvaje(String nombre, String tipoAlimentacion, String habitat) {
        super(nombre, tipoAlimentacion);
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return super.toString() + "Habitat = " + habitat;
    }

    public String cazar() {
        String mensaje = "El animal salvaje " + nombre
                + " caza en su habitat " + habitat
                + " y se alimenta de " + tipoAlimentacion;

        return mensaje;
    }
}
