package ejercicios.Relación1.Ejercicio7;

public class Autobus implements Transporte {

    String horaSalida;
    String horaParada;

    public Autobus(String horaSalida, String horaParada) {
        this.horaSalida = horaSalida;
        this.horaParada = horaParada;
    }

    @Override
    public String arrancar() {
        return "El autobús sale a las " + horaSalida;
    }

    @Override
    public String detener() {
        return "El autobús para a las " + horaParada;
    }

}
