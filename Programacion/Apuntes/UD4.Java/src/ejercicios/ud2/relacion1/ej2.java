package ejercicios.ud2.relacion1;

import java.util.ArrayList;

//     2. Añadir elementos
// Crea un array vacío llamado colores.
// Añade los colores "rojo", "verde" y "azul" al final del array y luego imprime el array.
public class ej2 {

    public static void main(String[] args) {
        ArrayList<String> colores = new ArrayList<>();
        colores.add("rojo");
        colores.add("verde");
        colores.add("azul");
        // System.out.println(String.join(",", colores)); OTRA FORMA DE IMPRIMIR ARRAY DE STRING.
        String mensaje = "";
        for (String color : colores) {
            mensaje += color + ",";
        }
        mensaje = mensaje.substring(0, mensaje.length() - 1);
        System.out.println(mensaje);
    }
}
