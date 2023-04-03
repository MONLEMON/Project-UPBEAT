package Backend.paser;


import java.util.Map;

public class InfoExpr implements Expression {
    private infocom command;
    private Direction direction;

    @Override
    public char[] prettyPrint() {
        return new char[0];
    }

    @Override
    public double eval(Map<String, Integer> bindings) throws EvalError {
        return 0;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
    }
    InfoExpr(infocom command, Direction direction) {
        this.command = command;
        this.direction = direction;
    }
}