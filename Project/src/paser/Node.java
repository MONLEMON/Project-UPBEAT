package paser;

import paser.EvalError;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

interface Node {
    void prettyPrint(StringBuilder s);
    char[] prettyPrint();}
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
class Plan implements Node {
    LinkedList<Statement> Statement;
    Plan(){
        this.Statement = new LinkedList<Statement>();
    }
    void append(Statement st){
        Statement.add(st);
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
class Direction{

}
class Cmd implements Statement{
    private boolean TurnEnd ;
    Cmd(boolean TurnEnd){
        this.TurnEnd = TurnEnd;
    }
    @Override
    public boolean operate(HashMap<String, Integer> identifiers, LinkedList<GameAction> action, Player player) {
        return TurnEnd;
    }
    @Override
    public void prettyPrint(StringBuilder s) {
    }
    @Override
    public char[] prettyPrint() {
        return new char[0];
    }
}
class MoveCmd extends Cmd{
    private Statement direction;
    MoveCmd(Statement direction){
        super(false);
        this.direction = direction;
    }
    @Override
    public boolean operate(HashMap<String, Integer> identifiers, LinkedList<GameAction> action, Player player) {
        return false;
    }
}
class GameAction {

}
class IfStatement implements Statement{
    Expression Expr;
    Statement s1,s2;
    IfStatement(Expression Expr,Statement s1,Statement s2){
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

    @Override
    public boolean operate(HashMap<String, Integer> identifiers, LinkedList<GameAction> action, Player player) {
        return false;
    }
}
class WhileStatement implements Statement{
    Expression Expr;
    Statement s1;
    WhileStatement(Expression Expr,Statement s1){
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
    public boolean operate(HashMap<String, Integer> identifiers, LinkedList<GameAction> action, Player player) {
        return false;
    }
}

