package utp.Ac.Pa.domain;

public class Rol {
    private String nombre; // "ADMIN", "BIBLIO", "CONSULTA"

    public Rol(String nombre){ this.nombre = nombre; }
    public String getNombre(){ return nombre; }

    // Permisos muy simples para el avance
    public boolean tienePermiso(String accion){
        if ("ADMIN".equalsIgnoreCase(nombre)) return true;
        if ("BIBLIO".equalsIgnoreCase(nombre)) {
            return !"CONFIGURAR_SISTEMA".equalsIgnoreCase(accion);
        }
        // CONSULTA
        return "BUSCAR".equalsIgnoreCase(accion) || "REPORTE".equalsIgnoreCase(accion);
    }
}