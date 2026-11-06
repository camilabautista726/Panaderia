package co.edu.uniquindio.poo.panaderia.model;

public class PanaderoArtesanal extends Panadero{
    private static final int TAMANO_BANDEJA = 12;
    private static final int MIN_BANDEJA_TRAD = 30;
    private static final int MIN_BANDEJA_INTEGRAL = 40;

    public PanaderoArtesanal(String nombre, String documento, String codigo, int minutosDisponibles) {
        super(nombre, documento, codigo, minutosDisponibles);
    }

    @Override
    public int calcularMinutos(Pedido p) {
        return 0;
    }
}
