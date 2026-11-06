module co.edu.uniquindio.poo.panaderia {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens co.edu.uniquindio.poo.panaderia to javafx.fxml;
    exports co.edu.uniquindio.poo.panaderia;
}