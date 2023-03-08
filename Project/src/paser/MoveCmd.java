package paser;

import Game.Player;

import java.util.HashMap;
import java.util.LinkedList;

public class MoveCmd extends Cmd {
    private Direction direction;

    MoveCmd(Direction direction) {
        super(false);
        this.direction = direction;
    }

    @Override
    public boolean operate(HashMap<String, Integer> identifiers, LinkedList<GameAction> action, Player player) {
        return false;
    }
}
