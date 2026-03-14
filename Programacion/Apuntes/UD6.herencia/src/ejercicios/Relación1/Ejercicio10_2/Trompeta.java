package ejercicios.Relación1.Ejercicio10_2;

public class Trompeta implements InstrumentoMusical {

    @Override
    public String tocar(String nota) {
        return "La trompeta toca la nota " + nota;
    }

    @Override
    public String afinar(int frecuencia) {
        return "Afinando trompeta a " + frecuencia + " Hz";
    }

    @Override
    public String mostrarInformacion(String tipo) {
        return " Tipo de tormpeta: " + tipo;
    }

}
