package co.edu.uniquindio.poo.panaderia.viewController;

import java.net.URL;
import java.util.ResourceBundle;


import co.edu.uniquindio.poo.panaderia.model.Panaderia;
import co.edu.uniquindio.poo.panaderia.app.Aplicacion;
import co.edu.uniquindio.poo.panaderia.model.TipoPan;
import co.edu.uniquindio.poo.panaderia.controller.RegistrarPedidoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class RegistrarPedidoViewController {
    //Mensajes de éxito y error
    private static final String ESTILO_MENSAJE_ERROR = "-fx-text-fill: #b51515; -fx-font-size: 12px;";
    private static final String ESTILO_MENSAJE_EXITO = "-fx-text-fill: #16A34A; -fx-font-size: 12px;";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnVolver;

    @FXML
    private ComboBox<TipoPan> cmbTipoPan;

    @FXML
    private Label lblMensaje;

    @FXML
    private Spinner<Integer> spnCantidad;

    @FXML
    private TextField txtCliente;

    @FXML
    private TextField txtCodigo;
    private Aplicacion aplicacion;
    private RegistrarPedidoController registroPedidoController;

    @FXML
    void registrar(ActionEvent event) {
        String codigo= txtCodigo.getText().trim();
        String cliente= txtCliente.getText().trim();
        TipoPan tipo= cmbTipoPan.getValue();
        Integer cantidad= spnCantidad.getValue();
        if (codigo.isEmpty() || cliente.isEmpty() || tipo==null || cantidad== null) {
            mostrarMensaje("Complete todos los campos para registrar su pedido.", true);
            return;
        }

        try{
        registroPedidoController.registrarPedido(codigo, cliente, tipo, cantidad);
        mostrarMensaje("El pedido fue registrado con éxito", false);
        limpiarCampos();
        //"Atrapa" la excepción para cantidades iguales o menores a cero y muestra error
        }catch (IllegalArgumentException e) {
            mostrarMensaje(e.getMessage(), true);
            //Tipo de alerta error
        }
        catch (Exception e) {
                e.printStackTrace();
                mostrarMensaje("Ocurrió un error inesperado.", true);

        }
    }

    private void mostrarMensaje(String mensaje, boolean error) {
        lblMensaje.setText(mensaje);
        lblMensaje.setStyle(error ? ESTILO_MENSAJE_ERROR : ESTILO_MENSAJE_EXITO);
    }

    @FXML
    void volver(ActionEvent event) {
        aplicacion.openViewMenu();

    }
    public void setApp(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        this.registroPedidoController =
                new RegistrarPedidoController(aplicacion.panaderia);
    }
    private void limpiarCampos() {
        txtCodigo.clear();
        txtCliente.clear();
        cmbTipoPan.setValue(null);
        spnCantidad.getValueFactory().setValue(1);
        txtCodigo.requestFocus();
    }

    @FXML
    void initialize() {
        assert btnRegistrar != null : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'RegistrarPedido.fxml'.";
        assert btnVolver != null : "fx:id=\"btnVolver\" was not injected: check your FXML file 'RegistrarPedido.fxml'.";
        assert cmbTipoPan != null : "fx:id=\"cmbTipoPan\" was not injected: check your FXML file 'RegistrarPedido.fxml'.";
        assert lblMensaje != null : "fx:id=\"lblMensaje\" was not injected: check your FXML file 'RegistrarPedido.fxml'.";
        assert spnCantidad != null : "fx:id=\"spnCantidad\" was not injected: check your FXML file 'RegistrarPedido.fxml'.";
        assert txtCliente != null : "fx:id=\"txtCliente\" was not injected: check your FXML file 'RegistrarPedido.fxml'.";
        assert txtCodigo != null : "fx:id=\"txtCodigo\" was not injected: check your FXML file 'RegistrarPedido.fxml'.";
        //Ajustar el comboBox para el tipo de pan y el spinner para la cantidad
        cmbTipoPan.getItems().setAll(TipoPan.values());
        spnCantidad.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000));
    }

}

