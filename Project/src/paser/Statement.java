package paser;

import Game.Player;

import java.util.HashMap;
import java.util.LinkedList;

public interface Statement extends Node {
    boolean operate(HashMap<String, Integer> identifiers, LinkedList<GameAction> action, Player player);
}
