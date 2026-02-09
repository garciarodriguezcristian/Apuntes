package ejercicios.relacion1;

class Televisor {

    String canalActual;
    int volumen;

    //Construtor vacío
    // Se crea un nuevo televisor con eso valores predefinidos
    Televisor() {
        this.canalActual = "Canal 1";
        this.volumen = 10;
    }

    //Se crea un televisor con los valores pasados por parametros
    Televisor(String canalActual, int volumen) {
        this.canalActual = canalActual;
        this.volumen = volumen;
    }

    //Métodos
    void subirVolumen() {
        if (volumen < 100) {
            volumen++;
        } else {
            System.out.println("Volumen al máximo");
        }
    }

    void bajarVolumen() {
        if (volumen > 0) {
            volumen--;
        } else {
            System.out.println("Volumen mínimo alcanzado");
        }
    }

    void cambiarCanal(String nuevoCanal) {
        canalActual = nuevoCanal;
    }

    @Override
    public String toString() {
        return "Canal actual: " + canalActual + " | Volumen: " + volumen;
    }

}

public class ej8_claseTelevisor {

    public static void main(String[] args) {
        Televisor tele1 = new Televisor();
        Televisor tele2 = new Televisor("Cuatro", 100);
        Televisor tele3 = new Televisor("La sexta", 0);

        System.out.println(tele1);
        tele1.cambiarCanal("La 1");
        tele1.subirVolumen();
        System.out.println(tele1);

        System.out.println(tele2);
        tele2.subirVolumen();
        System.out.println(tele2);
        System.out.println(tele3);
        tele3.bajarVolumen();
        System.out.println(tele3);
    }
}
