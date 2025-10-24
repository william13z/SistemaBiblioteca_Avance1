package utp.Ac.Pa.domain;

public class Ejemplar {
    private String codigo;
    private Libro libro;
    private boolean disponible = true;

    public Ejemplar(String codigo, Libro libro) {
        this.codigo = codigo;
        this.libro = libro;
    }

    public String getCodigo() { return codigo; }
    public Libro getLibro() { return libro; }
    public boolean isDisponible() { return disponible; }

    public void marcarPrestado() { disponible = false; }
    public void marcarDisponible() { disponible = true; }
}