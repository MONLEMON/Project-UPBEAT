package Backend.paser;

public class Cmd implements Statement {
    private boolean TurnEnd;
    Cmd(boolean TurnEnd) {
        this.TurnEnd = TurnEnd;
    }
    @Override
    public void prettyPrint(StringBuilder s) {
        s.append("done");
    }
    @Override
    public char[] prettyPrint() {
        return new char[0];
    }
}
