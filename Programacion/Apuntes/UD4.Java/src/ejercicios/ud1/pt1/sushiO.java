package ejercicios.ud1.pt1;

import java.util.Scanner;

public class sushiO {

    public static void main(String[] args) {
        // Declaracion de variables
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        final int ARROZMAKI = 120;
        final double AGUAMAKI = 0.10;
        final int PRECIOMAKI = 8;

        final int ARROZNIGIRI = 50;
        final double AGUANIGIRI = 0.05;
        final int PRECIONIGIRI = 10;

        final int ARROZSASHIMI = 0;
        final double AGUASASHIMI = 0.02;
        final int PRECIOSASHIMI = 12;

        int cantidadPedidos = 0;
        double stockArroz = 0, stockAgua = 0;

        String tipoPlato = "";
        double consumoArroz, consumoAgua, precioPedido;
        double consumoArrozAcumulado = 0, consumoAguaAcumulada = 0, cuentaTotal = 0;

        int numeroPedido = 0;

        int unidadesPlato;
        int unidadesMaki = 0, unidadesNigiri = 0, unidadesSashimi = 0;
        double arrozRestante, aguaRestante;
        boolean stockSuperado = false;

        //----------------- MAIN -----------------//
        while (cantidadPedidos <= 0) {
            System.out.println("Introduce el número de pedidos");
            cantidadPedidos = scanner.nextInt();
        }
        while (stockArroz <= 0) {
            System.out.println("Introduce el stock de arroz en gramos");
            stockArroz = scanner.nextInt();
        }
        while (stockAgua <= 0) {
            System.out.println("Introduce el stock de agua en litros");
            stockAgua = scanner.nextDouble();
        }
        scanner.nextLine();
        while (numeroPedido < cantidadPedidos && !stockSuperado) {
            while (!"maki".equals(tipoPlato) && !"nigiri".equals(tipoPlato) && !"sashimi".equals(tipoPlato)) {
                System.out.println("Introduce el tipo de plato que deseas pedir: maki, nigiri o sashimi");
                tipoPlato = scanner.next();
            }
            System.out.println("¿Cuántas unidades de " + tipoPlato + " quieres pedir? Escribe 0 o más");
            unidadesPlato = scanner.nextInt();
            while (unidadesPlato < 0) {
                System.out.println("¿Introduce una cantidad igual o mayor a 0 para tu pedido de " + tipoPlato);
                unidadesPlato = scanner.nextInt();
            }

            if (tipoPlato.equalsIgnoreCase("maki")) {
                consumoArroz = ARROZMAKI * unidadesPlato;
                consumoAgua = AGUAMAKI * unidadesPlato;
                precioPedido = PRECIOMAKI * unidadesPlato;
                unidadesMaki += unidadesPlato;

            } else if (tipoPlato.equalsIgnoreCase("nigiri")) {
                consumoArroz = ARROZNIGIRI * unidadesPlato;
                consumoAgua = AGUANIGIRI * unidadesPlato;
                precioPedido = PRECIONIGIRI * unidadesPlato;
                unidadesNigiri += unidadesPlato;
            } else {
                consumoArroz = ARROZSASHIMI * unidadesPlato;
                consumoAgua = AGUASASHIMI * unidadesPlato;
                precioPedido = PRECIOSASHIMI * unidadesPlato;
                unidadesSashimi += unidadesPlato;
            }
            if (stockArroz < (consumoArrozAcumulado + consumoArroz)) {
                stockSuperado = true;
                System.out.println("Se ha superado el stock de arroz");
            } else if (stockAgua < (consumoAguaAcumulada + consumoAgua)) {
                stockSuperado = true;
                System.out.println("Se ha superado el stock de agua");
            }
            if (!stockSuperado) {
                numeroPedido++;
                consumoArrozAcumulado += consumoArroz;
                consumoAguaAcumulada += consumoAgua;
                cuentaTotal += precioPedido;

                

                System.out.println("--- Pedido " + numeroPedido + " ---");
                System.out.println("Plato: " + tipoPlato + " | Unidades: " + unidadesPlato + " | Importe cobrado: " + precioPedido + " €");
                System.out.println("Arroz gastado en el pedido: " + consumoArroz + "g | Arroz acumulado: " + consumoArrozAcumulado + " g");
                System.out.println("Agua gastada en el pedido (L): " + consumoAgua + " | Agua acumulada (L): " + consumoAguaAcumulada);
            }
            tipoPlato = "";
        }
        arrozRestante = stockArroz - consumoArrozAcumulado;
        aguaRestante = stockAgua - consumoAguaAcumulada;
        System.out.println("Pedidos registrados: " + numeroPedido + " de " + cantidadPedidos);
        System.out.println("Unidades → Maki: " + unidadesMaki + " | Nigiri: " + unidadesNigiri + " | Sashimi: " + unidadesSashimi);
        System.out.println("Consumo total → Arroz: " + consumoArrozAcumulado + " g | Agua: " + consumoAguaAcumulada + " L");
        System.out.println("Stock restante → Arroz: " + arrozRestante + " g | Agua: " + aguaRestante + " L");
        System.out.println("Caja del día: " + cuentaTotal + " €");
        if (!stockSuperado) {
            System.out.println("Registro completado con éxito");
        } else {
            System.out.println("Registro interrumpido por superación de stock");
        }
    }
}
