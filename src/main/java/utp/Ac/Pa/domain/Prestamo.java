package utp.Ac.Pa.domain;

import java.time.Duration;
import java.time.LocalDate;
import utp.Ac.Pa.config.ConfiguracionSistema;

public class Prestamo {
    private String id;
    private Usuario usuario;
    private Ejemplar ejemplar;
    private LocalDate fechaPrestamo;
    private LocalDate fechaLimite;
    private LocalDate fechaDevolucion;   // puede ser null
    private Penalizacion penalizacion;   // null si no hay

    public Prestamo(String id, Usuario usuario, Ejemplar ejemplar,
                    LocalDate fechaPrestamo, LocalDate fechaLimite){
        this.id = id;
        this.usuario = usuario;
        this.ejemplar = ejemplar;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaLimite;
    }

    public Penalizacion calcularPenalizacion(ConfiguracionSistema cfg, LocalDate hoy){
        if (fechaDevolucion == null && hoy.isAfter(fechaLimite)) {
            long dias = Duration.between(fechaLimite.atStartOfDay(), hoy.atStartOfDay()).toDays();
            penalizacion = new Penalizacion((int) dias, cfg.getMultaPorDia() * dias);
        }
        return penalizacion;
    }

    public void cerrarDevolucion(LocalDate fecha){
        this.fechaDevolucion = fecha;
        if (ejemplar != null) ejemplar.marcarDisponible();
        if (usuario != null) usuario.decrementarPrestamos();
    }
    public utp.Ac.Pa.domain.Usuario getUsuario(){ return usuario; }
    public utp.Ac.Pa.domain.Ejemplar getEjemplar(){ return ejemplar; }
    public java.time.LocalDate getFechaPrestamo(){ return fechaPrestamo; }
    public java.time.LocalDate getFechaLimite(){ return fechaLimite; }
    public java.time.LocalDate getFechaDevolucion(){ return fechaDevolucion; }
}