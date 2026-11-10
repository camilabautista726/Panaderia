package co.edu.uniquindio.poo.panaderia.controller;

import java.util.Optional;
import co.edu.uniquindio.poo.panaderia.model.Pedido;
import co.edu.uniquindio.poo.panaderia.model.Panadero;
import co.edu.uniquindio.poo.panaderia.model.EstadoPedido;
import co.edu.uniquindio.poo.panaderia.model.Panaderia;

public class CancelarPedidoController {

    private final Panaderia panaderia;
    public CancelarPedidoController (Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    public Optional <Pedido> encontrarPedido(String codigo){
        return panaderia.buscarPedido(codigo);
    }
    
    public void cancelarPedido (String codigo){
        if(encontrarPedido(codigo).isEmpty()){
            throw new IllegalArgumentException("No existe un pedido registrado con ese codigo");
        }
        Pedido  pedido = encontrarPedido(codigo).get();
        
        if(pedido.getEstado()==EstadoPedido.CANCELADO){
            throw new IllegalStateException("Ese pedido ya está cancelado");
        }
    
        panaderia.cancelarPedido(pedido);
    }
    
}
