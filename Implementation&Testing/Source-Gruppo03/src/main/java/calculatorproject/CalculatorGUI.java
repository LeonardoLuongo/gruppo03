package calculatorproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author francescomonda
 * @author Leonardo Luongo
 */
public class CalculatorGUI extends Application 
{
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorGUI.class.getResource("Calculator_v2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Calculator_v2.fxml"));
        Parent root = loader.load();

        // Set the controller
        CalculatorControllerView controller = loader.getController();
        controller.setStage(stage);

        stage.setScene(new Scene(root));
        stage.setTitle("Complex Calculator - group03");


        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
