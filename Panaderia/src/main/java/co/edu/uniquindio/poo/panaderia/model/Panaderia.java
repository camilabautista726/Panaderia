package co.edu.uniquindio.poo.panaderia.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Panaderia {
    private final String nombre;
    private final String nit;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Pedido> listaPedidos;

    public Panaderia(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.listaEmpleados= new ArrayList<>();
        this.listaPedidos= new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public boolean registrarEmpleado(Empleado e) {
        Optional <Empleado> empleadoEncontrado= buscarEmpleado(e.getDocumento());
        if(empleadoEncontrado.isEmpty()){
            listaEmpleados.add(e);
            return true;
        }
        return false;

    }
    public void registrarPedido(Pedido pedido) {
        if (pedido.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }
        if (buscarPedido(pedido.getCodigo()).isPresent()) {
            throw new IllegalArgumentException("El código " + pedido.getCodigo() + " ya existe.");
        }
        pedido.setEstado(EstadoPedido.PENDIENTE);
        listaPedidos.add(pedido);
    }

    public void asignarPedido(Panadero panadero, String codigo) {

        Optional<Pedido> busqueda= buscarPedido(codigo);
        if (busqueda.isEmpty()) {
            throw new IllegalArgumentException("No existe el pedido " + codigo);
        }
        Pedido pedido = busqueda.get();
        if (pedido.getEstado() != EstadoPedido.PENDIENTE) {
            throw new IllegalStateException("Solo se pueden asignar pedidos pendientes.");
        }
        if (!panadero.puedeAtender(pedido)) {
            throw new IllegalStateException("El panadero no tiene tiempo suficiente.");
        }
        pedido.setEstado(EstadoPedido.ASIGNADO);
        pedido.setCodigoEmpleado(panadero.getCodigo());
        int minutos = panadero.calcularMinutos(pedido);
        pedido.setMinutosReservados(minutos);
        panadero.descontarMinutos(minutos);
    }

    public Optional<Panadero> buscarPanadero(String codigo) {
    return listaEmpleados.stream().filter(e -> e instanceof Panadero).map(e -> (Panadero) e).filter(p -> p.getCodigo().equals(codigo)).findFirst();
    }

    public void cancelarPedido(Pedido pedido) {
        if(pedido.getEstado()==EstadoPedido.CANCELADO){
            throw new IllegalStateException("El pedido ya esta cancelado ");
        }
        if(pedido.getEstado()==EstadoPedido.PENDIENTE){
            pedido.setEstado(EstadoPedido.CANCELADO);
        }else if(pedido.getEstado()== EstadoPedido.ASIGNADO){
            pedido.setEstado(EstadoPedido.CANCELADO);
            int minutosRecuperados= pedido.getMinutosReservados();
            Optional <Panadero> panadero= buscarPanadero(pedido.getCodigoEmpleado());
            if(panadero.isPresent()){
            Panadero panaderoPedido = panadero.get();
            panaderoPedido.devolverMinutos(minutosRecuperados);
            }
        }
    } 

    public Optional<Pedido> buscarPedido(String codigo) {
        return listaPedidos.stream().filter(p-> p.getCodigo().equals(codigo)).findFirst();
    }

    public Optional<Empleado> buscarEmpleado(String documento) {
        return listaEmpleados.stream().filter(e -> e.getDocumento().equals(documento)).findFirst();
    }
    public boolean verificarPedidoAsignado(String codigo){
        return listaPedidos.stream().filter(p -> p.getCodigo().equals(codigo)).anyMatch(p -> p.getEstado()== EstadoPedido.ASIGNADO);

    }
    public boolean verificarPedidoCancelado(String codigo){
        return listaPedidos.stream().filter(p -> p.getCodigo().equals(codigo)).anyMatch(p -> p.getEstado()== EstadoPedido.CANCELADO);
    }
    public Optional <Panadero> seleccionarPanadero (Pedido pedido){
        return listaEmpleados.stream().filter(e -> e instanceof Panadero).map(e -> (Panadero) e).filter(p -> p.puedeAtender(pedido)).min(Comparator.comparingInt(p -> p.calcularMinutos(pedido)));
    }
    
}
