package co.edu.uniquindio.poo.panaderia.model;

import java.util.ArrayList;
import java.util.Optional;

public class Panaderia {
    private final String nombre;
    private final String nit;
    private ArrayList<Empleado> empleados;
    private ArrayList<Pedido> pedidos;

    public Panaderia(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public void registrarEmpleado(Empleado e) {
    }

    public void registrarPedido(String codigo, String cliente, TipoPan tipo, int cantidad) {
        // IllegalArgumentException si cantidad <= 0 o codigo repetido
    }

    public void asignarPedido(String codigo) {
        // IllegalArgumentException si no existe
        //       IllegalStateException si ya esta CANCELADO o PENDIENTE o ningun panadero alcanza
    }

    public void cancelarPedido(String codigo) {
        // IllegalArgumentException si no existe
        //       IllegalStateException si ya esta CANCELADO
    }

    private Optional<Pedido> buscarPedido(String codigo) {
    }

    private Optional<Empleado> buscarEmpleado(String codigo) {
    }
}
