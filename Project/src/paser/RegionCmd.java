package paser;

import Game.Player;

import java.util.HashMap;
import java.util.LinkedList;

public class RegionCmd extends Cmd {
    private Expression Expr;
    private Regions command;

    RegionCmd(Regions command, Expression Expr) {
        super(false);
        this.Expr = Expr;
        this.command = command;
    }

    @Override
    public boolean operate(HashMap<String, Integer> identifiers, LinkedList<GameAction> action, Player player) {
        return false;
    }
}
