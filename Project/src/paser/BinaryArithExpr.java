package paser;

import java.util.Map;

class BinaryArithExpr implements Expression {
    private Expression left, right;
    private String op;
    public BinaryArithExpr(Expression left, String op, Expression right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }
    @Override
    public double eval(Map<String, Integer> bindings) throws EvalError {
        double lv;
        double rv;
        if(left instanceof Variable) {
            lv = left.eval(bindings);
        }else {
            lv = left.eval(bindings);
        }
        if(right instanceof Variable) {
            rv = right.eval(bindings);
        }else{
            rv = right.eval(bindings);
        }
        if (op.equals("+")) return lv + rv;
        if (op.equals("-")) return lv - rv;
        if (op.equals("*")) return lv * rv;
        if(op.equals("/")){
            if(rv == 0)
                throw new EvalError("ERROR Not division by 0");
            return lv / rv;
        }
        if (op.equals("%")) {
            if(rv == 0)
                throw new EvalError("ERROR Not Mod by 0");
            return lv % rv;
        }
        if (op.equals("^")) return Math.pow( lv, rv );

        throw new EvalError("unknown op: " + op);
    }
    @Override
    public void prettyPrint(StringBuilder s) {
        s.append("(");
        left.prettyPrint(s);
        s.append(op);
        right.prettyPrint(s);
        s.append(")");
    }

    @Override
    public char[] prettyPrint() {
        return new char[0];
    }
}
