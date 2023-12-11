import java.util.HashMap;
import java.util.Map;

public class VariablesManager {
    private Map<String, Variable> variables;

    public VariablesManager() {
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