module com.company.calculatorproject.CalculatorGUI {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens calculatorproject to javafx.fxml;
    exports calculatorproject;
}
