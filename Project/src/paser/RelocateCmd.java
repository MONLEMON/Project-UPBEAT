package paser;

import Game.Player;

import java.util.HashMap;
import java.util.LinkedList;

public class RelocateCmd extends Cmd {

    RelocateCmd() {
        super(false);
    }

    @Override
    public boolean operate(HashMap<String, Integer> identifiers, LinkedList<GameAction> action, Player player) {
        return false;
    }
}
