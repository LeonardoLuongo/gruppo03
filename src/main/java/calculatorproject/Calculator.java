package calculatorproject;

public class Calculator
{
    InputValidator inputValidator = new InputValidator();

    StackManager stackManager = new StackManager();

    VariableManager variableManager = new VariableManager();
    public Calculator() {}

    public void fetchInput(String input)
    {
        InputValidator.CorrectInputFormat correctInput = new InputValidator.CorrectInputFormat(input);
        if(correctInput.toString() == null)
            throw new IllegalArgumentException("Not a valid input");

        if(!this.inputValidator.isValidInput(correctInput))
        {
            throw new IllegalArgumentException("Not a valid input.");
        }

        if(this.inputValidator.isComplexNumber(correctInput))
        {
            stackManager.push(ComplexNumber.fromString(correctInput.toString()));
        }
        else
        {
            switch(this.inputValidator.operationCode(correctInput))
            {
                case 0:
                    this.add();
                    break;

                case 1:
                    this.sub();
                    break;

                case 2:
                    this.mul();
                    break;

                case 3:
                    this.div();
                    break;

                case 4:
                    this.sqrt();
                    break;

                case 5:
                    this.inv();
                    break;

                case 6:
                    this.fromStackIntoVariable(input.substring(1));
                    break;

                case 7:
                    this.fromVariableIntoStack(input.substring(1));
                    break;

                case 8:
                    this.varPlusStack(input.substring(1));
                    break;

                case 9:
                    this.varSubStack(input.substring(1));
                    break;

                case 10:
                    this.stackManager.dup();
                    break;

                case 11:
                    this.stackManager.drop();
                    break;

                case 12:
                    this.stackManager.swap();
                    break;

                case 13:
                    this.stackManager.clear();
                    break;

                case 14:
                    this.stackManager.over();
                    break;

                default:
                    System.err.println("!!! ERRORE : QUI NON DOVREBBE ARRIVARE !!!");
                    break;
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
                cn2.getImaginary() + cn1.getImaginary()
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
        Double b = cn2.getImaginary();
        Double c = cn1.getReal();
        Double d = cn1.getImaginary();
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
        Double b = cn2.getImaginary();
        Double c = cn1.getReal();
        Double d = cn1.getImaginary();
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
        Double b = cn2.getImaginary();
        Double c = cn1.getReal();
        Double d = cn1.getImaginary();
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
        ComplexNumber cn1 = stackManager.pop();

        Double real = cn1.getReal();
        Double imaginary = cn1.getImaginary();

        double magnitude = Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
        double angle = Math.atan2(imaginary, real) / 2.0;
        double rootReal = Math.sqrt(magnitude) * Math.cos(angle);
        double rootImaginary = Math.sqrt(magnitude) * Math.sin(angle);
        stackManager.push(new ComplexNumber(rootReal, rootImaginary));
    }

    public void inv()
    {
        ComplexNumber cn1;

        cn1 = stackManager.pop();

        // (cn2.real + j * cn2.imm) * (cn1.real + j * cn1.imm)
        // R: cn2.real * cn1.real - cn2.imm * cn1.imm
        // I: cn2.real * cn1.imm + cn2.imm * cn1.real
        Double a = cn1.getReal();
        Double b = cn1.getImaginary();

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

        cn1 = variableManager.getVariable(varName).getValue();
        cn2 = stackManager.pop();

        Double a = cn1.getReal();
        Double b = cn1.getImaginary();
        Double c = cn2.getReal();
        Double d = cn2.getImaginary();
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

        cn1 = variableManager.getVariable(varName).getValue();
        cn2 = stackManager.pop();

        Double a = cn1.getReal();
        Double b = cn1.getImaginary();
        Double c = cn2.getReal();
        Double d = cn2.getImaginary();
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

        cn1 = variableManager.getVariable(varName).getValue();

        stackManager.push(cn1);
    }


    @Override
    public String toString() {

        if(stackManager.getSize() < 12)
            return stackManager.toString();

        return "";

    }
}
