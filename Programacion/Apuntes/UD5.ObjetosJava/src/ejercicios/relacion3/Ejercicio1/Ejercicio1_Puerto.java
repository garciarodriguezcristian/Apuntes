package ejercicios.relacion3.Ejercicio1;

public class Ejercicio1_Puerto {

    public static void main(String[] args) {

        //= = = = = = = = = E M B A R C A C I O N = = = = = = = = =
        Embarcacion barco1 = new Embarcacion("Criser", "23459M", -4.0, "casa", "Cristian", 1800, -60);
        Embarcacion barco2 = new Embarcacion("Pupiyate", "23459L", -4.0, "casa", "Cristian", 1800, -60);

        System.out.println(barco1);
        if (barco1.valorEstimado < 0) {
            System.err.println("El valor estimado no puede ser negativo, se establece 0 por defecto");
            barco1.valorEstimado = 0;
        }
        if (barco2.valorEstimado < 0) {
            System.err.println("El valor estimado no puede ser negativo, se establece 0 por defecto");
            barco2.valorEstimado = 0;
        }
        System.out.println(barco1);

        //= = = = = = = = = A M A R R E S = = = = = = = = =
        Amarre amarre1 = new Amarre(8, true, "Premium");
        Amarre amarre2 = new Amarre(10, true, "Megayate");
        Amarre amarre3 = new Amarre(10, false, "Normal");
        Amarre amarre4 = new Amarre(10, false, "Megayate");

        //= = = = = = = = = P U E R T O S = = = = = = = = =
        Puerto marina = new Puerto("Marina del Este", "Almuñecar", 50, "652856754");
        System.out.println(marina);

        System.out.println(marina.registrarEmbarcacion(barco1));
        System.out.println(marina.registrarEmbarcacion(barco2));
        System.out.println(marina.altaAmarre(amarre1));
        System.out.println(marina.altaAmarre(amarre2));
        System.out.println(marina.altaAmarre(amarre3));
        System.out.println(marina.altaAmarre(amarre4));

        // marina.liberarAmarre(2);
        // marina.liberarAmarre(1);
        // System.out.println(amarre2);
        System.out.println(marina.mostrarAmarresLibres());
        System.out.println(marina.mostrarAmarresOcupados());

        System.out.println(marina.buscarEmbarcacion("23459M"));

        System.out.println(marina.calcularIngresosDiariosActuales() + "€ diarios");
        System.out.println(marina.calcularIngresosDiariosMaximos() + "€ diarios máximos si todos los amarres estuvieran ocupados");



        //= = = = = = = = = M E N Ú = = = = = = = = =


    }
}
