package co.edu.uniquindio.poo.panaderia.model;

public class CalcularTiempoPanaderoIndustrial implements CalcularTiempoProduccion {
    private final int preparacionMaquina= 20;
    private final int panesPorBandeja= 30;
    private final int minutosPanTradicional = 25;
    private final int minutosPanIntegral = 35;

    @Override 
    public int calcularMinutos (Pedido p){
        int bandejasDelPedido= (p.getCantidad()+panesPorBandeja-1)/panesPorBandeja;
        int minutosPorLote= p.getTipoPan()== TipoPan.TRADICIONAL ? minutosPanTradicional : minutosPanIntegral;
        return bandejasDelPedido*minutosPorLote;
    }
    
}