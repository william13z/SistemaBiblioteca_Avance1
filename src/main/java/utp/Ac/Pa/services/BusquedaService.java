package utp.Ac.Pa.services;

import java.util.*;
import utp.Ac.Pa.domain.*;

public class BusquedaService {
    private Collection<Libro> catalogo;

    public BusquedaService(Collection<Libro> catalogo){
        this.catalogo = (catalogo != null) ? catalogo : new ArrayList<>();
    }

    public List<Libro> buscarPorTitulo(String titulo){
        List<Libro> r = new ArrayList<>();
        if (titulo == null) return r;
        for (Libro l : catalogo){
            if (l.getTitulo() != null && l.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
                r.add(l);
            }
        }
        return r;
    }

    public List<Libro> buscarPorAutor(String nombreAutor){
        List<Libro> r = new ArrayList<>();
        if (nombreAutor == null) return r;
        for (Libro l : catalogo){
            for (Autor a : l.getAutores()){
                if (a.getNombre() != null && a.getNombre().equalsIgnoreCase(nombreAutor)){
                    r.add(l); break;
                }
            }
        }
        return r;
    }

    public List<Libro> buscarPorCategoria(String nombreCategoria){
        List<Libro> r = new ArrayList<>();
        if (nombreCategoria == null) return r;
        for (Libro l : catalogo){
            for (Categoria c : l.getCategorias()){
                if (c.getNombre() != null && c.getNombre().equalsIgnoreCase(nombreCategoria)){
                    r.add(l); break;
                }
            }
        }
        return r;
    }

    public List<Libro> filtrar(String titulo, String autor, String categoria, String editorial){
        List<Libro> r = new ArrayList<>();
        for (Libro l : catalogo){
            boolean ok = true;
            if (titulo != null && (l.getTitulo()==null || !l.getTitulo().toLowerCase().contains(titulo.toLowerCase()))) ok = false;
            if (ok && autor != null){
                boolean matchAutor = false;
                for (Autor a : l.getAutores()){
                    if (a.getNombre()!=null && a.getNombre().equalsIgnoreCase(autor)){ matchAutor = true; break; }
                }
                if (!matchAutor) ok = false;
            }
            if (ok && categoria != null){
                boolean matchCat = false;
                for (Categoria c : l.getCategorias()){
                    if (c.getNombre()!=null && c.getNombre().equalsIgnoreCase(categoria)){ matchCat = true; break; }
                }
                if (!matchCat) ok = false;
            }
            if (ok && editorial != null){
                if (l.getEditorial()==null || l.getEditorial().getNombre()==null ||
                    !l.getEditorial().getNombre().equalsIgnoreCase(editorial)) ok = false;
            }
            if (ok) r.add(l);
        }
        return r;
    }
}