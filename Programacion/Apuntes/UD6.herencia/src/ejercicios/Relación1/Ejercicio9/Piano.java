package ejercicios.Relación1.Ejercicio9;
// - `Piano`:
//     - Atributos: `marca`, `tipoTeclas`
//     - Método `tocar()`: devuelve "El piano de marca [marca] está tocando una pieza clásica."
//     - Método `afinar()`: devuelve "El piano de marca [marca] con teclas [tipoTeclas] está siendo afinado."

public class Piano implements InstrumentoMusical {

    String marca;
    String tipoTeclas;

    public Piano(String marca, String tipoTeclas) {
        this.marca = marca;
        this.tipoTeclas = tipoTeclas;
    }

    @Override
    public String tocar() {
        return "El piano de marca " + marca + " está tocando una pieza clásica.";
    }

    @Override
    public String afinar() {
        return "EL piano de marca " + marca + " con teclas " + tipoTeclas + " está siendo afinado.";
    }
}
