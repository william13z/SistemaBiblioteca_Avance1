package utp.Ac.Pa.domain;

public abstract class Usuario {
    protected String id;
    protected String nombre;
    protected boolean activo = true;
    protected int prestamosActuales = 0;

    public Usuario(String id, String nombre){ this.id=id; this.nombre=nombre; }

    public boolean puedeTomarPrestamo(int max){ return activo && prestamosActuales < max; }
    public void incrementarPrestamos(){ prestamosActuales++; }
    public void decrementarPrestamos(){ if (prestamosActuales > 0) prestamosActuales--; }

    public String getId(){ return id; }
    public String getNombre(){ return nombre; }
    public boolean isActivo(){ return activo; }
    public void setActivo(boolean activo){ this.activo = activo; }
}