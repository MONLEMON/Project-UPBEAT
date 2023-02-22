package paser;

import paser.EvalError;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

interface Node {
    void prettyPrint(StringBuilder s);
    char[] prettyPrint();}

class Plan implements Node {
    LinkedList<Statement> Statement;
    Plan(){
        this.Statement = new LinkedList<Statement>();
    }
    @Override
    public void prettyPrint(StringBuilder s) {
        s.append(Statement);
    }
    @Override
    public char[] prettyPrint() {
        return new char[0];
    }
}
class ConstructionPlan{
    Player owner;
    Plan Plan;
    ParserPlans parser;
    HashMap<String, Integer> identifiers;
}
interface Statement extends Node{
    boolean operate(HashMap<String, Integer> identifiers, LinkedList<GameAction> action, Player player);
}
interface Expression extends Node {
    double eval(Map<String, Integer> bindings) throws EvalError;
    void prettyPrint(StringBuilder s);
}
class IntLit implements Expression {
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