package Backend.paser;

import java.util.Map;

public class Variable implements Expression {
    private String name;
    public Variable(String name) {
        this.name = name;
    }
    public double eval(
            Map<String, Integer> bindings) throws EvalError {
        if (bindings.containsKey(name))
            return bindings.get(name);
        throw new EvalError("undefined variable: " + name);
    }
    public void prettyPrint(
            StringBuilder s) {
        s.append(name);
    }

    @Override
    public char[] prettyPrint() {
        return new char[0];
    }
}
