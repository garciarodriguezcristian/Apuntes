package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class pt2 {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        final String DIENTE = "D", DIENTESANO = "DS", DIENTEDANIADO = "X";
        final int NUMDIENTES = 10, MAXDIENTESPICADOS = 5;
        final int DIENTESPICADOS = (int) Math.floor(Math.random() * MAXDIENTESPICADOS) + 1;

        final int DIENTESNOPICADOS = NUMDIENTES - DIENTESPICADOS;
        final String JUGADOR1 = "Jugador 1", JUGADOR2 = "Jugador 2";

        boolean juegoPerdido = false;
        ArrayList<Integer> tableroInterno = new ArrayList<>();
        ArrayList<String> tableroVisible = new ArrayList<>();
        String jugadorActual = JUGADOR1;
        String mensajeFinPrograma = "Enhorabuena, ambos ganan";
        int posicionSeleccionada = 0;
        int dientesPicdadosIntroducidos = 0;
        int posicionDienteIntroducir = 0;

        for (int i = 0; i < NUMDIENTES; i++) {
            tableroInterno.add(0);
        }

        while (dientesPicdadosIntroducidos < DIENTESPICADOS) {
            posicionDienteIntroducir = (int) Math.floor(Math.random() * NUMDIENTES);
            if (tableroInterno.get(posicionDienteIntroducir) == 0) {
                tableroInterno.set(posicionDienteIntroducir, 1);
                dientesPicdadosIntroducidos++;
            }
        }
        for (int i = 0; i < NUMDIENTES; i++) {
            tableroVisible.add(DIENTE);
        }

        for (int i = 0; i < DIENTESNOPICADOS && !juegoPerdido; i++) {
            do {
                System.out.println(jugadorActual + " elige: ");
                posicionSeleccionada = scanner.nextInt();
                if (!tableroVisible.get(posicionSeleccionada).equals(DIENTE)) {

                }
                try {
                    posicionSeleccionada = Integer.parseInt(scanner.nextLine());

                } catch (Exception e) {
                    System.out.println("Introduce un número");
                    boolean entradaIncorrecta = true;
                }
            } while (posicionSeleccionada < 0 || posicionSeleccionada > NUMDIENTES);

            if (tableroInterno.get(posicionSeleccionada) == 0) {
                tableroVisible.set(posicionSeleccionada, DIENTESANO);
            } else {
                tableroVisible.set(posicionSeleccionada, DIENTEDANIADO);
                mensajeFinPrograma = "¡El cocodrilo mordió! " + jugadorActual + " pierde.";
                juegoPerdido = true;
            }
            System.out.println(tableroVisible);
            if (jugadorActual.equals(JUGADOR1)) {
                jugadorActual = JUGADOR2;
            } else {
                jugadorActual = JUGADOR1;
            }
        }
        System.out.println(mensajeFinPrograma);
    }
}
