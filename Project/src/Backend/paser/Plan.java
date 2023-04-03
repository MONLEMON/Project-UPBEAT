package Backend.paser;

import java.util.ArrayList;

public class Plan implements Node {
    ArrayList<Statement> Statement;

    public Plan(ArrayList<Statement> Statement) {
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
