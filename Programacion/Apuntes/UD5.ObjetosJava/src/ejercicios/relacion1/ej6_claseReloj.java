package ejercicios.relacion1;

public class ej6_claseReloj {

    public static void main(String[] args) {
        Reloj reloj1 = new Reloj(00, 00, 00);

        // reloj1.sumarMinutos(4980);
        // reloj1.sumarSegundos(2);
        // reloj1.restarMinutos(1500);
        reloj1.restarSegundos(2);
        System.out.println(reloj1);

    }
}

class Reloj {

    int hora, minuto, segundo;

    @Override
    public String toString() {
        String h = (hora < 10) ? "0" + hora : String.valueOf(hora);
        String m = (minuto < 10) ? "0" + minuto : String.valueOf(minuto);
        String s = (segundo < 10) ? "0" + segundo : String.valueOf(segundo);

        return h + ":" + m + ":" + s;
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
        hora += minutos / 60;
        minuto = minutos % 60;
        hora = hora % 24;
    }

    void sumarSegundos(int segundos) {
        segundos = (segundo + segundos) + (minuto * 60) + (hora * 60 * 60);
        hora = segundos / 3600;
        minuto = (segundos % 3600) / 60;
        segundo = segundos % 60;

    }

    void restarMinutos(int minutos) {
        // int segundosUnDia = 24 * 3600;
        // int segundos = (hora * 3600) + (minuto * 60) + segundo;
        // segundos -= (minutos * 60);

        // segundos = (segundos % segundosUnDia + segundosUnDia) % segundosUnDia;
        // hora = segundos / 3600;
        // minuto = (segundos % 3600) / 60;
        // segundo = segundos % 60;
        
        if (hora - (minutos / 60) >= 0) {
            hora -= minutos / 60;
        } else {
            if ((24 - ((minutos / 60) - hora)) >= 0) {
                hora = 24 - ((minutos / 60) - hora);
            } else {
                hora = 24 - (minutos / 60) % 24;
            }
        }
        if (minuto - minutos % 60 >= 0) {
            minuto -= minutos % 60;
        } else {
            if (hora == 0) {
                hora = 24 - 1;
            } else {
                hora--;
            }
            minuto = 60 - ((minutos % 60) - minuto);
        }
    }

    void restarSegundos(int segundos) {
        // int segundosUnDia = 24 * 3600;
        // int totalSegundos;
        // totalSegundos = (hora * 3600) + (minuto * 60) + segundo;
        // totalSegundos -= segundos;

        // totalSegundos = (totalSegundos % segundosUnDia + segundosUnDia) % segundosUnDia;
        // hora = totalSegundos / 3600;
        // minuto = (totalSegundos % 3600) / 60;
        // segundo = totalSegundos % 60;

        if (minuto - (segundos / 60) >= 0) {
            minuto -= segundos / 60;
        } else {
            if ((60 - ((segundos / 60) - minuto)) >= 0) {
                minuto = 60 - ((segundos / 60) - minuto);
            } else {
                minuto = 60 - (segundos / 60) % 60;
            }
        }
        if (segundo - segundos % 60 >= 0) {
            segundo -= segundos % 60;
        } else {
            if (minuto == 0) {
                restarMinutos(1);
            } else {
                minuto--;
            }
            segundo = 60 - ((segundos % 60) - segundo);
        }
    }
}
