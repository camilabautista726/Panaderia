package co.edu.uniquindio.poo.panaderia.model;

public class Cajero extends Empleado{
    private int caja;

    public Cajero(String nombre, String documento, String codigo, int minutosDisponibles, int caja) {
        super(nombre, documento, codigo, minutosDisponibles);
        this.caja = caja;
    }

    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }
}
