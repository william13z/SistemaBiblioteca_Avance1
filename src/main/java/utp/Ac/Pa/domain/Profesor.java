package utp.Ac.Pa.domain;

public class Profesor extends Usuario {
    private String departamento;
    private String empleadoId;

    public Profesor(String id, String nombre, String departamento, String empleadoId){
        super(id, nombre);
        this.departamento = departamento;
        this.empleadoId = empleadoId;
    }

    public String getTipo(){ return "PROFESOR"; }
}
