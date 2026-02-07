package ejercicios.relacion1;

class Auto {

    String marca;
    String modelo;
    int velocidadActual;

    Auto(String marca, String modelo, int velocidadActual) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadActual = velocidadActual;
    }

    //Métodos
    void acelerar(int cantidad) {
        velocidadActual += cantidad;
    }

    void frenar(int cantidad) {
        velocidadActual -= cantidad;
    }

    @Override
    public String toString() {
        return marca + " " + modelo;
    }

}

public class ej4_claseAuto {

    public static void main(String[] args) {
        Auto coche1 = new Auto("Citroen", "C4", 100);
        coche1.acelerar(20);
        System.out.println("El coche " + coche1 + " acelera hasta " + coche1.velocidadActual + " km/h");
        coche1.frenar(60);
        System.out.println("El coche " + coche1 + " frena hasta " + coche1.velocidadActual + " km/h");
    }
}
