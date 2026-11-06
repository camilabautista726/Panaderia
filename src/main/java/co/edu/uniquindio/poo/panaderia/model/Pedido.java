package co.edu.uniquindio.poo.panaderia.model;

public class Pedido {
    private final String codigo;
    private final String nombreCliente;
    private TipoPan tipoPan;
    private int cantidad;
    private EstadoPedido estado;
    private String codigoEmpleado;
    private int minutosReservados;

    public Pedido(String codigo, String nombreCliente, TipoPan tipoPan, int cantidad, EstadoPedido estado) {
        this.codigo = codigo;
        this.nombreCliente = nombreCliente;
        this.tipoPan = tipoPan;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public TipoPan getTipoPan() {
        return tipoPan;
    }

    public void setTipoPan(TipoPan tipoPan) {
        this.tipoPan = tipoPan;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public int getMinutosReservados() {
        return minutosReservados;
    }

    public void setMinutosReservados(int minutosReservados) {
        this.minutosReservados = minutosReservados;
    }
}
