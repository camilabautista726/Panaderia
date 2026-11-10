package co.edu.uniquindio.poo.panaderia.model;

public abstract class Panadero extends Empleado implements CalcularTiempoProduccion {
    public Panadero(String nombre, String documento, String codigo, int minutosDisponibles) {
        super(nombre, documento, codigo, minutosDisponibles);
    }
    

    public boolean puedeAtender( Pedido pedido) {
        return minutosDisponibles>= calcularMinutos(pedido);
    }


    public void descontarMinutos(int minutosDelPedido) {
        minutosDisponibles -= minutosDelPedido;
    }

    public void devolverMinutos(int minutosDelPedido) {
        minutosDisponibles+= minutosDelPedido;
    }

    public void verificarTiempoDisponible(Pedido pedido, boolean puedeAtender){
        if(minutosDisponibles>= pedido.getMinutosReservados()){
            puedeAtender = true;
        }
    }
    
}
