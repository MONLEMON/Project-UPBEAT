package paser;

import java.util.LinkedList;

public class Plan implements Node {
    LinkedList<Statement> Statement;

    public Plan() {
        this.Statement = new LinkedList<Statement>();
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
