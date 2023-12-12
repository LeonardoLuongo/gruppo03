/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package calculator.release.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author francescomonda
 */
public class CalculatorGUI extends Application 
{
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorGUI.class.getResource(".\\fxml\\Calculator_v2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Complex Calculator - Io, Mammeta, Mattia e tu & co.");


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
