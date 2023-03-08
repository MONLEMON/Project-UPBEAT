package paser;

import Game.GameAction;
import Game.Player;

import java.util.HashMap;
import java.util.LinkedList;

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

    @Override
    public boolean operate(HashMap<String, Integer> identifiers) {
        return false;
    }
}
