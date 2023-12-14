/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package calculatorproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import calculatorproject.Calculator;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author francescomonda
 */
public class CalculatorControllerView implements Initializable 
{

    @FXML
    private TextArea textField;
    
    private String current="";
    @FXML
    private Button deleteAll;
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
    
    private Button[] variables = {a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z};
    
    private Button[] stack = {stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9, stack10, stack11, stack12};
    
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
    public void initialize(URL url, ResourceBundle rb) 
    {
        calculator = new Calculator();
        
    } 
    
    @FXML
    private void start(ActionEvent event)
    {
        textField.clear();
        current = textField.getText();
        try 
        {
            calculator.fetchInput(current);
            
        }
        catch (RuntimeException e)
        {
            showAlert("Exception Handled: STACK PIENO");
            e.printStackTrace();
        }
        stack();
        textField.setText(calculator.toString());
    }
    
    private void stack()
    {
        for(int i=1; i<=stack.length; i++)
        {
            if(stack[i] != null)
            {
                stack[i].setText("");
            }
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
    private void opVariables(ActionEvent event) 
    {
        String op = ((Button)event.getSource()).getText();
        String newOp = op.substring(0, op.length() - 1);
        textField.setText(textField.getText() + newOp);
        
    }

    @FXML
    private void getX(ActionEvent event) 
    {
        String x = ((Button)event.getSource()).getText().toLowerCase();
        textField.setText(textField.getText() + x);
    }


    @FXML
    private void getOperation(ActionEvent event) 
    {
        current = textField.getText(); 
        String operation = ((Button)event.getSource()).getText().toLowerCase();
        if(operation.equals(" + ") || operation.equals(" - "))
        {
            if((current != ""))
                textField.setText(textField.getText() + operation);
            else
                fetch(operation);
        }
        else
            fetch(operation);
    }
    
    private void fetch(String operation)
    {
        try 
            {
                operation.replaceAll(" ", "");
                calculator.fetchInput(operation);

            }
            catch (RuntimeException e)
            {
                showAlert("Exception Handled: STACK PIENO!!!!");
                e.printStackTrace();
            }
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
        
        variables[0].setText(variables[0].getId().toUpperCase());
        /*a.setText(a.getId().toUpperCase());
        b.setText(b.getId().toUpperCase());
        c.setText(c.getId().toUpperCase());
        d.setText(d.getId().toUpperCase());
        e.setText(e.getId().toUpperCase());
        f.setText(f.getId().toUpperCase());
        g.setText(g.getId().toUpperCase());
        h.setText(h.getId().toUpperCase());
        i.setText(i.getId().toUpperCase());
        j.setText(j.getId().toUpperCase());
        k.setText(k.getId().toUpperCase());
        l.setText(l.getId().toUpperCase());
        m.setText(m.getId().toUpperCase());
        n.setText(n.getId().toUpperCase());
        o.setText(o.getId().toUpperCase());
        p.setText(p.getId().toUpperCase());
        q.setText(q.getId().toUpperCase());
        r.setText(r.getId().toUpperCase());
        s.setText(s.getId().toUpperCase());
        t.setText(t.getId().toUpperCase());
        u.setText(u.getId().toUpperCase());
        v.setText(v.getId().toUpperCase());
        w.setText(w.getId().toUpperCase());
        x.setText(x.getId().toUpperCase());
        y.setText(y.getId().toUpperCase());
        z.setText(z.getId().toUpperCase());*/
        
        
    }


    @FXML
    private void canc(ActionEvent event) 
    {
        if (!textField.getText().isEmpty()) 
        {
            String newText = textField.getText().substring(0, textField.getText().length() - 1);
            textField.setText(newText);
        }
    }

    @FXML
    private void showVariables(ActionEvent event) 
    {
        if(anchorVariables.isVisible())
            anchorVariables.setVisible(false);
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
    
    private void cl()
    {
        
        stack1.setText("");
        stack2.setText("");
        stack3.setText("");
        stack4.setText("");
        stack5.setText("");
        stack6.setText("");
        stack7.setText("");
        stack8.setText("");
        stack9.setText("");
        stack10.setText("");
        stack11.setText("");
        stack12.setText("");
    }
    

    
}
