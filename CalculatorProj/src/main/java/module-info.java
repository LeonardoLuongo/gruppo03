module com.mycompany.calculatorproj {
    requires javafx.controls;
    requires javafx.fxml;

    opens calculator to javafx.fxml;
    exports calculator;
}
