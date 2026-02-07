package ejercicios.relacion1;

class Termometro {

    double temperatura;

    //Constructor
    Termometro(double temperatura) {
        this.temperatura = temperatura;
    }

    void convertirAFahrenheit() {
        temperatura = temperatura * (9 / 5) + 32;
    }

    @Override
    public String toString() {
        return "La temperatura del termometro es " + temperatura;
    }

}

public class ej5_claseTermometro {

    public static void main(String[] args) {
        Termometro termometro1 = new Termometro(30);

        termometro1.convertirAFahrenheit();
        System.out.println(termometro1);
    }
}
