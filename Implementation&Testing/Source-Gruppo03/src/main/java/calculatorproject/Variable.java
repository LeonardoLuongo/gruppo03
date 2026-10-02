package calculatorproject;

/**
 * @author Mattia Vitali
 *
 */

public class Variable {
    private String name;
    private ComplexNumber value;

    public Variable(String name) {
        this.name = name;
        this.value = null;
    }

    public String getName() {
        return name;
    }

    public ComplexNumber getValue() {
        return value;
    }

    public void setValue(ComplexNumber newValue) {
        this.value = newValue;
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Variable variable = (Variable) other;
        return name.equalsIgnoreCase(variable.name);
    }

    @Override
    public String toString() {
        return name + ": "+ value;
    }
}