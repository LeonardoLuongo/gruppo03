package calculatorproject;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *  @author Leonardo Luongo
 *  @author francescomonda
 *
 */

public class InputValidator 
{
    static public class CorrectInputFormat
    {

        private String input;

        public CorrectInputFormat(String input){ this.tidyUpTheInput(input); }

        @Override
        public String toString() {

            if(input == null || input.isEmpty())
                throw new IllegalArgumentException("Unexpected input format");

            this.input = this.input.replaceAll(" ", "").toLowerCase(Locale.US);

            return input;
        }

        private void tidyUpTheInput(String input)
        {
            if(input.contains(" ") && !input.contains("+") && !input.contains("-"))
            {
                input = input.toLowerCase().trim().replaceAll(" {1,}", " ");

                if(input.split(" ").length > 0)
                {
                    this.input = null;
                    return;
                }
            }


            Pattern p = Pattern.compile("[0-9]{1,} [^+-]");
            Matcher m = p.matcher(input);
            if (m.find())
            {
                this.input = null;
                return;
            }

            this.input = input;
        }

        public boolean isCorrect()
        {
            return this.input != null;
        }
    }
    
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

    public boolean isValidInput(CorrectInputFormat correctInput)
    {
        String input = correctInput.toString();

        if(countOccurrences(input, "+") + countOccurrences(input, "-") > 2)
            return false;

        String[] plusSplit = input.split("[+]");
        LinkedList<String> listPlusSplit = new LinkedList<>();

        String[] subSplit = input.split("[-]");
        LinkedList<String> listSubSplit = new LinkedList<>();

        for(int i = 0; i < plusSplit.length; i++)
        {
            if(plusSplit[i].isEmpty())
                listPlusSplit.add(plusSplit[i]);
        }

        for(int i = 0; i < subSplit.length; i++)
        {
            if(subSplit[i].isEmpty())
                listSubSplit.add(subSplit[i]);
        }

        if(listPlusSplit.size() + listSubSplit.size() > 4)
            return false;

        if(listPlusSplit.size() > 1 && listPlusSplit.getLast().charAt(listPlusSplit.getLast().length() - 1) != 'j')
            return false;

        if(listSubSplit.size() > 1 && listSubSplit.getLast().charAt(listSubSplit.getLast().length() - 1) != 'j')
            return false;

        boolean realPart = input.matches("[+-]{0,1}[0-9]{1,}.{0,1}[0-9]{0,}");

        boolean immPart = input.matches("[+-]{0,1}[0-9]{1,}.{0,1}[0-9]{0,}j");

        boolean complex = input.matches("[+-]{0,1}[0-9]{1,}.{0,1}[0-9]{0,}[+-]{0,1}[0-9]{1,}.{0,1}[0-9]{0,}j");

        boolean opPart = input.matches("sqrt|inv|dup|drop|swap|clear|over|[+-/*]|[<>+-][a-z]");

        boolean result = realPart || immPart || complex || opPart;

        return result;
    }

    private boolean isNumber(String number)
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
    
    public boolean isComplexNumber(CorrectInputFormat correctInput)
    {
        String number = correctInput.toString();

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

        return isNumber(onlynumber[0]) && isNumber(onlynumber[1].replaceAll("j", ""));
    }

    public int operationCode(CorrectInputFormat correctInput)
    {
        String operation = correctInput.toString().toLowerCase();

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

    private static int countOccurrences(String source, String target) {
        int occurrences = 0;
        int index = source.indexOf(target);

        while (index != -1) {
            occurrences++;
            index = source.indexOf(target, index + 1);
        }

        return occurrences;
    }


}