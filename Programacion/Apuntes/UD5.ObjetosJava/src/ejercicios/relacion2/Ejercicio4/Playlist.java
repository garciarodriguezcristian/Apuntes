package ejercicios.relacion2.Ejercicio4;

import java.util.ArrayList;

public class Playlist {

    private final ArrayList<Cancion> canciones;

    public Playlist() {
        this.canciones = new ArrayList<>();
    }

    public void agregarCanciones(Cancion cancion) {
        canciones.add(cancion);
    }

    public String mostrarCancionesTitulo() {
        String mostrarCanciones = "--- Canciones Playlist ---\n";

        for (Cancion cancion : canciones) {
            mostrarCanciones += cancion.getTitulo() + " -- " + cancion.getArtista() + "\n";
        }
        return mostrarCanciones;
    }

    public String mostrarCanciones() {
        String mostrarCanciones = "--- Canciones Playlist ---\n";

        for (Cancion cancion : canciones) {
            mostrarCanciones += cancion.toString() + "\n\n";
        }
        return mostrarCanciones;
    }

    public double duracionPlaylist() {
        double totalDuracion = 0;
        for (Cancion cancion : canciones) {
            totalDuracion += cancion.getDuracion();
        }
        return totalDuracion;
    }

}
