package co.edu.uniquindio.poo.panaderia.model;

public abstract class Panadero extends Empleado implements CalcularTiempoProduccion {
    public Panadero(String nombre, String documento, String codigo, int minutosDisponibles) {
        super(nombre, documento, codigo, minutosDisponibles);
    }

    public boolean puedeAtender(Pedido p) {
        return false;
    }

    public void descontarMinutos(int m) {
    }

    public void devolverMinutos(int m) {
    }
}
