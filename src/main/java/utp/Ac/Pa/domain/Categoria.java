package utp.Ac.Pa.domain;

public class Categoria {
    private String id;
    private String nombre;

    public Categoria(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return nombre;
    }
}