package ejercicios.Relación1.Ejercicio1;

public class Televisor extends Electrodomestico {

    double tamanioPantalla;

    public Televisor(String marca, String modelo, double tamanioPantalla) {
        super(marca, modelo);
        this.tamanioPantalla = tamanioPantalla;
    }

    @Override
    public String toString() {
        return "Televisor" + super.toString() + " ,Tamaño de la pantalla = " + tamanioPantalla + " pulgadas";
    }

}
