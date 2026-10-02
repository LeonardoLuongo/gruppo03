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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
    @FXML
    private Button a;
    @FXML
    private Button b;
    @FXML
    private Button c;
    @FXML
    private Button d;
    @FXML
    private Button e;
    @FXML
    private Button f;
    @FXML
    private Button g;
    @FXML
    private Button h;
    @FXML
    private Button i;
    @FXML
    private Button j;
    @FXML
    private Button k;
    @FXML
    private Button l;
    @FXML
    private Button m;
    @FXML
    private Button n;
    @FXML
    private Button o;
    @FXML
    private Button p;
    @FXML
    private Button q;
    @FXML
    private Button r;
    @FXML
    private Button s;
    @FXML
    private Button t;
    @FXML
    private Button u;
    @FXML
    private Button v;
    @FXML
    private Button w;
    @FXML
    private Button x;
    @FXML
    private Button y;
    @FXML
    private Button z;
    @FXML
    private Button stack12;
    @FXML
    private Button stack11;
    @FXML
    private Button stack10;
    @FXML
    private Button stack9;
    @FXML
    private Button stack8;
    @FXML
    private Button stack7;
    @FXML
    private Button stack6;
    @FXML
    private Button stack5;
    @FXML
    private Button stack4;
    @FXML
    private Button stack3;
    @FXML
    private Button stack2;
    @FXML
    private Button stack1;

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

    public void initOperationButtons()
    {

    }

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
        ListIterator<ComplexNumber> it = calculator.getStackIterator();
    
    if (it == null) {
        clearStackButtons();
    } else {
        ComplexNumber c;
        int i = 0;
        while (it.hasPrevious() && i < 12) {
            c = it.previous();
            updateButtonWithTextS(stackButtons[i], (c != null) ? c.toString() : "");
            i++;
        }
        
        while (i < 12) {
            clearButton(stackButtons[i]);
            i++;
        }
    }
    }
    private void updateButtonWithTextS(Button button, String text) {
    Text tempText = new Text(text);
    double maxWidth = button.getWidth() - 10; // Adjust margin as needed
    double fontSize = 12; // Default font size

    while (tempText.getBoundsInLocal().getWidth() > maxWidth && fontSize > 1) {
        fontSize--;
        tempText.setFont(new Font(fontSize));
    }

    button.setText(text);
    button.setFont(new Font(fontSize));
    }
    
    private void clearButton(Button button) 
    {
    button.setText("");
    // You may want to reset the font size to the default here if needed
    }

    private void clearStackButtons() {
    for (int i = 0; i < 12; i++) {
        clearButton(stackButtons[i]);
    }
    }

    public void variablesUpdate()
    {
        int i = 0;
    ComplexNumber temp;

    for (var variable : calculator.getVariablesEntry()) {
        temp = variable.getValue().getValue();
        updateButtonWithTextV(variablesButton[i], (char) (i + 'A') + " = " + ((temp != null) ? temp.toString() : ""));
        i++;
        }
    }
    private void updateButtonWithTextV(Button button, String text) {
    Text tempText = new Text(text);
    double maxWidth = button.getWidth() - 10; // Adjust margin as needed
    double fontSize = 12; // Default font size

    while (tempText.getBoundsInLocal().getWidth() > maxWidth && fontSize > 1) {
        fontSize--;
        tempText.setFont(new Font(fontSize));
    }

    button.setText(text);
    button.setFont(new Font(fontSize));
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

    @FXML
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
}