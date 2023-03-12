package paser;

import java.util.HashMap;

public class IfStatement implements Statement {
    Expression Expr;
    Statement s1, s2;

    IfStatement(Expression Expr, Statement s1, Statement s2) {
        this.Expr = Expr;
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
    }

    @Override
    public char[] prettyPrint() {
        return new char[0];
    }
}
