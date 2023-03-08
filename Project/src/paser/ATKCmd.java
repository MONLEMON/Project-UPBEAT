package paser;

import Game.GameAction;
import Game.Player;

import java.util.HashMap;
import java.util.LinkedList;

public class ATKCmd extends Cmd {
    private Direction direction;
    private Expression Expr;

    ATKCmd(Direction direction, Expression Expr) {
        super(false);
        this.Expr = Expr;
        this.direction = direction;
    }

    @Override
    public boolean operate(HashMap<String, Integer> identifiers) {
        return false;
    }

}
