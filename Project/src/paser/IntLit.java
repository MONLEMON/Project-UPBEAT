package paser;

import java.util.Map;

public class IntLit implements Expression {
    private int val;

    public IntLit(int val) {
        this.val = val;
    }

    @Override
    public double eval(
            Map<String, Integer> bindings) {
        return val;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
        s.append(val);
    }

    @Override
    public char[] prettyPrint() {
        return new char[0];
    }
}
