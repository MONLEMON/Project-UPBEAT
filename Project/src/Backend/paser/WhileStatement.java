package Backend.paser;

public class WhileStatement implements Statement {
    Expression Expr;
    Statement s1;

    WhileStatement(Expression Expr, Statement s1) {
        this.Expr = Expr;
        this.s1 = s1;
    }

    @Override
    public void prettyPrint(StringBuilder s) {
    }

    @Override
    public char[] prettyPrint() {
        return new char[0];
    }

}
