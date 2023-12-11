package calculator;

import java.util.HashMap;
import java.util.Map;

public class InputValidator 
{
    Map<String, Integer> operations;
    public InputValidator()
    {
        operations = new HashMap<>();
        instanceOperations();
    }

    private void instanceOperations() 
    {
        operations.put("+",0);
        operations.put("-",1);
        operations.put("*",2);
        operations.put("/",3);
        operations.put("sqrt",4);
        operations.put("inv",5);
        operations.put(">x",6);
        operations.put("<x",7);
        operations.put("+x",8);
        operations.put("-x",9);
        operations.put("dup",10);
        operations.put("drop",11);
        operations.put("swap",12);
        operations.put("clear",13);
        operations.put("over",14);
    }

    public boolean isValidInput(String input)
    {
        if(input != null)
        {
            input = input.replaceAll(" ", "");
            input = input.toLowerCase();
            boolean realPart = input.matches("[+-]{0,1}[0-9]{1,}.{0,1}[0-9]{0,}");

            boolean immPart = input.matches("[+-]{0,1}[0-9]{1,}.{0,1}[0-9]{0,}j");

            boolean complex = input.matches("[+-]{0,1}[0-9]{1,}.{0,1}[0-9]{0,}[+-]{0,1}[0-9]{1,}.{0,1}[0-9]{0,}j");

            boolean opPart = input.matches("sqrt|inv|dup|drop|swap|clear|over|[+-/*]|[<>+-][a-z]");

            boolean result = realPart || immPart || complex || opPart;
            if(!result)
                return false;
            int operationCode = operationCode(input);
            if(isComplexNumber(input) || (operationCode >= 0 && operationCode <= 14))
                return true;
        }
        return false;

    }

    public boolean isNumber(String number)
    {
        try 
        {
            Double.parseDouble(number);
            return true;
        } 
        catch(NumberFormatException ex) 
        {
            return false;
        }
    }
    public boolean isComplexNumber(String number)
    {
        StringBuilder temp = new StringBuilder();
    
        String[] onlynumber = new String[2];
        onlynumber[0] = null;
        onlynumber[1] = null;
        for(int i = 0; i < number.length(); i++)
        {
            if((number.charAt(i) == '+' || number.charAt(i) == '-') && !temp.toString().isEmpty())
            {
                onlynumber[0] = temp.toString();
                temp = new StringBuilder(number.charAt(i) + "");
            }
            else if(number.charAt(i) != 'j')
            {
                temp.append(number.charAt(i));
                if (i+1 == number.length())
                {
                    onlynumber[0] = temp.toString();
                }
            }
            else
            {
                onlynumber[1] = temp.toString();
            }
    
            if(onlynumber[0] == null)
                onlynumber[0] = "0.0";
    
            if(onlynumber[1] == null)
                onlynumber[1] = "0.0";
    
        }

        onlynumber[0] = onlynumber[0].replaceAll(" ", "");
        onlynumber[1] = onlynumber[1].replaceAll(" ", "");

        if (onlynumber.length == 2) 
            return isNumber(onlynumber[0].toString()) && isNumber(onlynumber[1].toString().replaceAll("j", ""));         
        else if (onlynumber.length == 1) 
            return isNumber(onlynumber[0].toString().replaceAll("j", ""));
        else
            return false;
    
    }

    public int operationCode(String operation)
    {
        operation = operation.toLowerCase();
        if(operation.charAt(0) == '+' || operation.charAt(0) == '-' || operation.charAt(0) == '>' || operation.charAt(0) == '<')
        {
            if(operation.length()==2) 
            {
                String s = operation.substring(1);
                
                if(s.matches("[a-z]"))
                    operation = operation.replaceAll("[a-z]", "x");
            }
        }
        if(operations.containsKey(operation))
            return operations.get(operation); 
        return -1;
    }

}