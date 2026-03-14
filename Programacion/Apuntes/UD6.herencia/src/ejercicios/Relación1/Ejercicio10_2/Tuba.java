package ejercicios.Relación1.Ejercicio10_2;

public class Tuba implements InstrumentoMusical {

    @Override
    public String tocar(String nota) {
        return "La tuba toca la nota " + nota;
    }

    @Override
    public String afinar(int frecuencia) {
        return "Afinando tuba a " + frecuencia + " Hz";
    }

    @Override
    public String mostrarInformacion(String tipo) {
        return " Tipo de tuba: " + tipo;
    }
}
