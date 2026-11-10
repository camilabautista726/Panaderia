package co.edu.uniquindio.poo.panaderia.model;

public abstract class Empleado {
    private final String nombre;
    private final String documento;
    private final String codigo;
    protected int minutosDisponibles;

    public Empleado(String nombre, String documento, String codigo, int minutosDisponibles) {
        this.nombre = nombre;
        this.documento = documento;
        this.codigo = codigo;
        this.minutosDisponibles = minutosDisponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getMinutosDisponibles() {
        return minutosDisponibles;
    }

    public void setMinutosDisponibles(int minutosDisponibles) {
        this.minutosDisponibles = minutosDisponibles;
    }
}
