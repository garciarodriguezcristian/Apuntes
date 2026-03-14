package ejercicios.Relación1.Ejercicio10_2;

/*
        Ejercicio 10

        Crea una interfaz llamada InstrumentoMusical con los siguientes métodos:

        - tocar(String nota)
        - afinar(int frecuencia)
        - mostrarInformacion(String tipo)

        Después crea dos clases que implementen esta interfaz:
        - Trompeta
        - Tuba

        En el programa principal:
        - Crea un objeto de cada instrumento.
        - Llama a los métodos pasando parámetros distintos.
 */
public class Main {

    public static void main(String[] args) {
        Trompeta trompeta1 = new Trompeta();

        System.out.println(trompeta1.tocar("Do"));
        System.out.println(trompeta1.afinar(400));
        System.out.println(trompeta1.mostrarInformacion("Yamaha"));
        
        System.out.println(trompeta1.tocar("Re"));
        System.out.println(trompeta1.afinar(500));
        System.out.println(trompeta1.mostrarInformacion("Yamaha"));

    }
}
