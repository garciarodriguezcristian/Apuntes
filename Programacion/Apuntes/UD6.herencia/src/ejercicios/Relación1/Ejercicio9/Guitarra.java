package ejercicios.Relación1.Ejercicio9;
// - `Guitarra`:
//     - Atributos: `marca`, `tipoCuerdas`
//     - Método `tocar()`: devuelve "La guitarra de marca [marca] está tocando una melodía."
//     - Método `afinar()`: devuelve "La guitarra de marca [marca] con cuerdas [tipoCuerdas] está siendo afinada."

public class Guitarra implements InstrumentoMusical {

    String marca;
    String tipoCuerdas;

    public Guitarra(String marca, String tipoCuerdas) {
        this.marca = marca;
        this.tipoCuerdas = tipoCuerdas;
    }

    @Override
    public String tocar() {
        return "La guitarra de marca " + marca + " está tocando una melodía.";
    }

    @Override
    public String afinar() {
        return "La guitarra de marca " + marca + " con cuerdas " + tipoCuerdas + " está siendo afinada.";
    }

}
