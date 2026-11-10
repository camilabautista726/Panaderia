module co.edu.uniquindio.poo.panaderia {
    requires java.logging;
    requires javafx.controls;
    requires javafx.fxml;


    exports co.edu.uniquindio.poo.panaderia.model;
    exports co.edu.uniquindio.poo.panaderia.app;
    exports co.edu.uniquindio.poo.panaderia.viewController;
    exports co.edu.uniquindio.poo.panaderia.controller;
    opens co.edu.uniquindio.poo.panaderia.viewController to javafx.fxml;


}
