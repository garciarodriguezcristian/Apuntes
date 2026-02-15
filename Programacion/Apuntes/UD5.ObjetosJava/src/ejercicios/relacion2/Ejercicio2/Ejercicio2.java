package ejercicios.relacion2.Ejercicio2;

public class Ejercicio2 {

    public static void main(String[] args) {
        Libro libro1 = new Libro("ID222", "El quijote", "Cervantes", "El hidalgo Don Quijote", true);
        System.out.println(libro1);
        Biblioteca biblio = new Biblioteca();
        biblio.agregarLibro(libro1);
        biblio.prestarLibro(libro1);
        System.out.println(libro1.getDisponible());
    }
}
