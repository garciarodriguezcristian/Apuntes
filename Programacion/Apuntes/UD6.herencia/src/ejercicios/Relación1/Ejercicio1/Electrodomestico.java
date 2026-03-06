package ejercicios.Relación1.Ejercicio1;

public class Electrodomestico {

    public String marca;
    public String modelo;

    public Electrodomestico(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Marca : " + marca + ", Modelo = " + modelo;
    }

}
