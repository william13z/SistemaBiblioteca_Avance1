package utp.Ac.Pa.services;

import java.time.LocalDate;
import java.util.*;
import utp.Ac.Pa.domain.*;

public class ReporteService {

    private boolean enRango(LocalDate f, LocalDate desde, LocalDate hasta){
        if (f == null) return false;
        boolean okDesde = (desde == null) || !f.isBefore(desde);
        boolean okHasta = (hasta == null) || !f.isAfter(hasta);
        return okDesde && okHasta;
    }

    /** Ranking de libros más prestados (Top N) en un rango de fechas por fechaPrestamo */
    public List<Libro> topLibrosMasPrestados(List<Prestamo> prestamos, LocalDate desde, LocalDate hasta, int n){
        Map<Libro,Integer> conteo = new HashMap<>();
        if (prestamos == null) return new ArrayList<>();

        for (Prestamo p : prestamos){
            if (enRango(p.getFechaPrestamo(), desde, hasta)){
                Libro l = (p.getEjemplar()!=null) ? p.getEjemplar().getLibro() : null;
                if (l != null) conteo.put(l, conteo.getOrDefault(l, 0)+1);
            }
        }
        List<Map.Entry<Libro,Integer>> lista = new ArrayList<>(conteo.entrySet());
        lista.sort((a,b) -> Integer.compare(b.getValue(), a.getValue()));

        List<Libro> top = new ArrayList<>();
        for (int i=0; i<lista.size() && i<n; i++) top.add(lista.get(i).getKey());
        return top;
    }

    /** Estadísticas de préstamos por Editorial en un rango (retorna mapa Editorial→conteo) */
    public Map<Editorial,Integer> estadisticasPorEditorial(List<Prestamo> prestamos, LocalDate desde, LocalDate hasta){
        Map<Editorial,Integer> stats = new HashMap<>();
        if (prestamos == null) return stats;

        for (Prestamo p : prestamos){
            if (enRango(p.getFechaPrestamo(), desde, hasta)){
                Libro l = (p.getEjemplar()!=null) ? p.getEjemplar().getLibro() : null;
                Editorial e = (l!=null) ? l.getEditorial() : null;
                if (e != null) stats.put(e, stats.getOrDefault(e, 0)+1);
            }
        }
        return stats;
    }
}