package ejercicios.relacion1;

public class ej6_claseReloj {

    public static void main(String[] args) {
        Reloj reloj1 = new Reloj(23, 59, 59);

        reloj1.sumarMinutos(23);
        reloj1.sumarSegundos(56);
        System.out.println(reloj1);

    }
}

class Reloj {

    int hora, minuto, segundo;

    @Override
    public String toString() {
        return hora + ":" + minuto + ":" + segundo;
    }

    //Constructor
    Reloj(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    // Métodos
    void sumarMinutos(int minutos) {
        minutos = minuto + minutos;
        minuto = 0;
        hora += minutos / 60;
        minuto = minutos % 60;
        if (hora >= 24) {
            hora = hora % 24;
        }
    }

    void restarMinutos(int minutos) {
    }

    void sumarSegundos(int segundos) {
        int minutos;
        segundos = segundo + segundos;
        segundo = 0;
        minuto += segundos / 60;
        segundo = segundos % 60;
        if (minuto >= 60) {
            minutos = minuto;
            minuto = 0;
            sumarMinutos(minutos);
        }
    }

    void restarSegundos(int segundos) {
        int minutos;
        segundos = segundo + segundos;
        segundo = 0;
        minuto += segundos / 60;
        segundo = segundos % 60;
        if (minuto >= 60) {
            minutos = minuto;
            minuto = 0;
            sumarMinutos(minutos);
        }
    }
}
