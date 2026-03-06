package ejercicios.Relación1.Ejercicio1;

class Lavadora extends Electrodomestico {

    public double capacidadCarga;

    public Lavadora(String marca, String modelo, double capacidadCarga) {
        super(marca, modelo);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return "Lavadora" + super.toString() + " ,Capacidadde carga = " + capacidadCarga + " Kg";
    }

}
