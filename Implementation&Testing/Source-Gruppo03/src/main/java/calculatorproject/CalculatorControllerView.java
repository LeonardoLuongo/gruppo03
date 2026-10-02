/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package calculatorproject;

import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author francescomonda
 * @author Leonardo Luongo
 */
public class CalculatorControllerView implements Initializable {

    @FXML
    private TextArea textField;

    private Button oldColoredButton = null;

    @FXML
    private Button deleteAll;
    @FXML
    private VBox vBoxStack;
    @FXML
    private VBox vBoxVariables;
    @FXML
    private AnchorPane mainPain;

    @FXML
    private ScrollPane scrollPaneVar;
    private Stage stage;
    private Button[] variablesButton;

    private Button[] stackButtons;

    Alert alert = new Alert(Alert.AlertType.WARNING);

    private Calculator calculator;
    @FXML
    private Button stackClick;
    @FXML
    private AnchorPane anchorVariables;
    @FXML
    private AnchorPane anchorStack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calculator = new Calculator();

        initStack();
        stackUpdate();
        initVariables();
        initOperationButtons();
    }

    @FXML
    public void initOperationButtons()
    {

    }

    @FXML
    private void disableAllButtons() {
        disableButtonsInContainer(mainPain);
    }

    private void disableButtonsInContainer(Node container) {
        if (container instanceof Pane) {
            for (Node node : ((Pane) container).getChildren()) {
                disableButtonsInContainer(node);
            }
        } else if (container instanceof Button) {
            ((Button) container).setDisable(true);
        }
    }
    private void initVariables() {
        int i = 0;
        variablesButton = new Button[vBoxVariables.getChildren().size()];
        for (var child : vBoxVariables.getChildren()) {
            if (child instanceof Button) {
                variablesButton[i] = ((Button) child);
                variablesButton[i].setText((char)(i + 'A') + "");
                i++;
            }
        }
    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    private void initStack()
    {
        int i = 0;
        stackButtons = new Button[vBoxStack.getChildren().size()];
        for (var child: vBoxStack.getChildren())
        {
            if(child instanceof Button)
            {
                stackButtons[i] = ((Button) child);
                i++;
            }
        }
    }
    
    
    private void stackUpdate()
    {
        ListIterator<ComplexNumber> it =  calculator.getStackIterator();
        if(it == null) {
            int i = 0;
            while(i < 12)
            {
                stackButtons[i].setText("");
                i++;
            }
        }
        else
        {
            ComplexNumber c;
            int i = 0;
            while(it.hasPrevious() && i < 12)
            {
                c = it.previous();
                if(c != null) {
                    stackButtons[i].setText(c.toString());
                    updateFontSize(stackButtons[i], c.toString(), 0);
                }
                else
                    stackButtons[i].setText("");
                i++;
            }
            while(i < 12)
            {
                stackButtons[i].setText("");
                i++;
            }
        }
    }

    public void variablesUpdate()
    {
        int i = 0;
        ComplexNumber temp;
        for (var variable : calculator.getVariablesEntry())
        {
            temp = variable.getValue().getValue();
            if(temp != null) {
                variablesButton[i].setText((char) (i + 'A') + " = " + temp.toString());
                updateFontSize(variablesButton[i], temp.toString(), 1);
            }
            else
                variablesButton[i].setText((char)(i + 'A') + "");
            i++;
        }
    }

    @FXML
    private void fetch(ActionEvent event)
    {
        if(!(event.getSource() instanceof Button))
            return;

        // Get the source of the event (in this case, the button)
        Button sourceButton = (Button) event.getSource();

        // Get the text of the button
        String buttonText = sourceButton.getText().replaceAll(" ", "").toLowerCase();

        Pattern p = Pattern.compile("virtualbutton*");
        Matcher m = p.matcher(buttonText);
        boolean isVirtualButton = m.find();
        if(isVirtualButton)
        {
            buttonText = buttonText.replaceAll("virtualbutton", "");
        }


        try
        {
            if(buttonText.matches("enter"))
            {
                calculator.fetchInput(textField.getText());
                textField.clear();
            }
            else if(buttonText.matches("/|sqrt|dup|clear|drop|over|swap") || buttonText.equals("*") || buttonText.equals("+-"))
            {
                if(buttonText.equals("+-"))
                    buttonText = "inv";

                calculator.fetchInput(buttonText);
                textField.clear();
            }
            else if(buttonText.matches("[+-]"))
            {
                if(textField.getText().isEmpty() ||
                        textField.getText().replaceAll(" ", "")
                                .matches("[+-]?[0-9]{0,}.?[0-9]{0,}")
                )
                    if(!isVirtualButton)
                        textField.setText(textField.getText() + sourceButton.getText());
            }
            else if(buttonText.matches("[><+-]x"))
            {
                if(!textField.getText().isEmpty())
                    return;

                if(!isVirtualButton)
                    textField.setText(textField.getText() + sourceButton.getText().charAt(0));
            }

        }
        catch (RuntimeException e)
        {
            showAlert("Exception Handled: " + e.getLocalizedMessage());
            e.printStackTrace();
            textField.clear();
        }
        finally {
            stackUpdate();
            variablesUpdate();
        }
    }

    private void showAlert(String message) 
    {
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void getX(ActionEvent event) 
    {
        String x = ((Button)event.getSource()).getText()
                .toLowerCase()
                .charAt(0) + "";
        textField.setText(textField.getText() + x);
    }

    @FXML
    private void numb(ActionEvent event) 
    {
        String n = ((Button)event.getSource()).getText();
        textField.setText(textField.getText() + n);
    }


    @FXML
    private void getDelete(ActionEvent event) 
    {
        textField.setText("");
    }


    @FXML
    private void canc(ActionEvent event) 
    {
        if (!textField.getText().isEmpty()) 
        {
            String newText = textField.getText().replaceAll(" ", "");
            newText = newText.substring(0, newText.length() - 1);
            newText = newText.replaceAll("'+'*", " + ");
            newText = newText.replaceAll("'-'*", " - ");
            textField.setText(newText);
        }
    }

    @FXML
    private void showVariables(ActionEvent event) 
    {
        if(anchorVariables.isVisible()) {
            anchorVariables.setVisible(false);
        }
        else
            anchorVariables.setVisible(true);
    }
    @FXML
    private void showStack(ActionEvent event) 
    {
        if(anchorStack.isVisible())
            anchorStack.setVisible(false);
        else
            anchorStack.setVisible(true);  
    }

    public void keyConverter(KeyEvent keyEvent)
    {
        String keyPressed = keyEvent.getText().toLowerCase();
        Button virtualButton = new Button("virtualButton");
        ActionEvent event;


        if(keyEvent.getCode() == KeyCode.ENTER)
        {
            virtualButton.setText(virtualButton.getText() + "enter");
            String s = textField.getText().replace("\n", "");
            textField.setText(s);
        }
        else
        {
            virtualButton.setText(virtualButton.getText() + keyEvent.getText());
        }
        event = new ActionEvent(virtualButton, null);
        this.fetch(event);

        if(oldColoredButton != null)
        {
            oldColoredButton.setStyle(oldColoredButton.getStyle().replace("-fx-text-fill: yellow;", ""));
            oldColoredButton.setStyle(oldColoredButton.getStyle().replace("-fx-font-weight: bold;", ""));
            scrollPaneVar.setVvalue(0.0);
        }
        if(keyPressed.matches("[a-z]") && textField.getText().matches("[<>+-]"))
        {
            double v = (keyPressed.charAt(0) - (double)'a')/26 + 0.1;
            oldColoredButton = variablesButton[keyPressed.charAt(0) - 'a'];
            oldColoredButton.setStyle(oldColoredButton.getStyle() + ("-fx-text-fill: yellow;"));
            oldColoredButton.setStyle(oldColoredButton.getStyle() + ("-fx-font-weight: bold;"));
            scrollPaneVar.setVvalue(v);
        }
    }

    private void updateFontSize(Button bt, String number, int isVar) {
        ComplexNumber c = ComplexNumber.fromString(number);
        // Calculate the new font size based on the number
        double newSize = Math.max(10.8 - isVar, 20 - number.length());

        // Set the new font size
        bt.setStyle(bt.getStyle() + "-fx-font-size: " + newSize + ";");
    }
}
