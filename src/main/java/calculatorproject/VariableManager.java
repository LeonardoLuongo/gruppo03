package calculatorproject;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Mattia Vitali
 *
 */

public class VariableManager {
    private Map<String, Variable> variables;

    public VariableManager() {
        this.variables = new HashMap<>();
        
        for(int i = 0; i < 25; i++) {
            String varName = Character.toString((char)97+i);
            variables.putIfAbsent(varName, new Variable(varName));
        }
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

    public Set<Map.Entry<String, Variable>> getVariablesEntry()
    {
        return variables.entrySet();
    }

}