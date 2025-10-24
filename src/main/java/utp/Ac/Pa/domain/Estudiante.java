package utp.Ac.Pa.domain;

public class Estudiante extends Usuario {
    private String carrera;
    private String matricula;

    public Estudiante(String id, String nombre, String carrera, String matricula){
        super(id, nombre);
        this.carrera = carrera;
        this.matricula = matricula;
    }

    public String getTipo(){ return "ESTUDIANTE"; }
}