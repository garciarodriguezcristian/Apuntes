package ejercicios.Relación1.Ejercicio7;

public class Metro implements Transporte {

    int vagones;

    public Metro(int vagones) {
        this.vagones = vagones;
    }

    @Override
    public String arrancar() {
        return "El número de vagones es " + vagones;
    }

    @Override
    public String detener() {
        return "Metodo detener no implementado para la clase Metro";
    }
}
