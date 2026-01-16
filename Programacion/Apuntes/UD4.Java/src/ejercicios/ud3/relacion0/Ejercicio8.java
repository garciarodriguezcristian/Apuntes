package ejercicios.ud3.relacion0;


public class Ejercicio8 {

    public static int mayor(int numero1, int numero2) {
        int numeroMayor = numero1;
        if (numero1 < numero2) {
            numeroMayor = numero2;
        }
        return numeroMayor;
    }

    public static void main(String[] args) {
        int numeroMayor = mayor(6, 8);
        System.out.println(numeroMayor);
        
    }
}
