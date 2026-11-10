package co.edu.uniquindio.poo.panaderia.app;

import co.edu.uniquindio.poo.panaderia.model.Cajero;
import co.edu.uniquindio.poo.panaderia.model.Empleado;
import co.edu.uniquindio.poo.panaderia.model.EstadoPedido;
import co.edu.uniquindio.poo.panaderia.model.Panaderia;
import co.edu.uniquindio.poo.panaderia.model.PanaderoArtesanal;
import co.edu.uniquindio.poo.panaderia.model.PanaderoIndustrial;
import co.edu.uniquindio.poo.panaderia.model.Pedido;
import co.edu.uniquindio.poo.panaderia.model.TipoPan;
import co.edu.uniquindio.poo.panaderia.viewController.AsignarPedidoViewController;
import co.edu.uniquindio.poo.panaderia.viewController.CancelarPedidoViewController;
import co.edu.uniquindio.poo.panaderia.viewController.MenuViewController;
import co.edu.uniquindio.poo.panaderia.viewController.RegistrarPedidoViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplicacion extends Application {

        private Stage primaryStage;
        public static Panaderia panaderia = new Panaderia("Panaderia", "79473939");

        @Override
        public void start(Stage primaryStage) throws IOException {
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("Gestion pedidos");
            inicializarData();
            openViewMenu();
        }

        public void openViewMenu() {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/panaderia/Menu.fxml"));
                Parent rootLayout = loader.load(); //Parent es el padre los los Vbox, StackPane, AnchorPane, etc entonces sirve para colocar el primer elemento de cualquier fxml
                MenuViewController menuViewController = loader.getController();
                menuViewController.setApp(this);

                Scene scene = new Scene(rootLayout);
                scene.getStylesheets().add(
                        getClass().getResource("/co/edu/uniquindio/poo/panaderia/estilos.css").toExternalForm()// ->Esta linea lo que hace
                        //es que vuelve visible el Css para que fxml lo use
                );
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void openViewAsignarPedido() {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/panaderia/AsignarPedido.fxml"));
                Parent rootLayout = loader.load(); //Parent es el padre los los Vbox, StackPane, AnchorPane, etc entonces sirve para colocar el primer elemento de cualquier fxml
                AsignarPedidoViewController asignarPedidoViewController = loader.getController();
                asignarPedidoViewController.setApp(this);

                Scene scene = new Scene(rootLayout);
                
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void openViewCancelarPedido() {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/panaderia/CancelarPedido.fxml"));
                Parent rootLayout = loader.load(); //Parent es el padre los los Vbox, StackPane, AnchorPane, etc entonces sirve para colocar el primer elemento de cualquier fxml
                CancelarPedidoViewController cancelarPedidoViewController = loader.getController();
                cancelarPedidoViewController.setApp(this);

                Scene scene = new Scene(rootLayout);
                
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void openViewRegistrarPedido() {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/poo/panaderia/RegistrarPedido.fxml"));
                Parent rootLayout = loader.load(); //Parent es el padre los los Vbox, StackPane, AnchorPane, etc entonces sirve para colocar el primer elemento de cualquier fxml
                RegistrarPedidoViewController registrarPedidoViewController = loader.getController();
                registrarPedidoViewController.setApp(this);

                Scene scene = new Scene(rootLayout);
                
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    public void inicializarData(){
        //Panaderos
            //Artesanales
            Empleado panaderoUno= new PanaderoArtesanal("Juan Pablo Ortega", "23507831", "PA01", 90);
            Empleado panaderoDos= new PanaderoArtesanal ("Monica Galindo Pulido", "1090678932", "PA02", 40 );
            //Industriales
            Empleado panaderoTres= new PanaderoIndustrial("Samuel Rodriguez Sanchez", "21384902", "PI01", 70);
            Empleado panaderoCuatro= new PanaderoIndustrial("Alejandra Suarez Dominguez", "1091392875", "PI02", 30);
        //Cajeros
            Empleado cajeroUno= new Cajero ("Juan Esteban Bermudez", "1092567921", "CJ01", 40, 1);
            Empleado cajeroDos= new Cajero ("Santiago Jesús Ruíz", "23641093", "CJ02", 20, 2);
        //Pedidos
            Pedido pedidoUno= new Pedido ("102", "Sebastian Botero", TipoPan.INTEGRAL, 10, EstadoPedido.PENDIENTE);
            Pedido pedidoDos= new Pedido ("930", "Manuela Ospina", TipoPan.TRADICIONAL, 5, EstadoPedido.PENDIENTE);
            Pedido pedidoTres= new Pedido ("923", "Angelica Marin", TipoPan.INTEGRAL, 8, EstadoPedido.PENDIENTE);
            Pedido pedidoCuatro= new Pedido ("673", "Tomas Chaparro", TipoPan.TRADICIONAL, 12, EstadoPedido.PENDIENTE);

        panaderia.registrarPedido(pedidoUno);
        panaderia.registrarPedido(pedidoDos);
        panaderia.registrarPedido(pedidoTres);
        panaderia.registrarPedido(pedidoCuatro);

        panaderia.registrarEmpleado(panaderoUno);
        panaderia.registrarEmpleado(panaderoDos);
        panaderia.registrarEmpleado(panaderoTres);
        panaderia.registrarEmpleado(panaderoCuatro);
        panaderia.registrarEmpleado(cajeroUno);
        panaderia.registrarEmpleado(cajeroDos);
    }



    



}
