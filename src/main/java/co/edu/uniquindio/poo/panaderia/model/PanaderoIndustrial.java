package co.edu.uniquindio.poo.panaderia.model;

public class PanaderoIndustrial  extends Panadero{
    private static final int MIN_PREPARACION = 20;
    private static final int TAMANO_LOTE = 30;
    private static final int MIN_LOTE_TRAD = 25;
    private static final int MIN_LOTE_INTEGRAL = 35;

    public PanaderoIndustrial(String nombre, String documento, String codigo, int minutosDisponibles) {
        super(nombre, documento, codigo, minutosDisponibles);
    }

    @Override
    public int calcularMinutos(Pedido p) {
        return 0;
    }
}
