package ejercicios.Relación1.Ejercicio10;

public class Robot implements Movil, Trabajador {

    String modelo;
    int capacidadBateria;

    public Robot(int capacidadBateria, String modelo) {
        this.capacidadBateria = capacidadBateria;
        this.modelo = modelo;
    }

    @Override
    public String realizarTarea() {
        return "El Robot modelo " + modelo + " con batería " + capacidadBateria + "% se desplaza hacia el destino programado.";
    }

    @Override
    public String moverse() {
        return "El Robot modelo " + modelo + " con batería " + capacidadBateria + "% realiza la tarea asignada eficientemente.";
    }

}
