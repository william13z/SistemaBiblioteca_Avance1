package utp.Ac.Pa.domain;

public class UsuarioSistema {
    private String username;
    private String passwordHash;   // simplificado para el avance
    private Rol rol;

    public UsuarioSistema(String username, String passwordHash, Rol rol){
        this.username = username;
        this.passwordHash = passwordHash;
        this.rol = rol;
    }

    public boolean autenticar(String pw){
        return pw != null && pw.hashCode() == passwordHash.hashCode();
    }

    public void cambiarPassword(String pwNueva){ this.passwordHash = pwNueva; }
    public Rol getRol(){ return rol; }
    public String getUsername(){ return username; }
}