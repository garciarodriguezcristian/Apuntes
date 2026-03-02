package ejercicios.tareaPt5;

import java.util.ArrayList;
import java.util.Arrays;

public class Zoologico {

    public ArrayList<Animal> animales = new ArrayList<>();

    /**
     * Construtor sin parámetros Se genera un Zoologico con un array de animales
     * vacio
     */
    public Zoologico() {
        this.animales = new ArrayList<>();
    }

    /**
     * Construtor con array inicial
     *
     * @param animales Array de animales
     */
    public Zoologico(ArrayList<Animal> animales) {
        this.animales = animales;
    }

    /**
     * Permite generar un mensaje con información de los animales del zoológico
     *
     * Si la lista de animales está vacía, devuelve un mensaje indicando que no
     * hay animales registrados. En caso contrario, construye una cadena de
     * texto con la información de cada animal utilizando su método
     * {@code toString()}, separando cada uno por un salto de línea.
     *
     * @return Una cadena de texto con los datos de todos los animales, o un
     * mensaje indicando que no hay animales en el zoológico.
     */
    public String mostrarAnimales() {
        String mensaje = "";
        if (animales.isEmpty()) {
            mensaje = "No hay animales en el zoológico";
        } else {
            for (Animal animal : animales) {
                mensaje += animal.toString() + "\n";
            }
        }
        return mensaje;
    }

    /**
     * Método que permite validar si un animal identificado por su codigo está
     * en el zoológico
     *
     * @param codigoValidar Código a validar entre los disponibles dentro del
     * zoológico
     * @return true si está validado o false si el codigo no se encuentra en el
     * zoologico
     */
    public boolean validarCodigo(String codigoValidar) {
        boolean validado = false;
        for (Animal animal : animales) {
            if (animal.getCodigo().equalsIgnoreCase(codigoValidar)) {
                validado = true;
            }
        }
        return validado;
    }

    /**
     * Permite agregar animales al zoologico Si el animal ya está en el
     * zoologico (ArrayList animales), no agrega el animal Devuelve
     *
     * @param animal
     * @return Devuelve true si el animal ha sido agragado o false si no.
     */
    public boolean agregarAnimal(Animal animal) {
        boolean agregado = false;
        if (!animales.contains(animal)) {
            animales.add(animal);
            agregado = true;
        }
        return agregado;
    }

    /**
     * Busca un animal dentro del zoológico a partir de su código único.
     *
     * Recorre la lista de animales y compara el código de cada uno con el
     * código introducido como parámetro. La comparación no distingue entre
     * mayúsculas y minúsculas.
     *
     * @param codigoAnimal Código único del animal que se desea buscar
     * @return Objeto {@link Animal} cuyo código coincide con el indicado, si no
     * coincide se devuelve {@code null}
     */
    public Animal buscarAnimalCodigo(String codigoAnimal) {
        Animal animalBuscado = null;
        for (Animal animal : animales) {
            if (animal.getCodigo().equalsIgnoreCase(codigoAnimal)) {
                animalBuscado = animal;
            }
        }
        return animalBuscado;
    }

    /**
     * Añade ejemplares a un animal identificado por su código.
     *
     * @param cantidadAgregar cantidad a sumar
     * @param codigoAnimal código del animal
     *
     * Si la cantidad introducida es mayor que 0 y el animal exite, se suma a la
     * cantidad de ejemplares exitentes la cantidad introducida
     *
     * @return Devuelve una array de boolean para saber si se han agregado
     * ejemplares o si no, saber el motivo.
     *
     * [0] -> Si se han agregado o no [1] -> Si no se han agregado y ha sido
     * porque la cantidad a agregar es negativa [2] -> Si no se han agregado y
     * ha sido porque el animal no exite
     */
    public ArrayList<Boolean> agregarEjemplares(int cantidadAgregar, String codigoAnimal) {
        ArrayList<Boolean> controlErrores = new ArrayList<>(Arrays.asList(false, false, false));
        Animal animalBuscado = buscarAnimalCodigo(codigoAnimal);
        if (cantidadAgregar > 0) {
            controlErrores.set(1, true);
            if (animalBuscado != null) {
                controlErrores.set(2, true);
                animalBuscado.setCantidad(animalBuscado.getCantidad() + cantidadAgregar);
                controlErrores.set(0, true);
            }
        }
        return controlErrores;
    }

    /**
     * Retira ejemplares de un animal identificado por su código.
     *
     * @param cantidadRetirar Cantidad de ejemplares a retirar
     * @param codigoAnimal codigo del animal
     *
     * Si el animal está registrado en el Zoologico, la cantidad a retirar es
     * positiva y no supera al numero de ejemplares actual, se retiran los
     * ejemplares seleccionados
     *
     * @return Devuelve un array de boolean para saber si se han reitrado
     * ejemplares y en el caso de que no, saber el motivo
     *
     * [0] -> Se han podido retirar ejemplares. [1] -> No se han podido retirar
     * porque la cantidad a retirar es menos o igual a 0. [2] -> No se han
     * podido retirar porque la cantidad a retirar supera a la cantidad actual
     * de ejemplares. [3] -> No se ha podido retirar porque el animal no se ha
     * encontrado
     */
    public ArrayList<Boolean> retirarEjemplares(int cantidadRetirar, String codigoAnimal) {
        ArrayList<Boolean> controlErrores = new ArrayList<Boolean>(Arrays.asList(false, false, false, false));
        Animal animalBuscado = buscarAnimalCodigo(codigoAnimal);
        if (animalBuscado != null) {
            controlErrores.set(3, true);
            if (cantidadRetirar > 0) {
                controlErrores.set(1, true);
                if (animalBuscado.getCantidad() >= cantidadRetirar) {
                    controlErrores.set(2, true);
                    animalBuscado.setCantidad(animalBuscado.getCantidad() - cantidadRetirar);
                    controlErrores.set(0, true);
                }
            }
        }
        return controlErrores;
    }

    /**
     * Método que permite eliminar animales del Zoologico
     *
     * @param animal Animal a eliminar
     * @return ArrayList de boolean para indicar si se ha eliminado el animal, o
     * si no se ha eliminado, indicar el motivo
     */
    // [0] -> Se ha podido eliminar el animal
    // [1] -> No se ha eliminado porque el animal no existe
    // [2] -> No se ha eliminado porque hay ejemplares disponibles
    public ArrayList<Boolean> eliminarAnimales(Animal animal) {
        ArrayList<Boolean> controlErrores = new ArrayList<Boolean>(Arrays.asList(false, false, false));
        if (animales.contains(animal)) {
            controlErrores.set(1, true);
            if (animal.getCantidad() == 0) {
                controlErrores.set(2, true);
                animales.remove(animal);
                controlErrores.set(0, true);
            }
        }
        return controlErrores;
    }
}
