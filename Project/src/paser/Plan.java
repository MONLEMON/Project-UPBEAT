package paser;

import java.util.LinkedList;

public class Plan implements Node {
    LinkedList<Statement> Statement;

    public Plan(LinkedList<Statement> Statement) {
        this.Statement =Statement;
    }

    void append(Statement st) {
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
