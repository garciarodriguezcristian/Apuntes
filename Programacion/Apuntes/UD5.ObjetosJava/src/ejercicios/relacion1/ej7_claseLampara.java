package ejercicios.relacion1;

class Lampara {

    boolean estado;

    //Construtor
    Lampara(boolean estado) {
        this.estado = estado;
    }

    //Métodos
    void encender() {
        if (this.estado == false) {
            this.estado = true;
            System.out.println("Se ha encendido la lámpara");
        } else {
            System.out.println(" La luz ya estaba encendida");
        }
    }

    void apagar() {
        if (this.estado == true) {
            this.estado = false;
            System.out.println("Se ha apagado la lámpara");
        } else {
            System.out.println("Lámpara ya estaba apagada");
        }
    }

    @Override
    public String toString() {
        return "Lampara está " + (estado ? "encendida" : "apagada");
    }
}

public class ej7_claseLampara {

    public static void main(String[] args) {
        Lampara lampara1 = new Lampara(false);

        System.out.println(lampara1);
        lampara1.encender();
        lampara1.encender();
        lampara1.apagar();
        System.out.println(lampara1);
    }
}
