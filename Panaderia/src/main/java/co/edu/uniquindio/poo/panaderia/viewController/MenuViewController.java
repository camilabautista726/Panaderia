package co.edu.uniquindio.poo.panaderia.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.panaderia.app.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAsignar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnRegistrar;
    private Aplicacion aplicacion;

    @FXML
    void abrirAsignar(ActionEvent event) {
         aplicacion.openViewAsignarPedido();
    }

    @FXML
    void abrirCancelar(ActionEvent event) {
        aplicacion.openViewCancelarPedido();

    }

    @FXML
    void abrirRegistrar(ActionEvent event) {
         aplicacion.openViewRegistrarPedido();

    }
    public void setApp(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
    }

    @FXML
    void initialize() {
        assert btnAsignar != null : "fx:id=\"btnAsignar\" was not injected: check your FXML file 'Menu.fxml'.";
        assert btnCancelar != null : "fx:id=\"btnCancelar\" was not injected: check your FXML file 'Menu.fxml'.";
        assert btnRegistrar != null : "fx:id=\"btnRegistrar\" was not injected: check your FXML file 'Menu.fxml'.";

    }

}
