package co.edu.uniquindio.poo.panaderia.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.panaderia.app.Aplicacion;

import co.edu.uniquindio.poo.panaderia.controller.AsignarPedidoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AsignarPedidoViewController {
    private static final String ESTILO_MENSAJE_ERROR = "-fx-text-fill: #b51515; -fx-font-size: 12px;";
    private static final String ESTILO_MENSAJE_EXITO = "-fx-text-fill: #16A34A; -fx-font-size: 12px;";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAsignar;

    @FXML
    private Button btnVolver;

    @FXML
    private Label lblResultado;

    @FXML
    private TextField txtCodigo;
    private Aplicacion aplicacion;
    private AsignarPedidoController asignarPedidoController;

    @FXML
    void asignar(ActionEvent event) {
         String codigo= txtCodigo.getText().trim();
         if (codigo.isEmpty()) {
            mostrarMensaje("Ingrese el codido del pedido.", true);
            return;
         }
         try{
         asignarPedidoController.asignarPedido(codigo);
         mostrarMensaje("El pedido fue asigando con exito", false);
         limpiarCampos();
         }catch(IllegalArgumentException e) {
            mostrarMensaje(e.getMessage(), true);
            
        }catch(IllegalStateException e) {
            mostrarMensaje(e.getMessage(), true);
        }

    }

    private void limpiarCampos() {
        txtCodigo.clear();
    }
    
    @FXML
    void volver(ActionEvent event) {
        aplicacion.openViewMenu();
    }
    public void setApp(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        this.asignarPedidoController =
                new AsignarPedidoController(aplicacion.panaderia);
    }
     private void mostrarMensaje(String mensaje, boolean error) {
        lblResultado.setText(mensaje);
        lblResultado.setStyle(error ? ESTILO_MENSAJE_ERROR : ESTILO_MENSAJE_EXITO);
    }

    @FXML
    void initialize() {
        assert btnAsignar != null : "fx:id=\"btnAsignar\" was not injected: check your FXML file 'AsignarPedido.fxml'.";
        assert btnVolver != null : "fx:id=\"btnVolver\" was not injected: check your FXML file 'AsignarPedido.fxml'.";
        assert lblResultado != null : "fx:id=\"lblResultado\" was not injected: check your FXML file 'AsignarPedido.fxml'.";
        assert txtCodigo != null : "fx:id=\"txtCodigo\" was not injected: check your FXML file 'AsignarPedido.fxml'.";

    }

}
