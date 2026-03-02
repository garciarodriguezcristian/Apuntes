package ejercicios.relacion3.Ejercicio1;

import java.util.ArrayList;

public class Puerto {

    private String nombre;
    private String ubicacion;
    private int capacidadMaxima;
    private String telefonoContacto;
    private ArrayList<Amarre> amarres = new ArrayList<>();
    private ArrayList<Embarcacion> embarcaciones = new ArrayList<>();
    private ArrayList<String> matriculasAmarradas = new ArrayList<>();

    // CONSTRUTOR
    public Puerto(String nombre, String ubicacion, int capacidadMaxima, String telefonoContacto) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.telefonoContacto = telefonoContacto;
        this.amarres = new ArrayList<>();
        this.embarcaciones = new ArrayList<>();
        this.matriculasAmarradas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre;
        }
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        if (ubicacion != null && !ubicacion.isBlank()) {
            this.ubicacion = ubicacion;
        }
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima > 10) {
            this.capacidadMaxima = capacidadMaxima;
        } else {
            this.capacidadMaxima = 10;
        }
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        if (telefonoContacto.trim().length() == 9) {
            this.telefonoContacto = telefonoContacto.trim();
        } else {
            this.telefonoContacto = "Sin teléfono de contacto";
        }
    }

    public ArrayList<Amarre> getAmarres() {
        return amarres;
    }

    public ArrayList<Embarcacion> getEmbarcaciones() {
        return embarcaciones;
    }

    public ArrayList<String> getAmarreDeEmbarcacion() {
        return matriculasAmarradas;
    }

    @Override
    public String toString() {
        return nombre.toUpperCase()
                + "\nUbicacion = " + ubicacion
                + " | CapacidadMaxima = " + capacidadMaxima
                + " | Telefono de contacto = " + telefonoContacto
                + "\nAMARRES\n" + amarres.toString()
                + "\nEMBARCACIONES\n" + embarcaciones.toString()
                + "\nAmarreDeEmbarcacion = " + matriculasAmarradas;
    }

    // Métodos 
    public String registrarEmbarcacion(Embarcacion embarcacion) {
        String mensaje;
        boolean barcoRepetido = false;

        if (embarcaciones.contains(embarcacion)) {
            barcoRepetido = true;
        }
        if (barcoRepetido) {
            mensaje = "ERROR. Embarcación ya registrada";
        } else {
            embarcaciones.add(embarcacion);
            mensaje = "Embarcacion " + embarcacion.getNombre() + " registrada";
        }
        return mensaje;
    }

    public String altaAmarre(Amarre nuevoAmarre) {
        String mensaje;
        boolean amarreRepetido = false;
        if (amarres.size() < capacidadMaxima) {
            for (Amarre amarre : amarres) {
                if (amarre.getNumero() == nuevoAmarre.getNumero()) {
                    amarreRepetido = true;
                }
            }
            if (amarreRepetido) {
                mensaje = "ERROR. El amarre ya está dado de alta";
            } else {
                amarres.add(nuevoAmarre);
                mensaje = "Amarre Nº " + nuevoAmarre.getNumero() + "(" + nuevoAmarre.getTipoAmarre() + ") AÑADIDO";
            }
        } else {
            mensaje = "Capacidad máxima del puerto alcanzada. No se pueden registrar más amarres";
        }
        return mensaje;
    }

    public boolean asignarAmarre(String matricula, int numeroAmarre) {
        boolean asignado = false;

        return asignado;
    }

    public void liberarAmarre(int numeroAmarre) {
        boolean encontrado = false;
        for (int i = 0; i < amarres.size() && !encontrado; i++) {
            if (amarres.get(i).getNumero() == numeroAmarre) {
                encontrado = true;
                amarres.get(i).liberar();
            }
        }
    }

    public String mostrarAmarresLibres() {
        String mensaje = "\nAMARRES LIBRES";
        if (amarres.isEmpty()) {
            mensaje = "No hay amarres registrados";
        } else {
            boolean hayLibres = false;
            for (Amarre amarre : amarres) {
                if (!amarre.getOcupado()) { //Si el amarre no ocupado, es decir si la condicion es false
                    mensaje += amarre.toString();
                    hayLibres = true;
                }
            }
            if (!hayLibres) {
                mensaje = "TODOS LOS AMARRES ESTÁN OCUPADOS";
            }
        }
        return mensaje;
    }

    public String mostrarAmarresOcupados() {
        String mensaje = "\nAMARRES OCUPADOS";
        if (amarres.isEmpty()) {
            mensaje = "No hay amarres registrados";
        } else {
            boolean hayOcupados = false;
            for (Amarre amarre : amarres) {
                if (amarre.getOcupado()) { //Si el amarre está ocupado, es decir si la condicion es true
                    mensaje += amarre.toString();
                    hayOcupados = true;
                }
            }
            if (!hayOcupados) {
                mensaje = "TODOS LOS AMARRES ESTÁN LIBRES";
            }
        }
        return mensaje;
    }

    public Embarcacion buscarEmbarcacion(String matricula) {
        Embarcacion buscada = null;
        boolean encontrada = false;
        for (int i = 0; i < embarcaciones.size() && !encontrada; i++) {
            if (embarcaciones.get(i).getMatricula().equals(matricula)) {
                encontrada = true;
                buscada = embarcaciones.get(i);
            }
        }
        return buscada;
    }

    public double calcularIngresosDiariosActuales() {
        double ingresosDiarios = 0;
        for (Amarre amarre : amarres) {
            if (amarre.getOcupado()) {
                ingresosDiarios += amarre.getPrecioDia();
            }
        }
        return ingresosDiarios;
    }

    public double calcularIngresosDiariosMaximos() {
        double ingresosDiariosMaximos = 0;
        for (Amarre amarre : amarres) {
            ingresosDiariosMaximos += amarre.getPrecioDia();
        }
        return ingresosDiariosMaximos;
    }
}
