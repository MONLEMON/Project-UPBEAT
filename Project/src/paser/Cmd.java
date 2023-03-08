package paser;

import Game.GameAction;
import Game.Player;

import java.util.HashMap;
import java.util.LinkedList;

public class Cmd implements Statement {
    private boolean TurnEnd;

    Cmd(boolean TurnEnd) {
        this.TurnEnd = TurnEnd;
    }

    @Override
    public boolean operate(HashMap<String, Integer> identifiers) {
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
