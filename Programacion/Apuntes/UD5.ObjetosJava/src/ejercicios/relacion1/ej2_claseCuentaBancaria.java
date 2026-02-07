package ejercicios.relacion1;

// Ejercicio 2: Clase CuentaBancaria
// Crea una clase CuentaBancaria con atributos titular y saldo. Agrega métodos depositar(cantidad) y retirar(cantidad), 
// asegurando que el saldo no sea negativo después de un retiro.
import java.util.Scanner;

public class ej2_claseCuentaBancaria {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        CuentaBancaria cuenta1 = new CuentaBancaria("Cristian", 1000);
        CuentaBancaria cuenta2 = new CuentaBancaria("Elisabeth", 1000);

        System.out.println("Cuenta de " + cuenta2.titular + ": \n Introduce la cantidad a retirar");
        cuenta2.retirar(scanner.nextInt());

        System.out.println("Introduce la cantidad a depositar en la cuenta de " + cuenta1.titular);
        cuenta1.depositar(scanner.nextInt());

        System.out.println(cuenta1.titular + " tiene " + cuenta1.saldo + " € en la cuenta");
        System.out.println(cuenta2.titular + " tiene " + cuenta2.saldo + " € en la cuenta");

    }
}

class CuentaBancaria {

    String titular;
    int saldo;

    CuentaBancaria(String titular, int saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    int depositar(int cantidad) {
        return saldo += cantidad;
    }

    int retirar(int cantidad) {
        if (cantidad > saldo) {
            System.out.println("No puedes retirar. Cantidad a retirar mayor que saldo");
        } else {
            saldo -= cantidad;
        }
        return saldo;
    }
}
