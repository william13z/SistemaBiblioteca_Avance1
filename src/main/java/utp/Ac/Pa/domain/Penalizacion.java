package utp.Ac.Pa.domain;

public class Penalizacion {
    private int diasAtraso;
    private double montoTotal;

    public Penalizacion(int diasAtraso, double montoTotal){
        this.diasAtraso = diasAtraso;
        this.montoTotal = montoTotal;
    }

    public boolean esMoroso(){ return diasAtraso > 0; }
    public int getDiasAtraso(){ return diasAtraso; }
    public double getMontoTotal(){ return montoTotal; }
}