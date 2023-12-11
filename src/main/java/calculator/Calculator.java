public class Calculator
{
    InputValidator inputValidator = new InputValidator();

    Calculator()
    {

    }

    public void fetchInput(String input)
    {
        if(!this.inputValidator.isValidInput(input))
        {
            throw new IllegalArgumentException("Not a valid input.");
        }

        if(this.inputValidator.isNumber(input))
        {
            stackManager.push(ComplexNumber.fromString(input));
        }
        else
        {
            switch (this.inputValidator.operationCode(input))
            {
                case ADD:
                {

                }
                // ...
                default:
                {
                    System.out.println("!!!!! ERRORE: Non dovrebbe mai arrivare qui. !!!!!");
                }
            }
        }
    }


    // 9   cn1
    // 5   cn2
    //
    // -  => cn2 - cn1
    public void add()
    {
        ComplexNumber cn1;
        ComplexNumber cn2;

        cn1 = stackManager.pop();

        try {
            cn2 = stackManager.pop();
        }
        catch(RuntimeException e)
        {
            stackManager.push(cn1);
            throw e;
        }

        ComplexNumber cn3 = new ComplexNumber(
                cn2.getReal() + cn1.getReal(),
                cn2.getImmaginary() + cn1.getImmaginary()
        );

        stackManager.push(cn3);
    }

    public void sub()
    {
        ComplexNumber cn1;
        ComplexNumber cn2;

        cn1 = stackManager.pop();

        try {
            cn2 = stackManager.pop();
        }
        catch(RuntimeException e)
        {
            stackManager.push(cn1);
            throw e;
        }

        Double a = cn2.getReal();
        Double b = cn2.getImmaginary();
        Double c = cn1.getReal();
        Double d = cn1.getImmaginary();
        ComplexNumber cn3 = new ComplexNumber(
                a - b, c - d
        );

        stackManager.push(cn3);
    }

    public void mul()
    {
        ComplexNumber cn1;
        ComplexNumber cn2;

        cn1 = stackManager.pop();

        try {
            cn2 = stackManager.pop();
        }
        catch(RuntimeException e)
        {
            stackManager.push(cn1);
            throw e;
        }

        // (cn2.real + j * cn2.imm) * (cn1.real + j * cn1.imm)
        // R: cn2.real * cn1.real - cn2.imm * cn1.imm
        // I: cn2.real * cn1.imm + cn2.imm * cn1.real
        Double a = cn2.getReal();
        Double b = cn2.getImmaginary();
        Double c = cn1.getReal();
        Double d = cn1.getImmaginary();
        Double realPart = (a * c - b * d);
        Double immPart = (a * d + b * c);
        ComplexNumber cn3 = new ComplexNumber(
                realPart,
                immPart
        );

        stackManager.push(cn3);
    }

    public void div()
    {
        ComplexNumber cn1;
        ComplexNumber cn2;

        cn1 = stackManager.pop();

        try {
            cn2 = stackManager.pop();
        }
        catch(RuntimeException e)
        {
            stackManager.push(cn1);
            throw e;
        }

        // (cn2.real + j * cn2.imm) * (cn1.real + j * cn1.imm)
        // R: cn2.real * cn1.real - cn2.imm * cn1.imm
        // I: cn2.real * cn1.imm + cn2.imm * cn1.real
        Double a = cn2.getReal();
        Double b = cn2.getImmaginary();
        Double c = cn1.getReal();
        Double d = cn1.getImmaginary();
        Double realPart = (a * c + b * d) / (c * c + d * d);
        Double immPart = (b * c - a * d) / (c * c + d * d);

        ComplexNumber cn3 = new ComplexNumber(
                realPart,
                immPart
        );

        stackManager.push(cn3);
    }

    public void sqrt()
    {
        ComplexNumber cn1;

        cn1 = stackManager.pop();

        // (cn2.real + j * cn2.imm) * (cn1.real + j * cn1.imm)
        // R: cn2.real * cn1.real - cn2.imm * cn1.imm
        // I: cn2.real * cn1.imm + cn2.imm * cn1.real
        Double a = cn1.getReal();
        Double b = cn1.getImmaginary();
        Double z = Math.sqrt(a*a + b*b);
        Double realPart = Math.sqrt( (z + a) / 2 );
        Double immPart = 0.0d;
        if(b != 0.0d)
            immPart = b/Math.abs(b) * Math.sqrt( (z - a) / 2 );

        ComplexNumber cn3 = new ComplexNumber(
                realPart,
                immPart
        );

        stackManager.push(cn3);
    }

    public void inv()
    {
        ComplexNumber cn1;

        cn1 = stackManager.pop();

        // (cn2.real + j * cn2.imm) * (cn1.real + j * cn1.imm)
        // R: cn2.real * cn1.real - cn2.imm * cn1.imm
        // I: cn2.real * cn1.imm + cn2.imm * cn1.real
        Double a = cn1.getReal();
        Double b = cn1.getImmaginary();

        ComplexNumber cn3 = new ComplexNumber(
                (-1)*a,
                (-1)*b
        );

        stackManager.push(cn3);
    }

    public void varPlusStack(String varName)
    {
        ComplexNumber cn1;
        ComplexNumber cn2;

        cn1 = variablesManager.getVariable(varName);
        cn2 = stackManager.pop();

        Double a = cn1.getReal();
        Double b = cn1.getImmaginary();
        Double c = cn2.getReal();
        Double d = cn2.getImmaginary();
        ComplexNumber cn3 = new ComplexNumber(
                a + c,
                b + d
        );

        variableManager.getVariable(varName).setValue(cn3);
    }

    public void varSubStack(String varName)
    {
        ComplexNumber cn1;
        ComplexNumber cn2;

        cn1 = variablesManager.getVariable(varName);
        cn2 = stackManager.pop();

        Double a = cn1.getReal();
        Double b = cn1.getImmaginary();
        Double c = cn2.getReal();
        Double d = cn2.getImmaginary();
        ComplexNumber cn3 = new ComplexNumber(
                a - c,
                b - d
        );

        variableManager.getVariable(varName).setValue(cn3);
    }

    public void fromStackIntoVariable(String varName)
    {
        ComplexNumber cn1;

        cn1 = stackManager.pop();

        variableManager.getVariable(varName).setValue(cn1);
    }

    public void fromVariableIntoStack(String varName)
    {
        ComplexNumber cn1;

        cn1 = variablesManager.getVariable(varName);

        stackManager.push(cn1);
    }

}
