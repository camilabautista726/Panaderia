package co.edu.uniquindio.poo.panaderia.controller;
import java.util.Optional;
import co.edu.uniquindio.poo.panaderia.model.Pedido;
import co.edu.uniquindio.poo.panaderia.model.Panadero;

import co.edu.uniquindio.poo.panaderia.model.Panaderia;

public class AsignarPedidoController {
    private final Panaderia panaderia;
    public AsignarPedidoController (Panaderia panaderia) {
        this.panaderia = panaderia;
    }
    public Optional <Pedido> encontrarPedido(String codigo){
        return panaderia.buscarPedido(codigo);
    }
     public boolean verificarExistePedido(String codigo){
        return encontrarPedido(codigo).isPresent();
    }
    public boolean verificarEstaAsignado(String codigo){
        return panaderia.verificarPedidoAsignado(codigo);
    }
     public boolean verificarEstaCancelado(String codigo){
        return panaderia.verificarPedidoCancelado(codigo);
    }
    public Optional <Panadero> encontrarPanaderoOptimo(String codigo){
        Optional <Pedido> pedidoEncontrado= encontrarPedido(codigo);
        return panaderia.seleccionarPanadero (pedidoEncontrado.get());
    }
    public boolean verificarHayPanaderoOptimo(String codigo) {
    return encontrarPanaderoOptimo(codigo).isPresent();
    }
   
    

    public void asignarPedido(String codigo){
        if(!verificarExistePedido(codigo)){
            throw new IllegalArgumentException("No existe un pedido registrado con ese codigo");
        }
         if(verificarEstaCancelado(codigo)){
            throw new IllegalStateException("Ese pedido ya está cancelado");
        }
        if(verificarEstaAsignado(codigo)){
            throw new IllegalStateException("Ese pedido ya está asignado");
        }
        if(!verificarHayPanaderoOptimo(codigo)){
            throw new IllegalStateException("Ningún panadero tiene tiempo suficiente");
        }
        Panadero panadero= encontrarPanaderoOptimo(codigo).get();
        panaderia.asignarPedido(panadero, codigo);
        
    }
}
