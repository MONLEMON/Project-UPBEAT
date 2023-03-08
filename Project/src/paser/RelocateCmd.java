package paser;

import Game.GameAction;
import Game.Player;

import java.util.HashMap;
import java.util.LinkedList;

public class RelocateCmd extends Cmd {

    RelocateCmd() {
        super(false);
    }

    @Override
    public boolean operate(HashMap<String, Integer> identifiers) {
        return false;
    }
}
