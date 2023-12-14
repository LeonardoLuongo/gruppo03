package calculatorproject;


import java.util.HashMap;
import java.util.Map;

public class VariableManager {
    private Map<String, Variable> variables;

    public VariableManager() {
        this.variables = new HashMap<>();
    }

    public Variable getVariable(String name) {
        return variables.get(name);
    }

    public int getSize() {
        return variables.size();
    }

    @Override
    public String toString() {
        return "VariablesManager{" +
                "variables=" + variables +
                '}';
    }
}