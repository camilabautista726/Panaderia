package co.edu.uniquindio.poo.panaderia.controller;
import java.util.Optional;

import co.edu.uniquindio.poo.panaderia.model.EstadoPedido;
import co.edu.uniquindio.poo.panaderia.model.Panaderia;
import co.edu.uniquindio.poo.panaderia.model.Pedido;
import co.edu.uniquindio.poo.panaderia.model.TipoPan;

public class RegistrarPedidoController {

    private final Panaderia panaderia;

    public RegistrarPedidoController(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    public boolean existePedido(String codigo){
        return encontrarPedido(codigo).isPresent();
    }
    public Optional <Pedido> encontrarPedido(String codigo){
        return panaderia.buscarPedido(codigo);
    }


    public void registrarPedido( String codigo, String cliente, TipoPan tipo, Integer cantidad){
        if(cantidad<= 0){
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero (0)");
        }else if(existePedido(codigo)){
            throw new IllegalArgumentException("Este pedido ya existe");
        }
        Pedido pedido= new Pedido(codigo, cliente, tipo, cantidad, EstadoPedido.PENDIENTE);
        panaderia.registrarPedido(pedido);
    }
}
