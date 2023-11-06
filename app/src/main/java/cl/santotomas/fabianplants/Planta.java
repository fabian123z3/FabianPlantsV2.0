package cl.santotomas.fabianplants;

public class Planta {
    private String nombre;
    private String descripcion;

    public Planta(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}