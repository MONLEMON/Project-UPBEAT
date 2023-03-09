package paser;

import Game.GameAction;
import Game.Player;

import java.util.HashMap;
import java.util.LinkedList;

public class MoveCmd extends Cmd {
    private Direction direction;

    MoveCmd(Direction direction) {
        super(false);
        this.direction = direction;
    }
}
