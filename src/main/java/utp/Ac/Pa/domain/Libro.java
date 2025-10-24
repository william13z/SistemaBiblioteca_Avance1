package utp.Ac.Pa.domain;
import java.util.*;

public class Libro {
    private String isbn;
    private String titulo;
    private int anio;
    private Editorial editorial;
    private List<Autor> autores = new ArrayList<>();
    private List<Categoria> categorias = new ArrayList<>();

    public Libro(String isbn, String titulo, int anio, Editorial editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.editorial = editorial;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public int getAnio() { return anio; }
    public Editorial getEditorial() { return editorial; }

    public void agregarAutor(Autor autor) {
        if (autor != null) autores.add(autor);
    }

    public void agregarCategoria(Categoria categoria) {
        if (categoria != null) categorias.add(categoria);
    }

    public List<Autor> getAutores() { return autores; }
    public List<Categoria> getCategorias() { return categorias; }
}