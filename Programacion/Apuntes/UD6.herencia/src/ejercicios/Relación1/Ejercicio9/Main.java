package ejercicios.Relación1.Ejercicio9;

public class Main {

    public static void main(String[] args) {

        Guitarra guitarra = new Guitarra("Yamaha", "Carbono");
        Piano piano = new Piano("Yamaha", "Contrapesadas");

        System.out.println(guitarra.tocar());
        System.out.println(guitarra.afinar());

        System.out.println(piano.afinar());
        System.out.println(piano.afinar());
    }
}
