package utp.Ac.Pa.config;

public class ConfiguracionSistema {
    private int diasPrestamo;
    private double multaPorDia;
    private int maxPrestamosPorUsuario;
    private boolean permitirRenovacion;

    public ConfiguracionSistema(int diasPrestamo, double multaPorDia, int maxPrestamosPorUsuario, boolean permitirRenovacion){
        this.diasPrestamo=diasPrestamo; this.multaPorDia=multaPorDia; this.maxPrestamosPorUsuario=maxPrestamosPorUsuario; this.permitirRenovacion=permitirRenovacion;
    }
    public static ConfiguracionSistema cargarPorDefecto(){ return new ConfiguracionSistema(14, 0.50, 3, true); }
    public void actualizar(int d, double m, int max, boolean r){ diasPrestamo=d; multaPorDia=m; maxPrestamosPorUsuario=max; permitirRenovacion=r; }
    public int getDiasPrestamo(){ return diasPrestamo; }
    public double getMultaPorDia(){ return multaPorDia; }
    public int getMaxPrestamosPorUsuario(){ return maxPrestamosPorUsuario; }
    public boolean isPermitirRenovacion(){ return permitirRenovacion; }
}