package Game;

import paser.LexicalError;
import paser.ParserPlans;
import paser.Plan;
import paser.TokenizerPlans;

import java.util.ArrayList;
import java.util.HashMap;

class ConfigurationFile {
    static int m=20;
    static int n=15;
    static int init_plan_min=5;
    static int init_plan_sec=0;
    static int init_budget=10000;
    static int init_center_dep=100;
    static int plan_rev_min=30;
    static int plan_rev_sec=0;
    static int rev_cost=100;
    static int max_dep=1000000;
    static int interest_pct=5;
}
interface Count{

}

class Game {
    private int turn = 0;
    private Board[][] Board;
    private int m = ConfigurationFile.m;
    private int n = ConfigurationFile.n;
    private ArrayList<Player> Player = new ArrayList<Player>();
    void MakeBoard(){
        Board = new Board[m][n];
    }
    void CreatePlayer(Player name){
        Player.add(name);
    }
}

class ConstructionPlan{
    Player owner;
    Plan Plan;
    ParserPlans parser;
    TokenizerPlans Token;
    HashMap<String, Integer> identifiers;
    void setPlan(String Plan) throws LexicalError {
        Token = new TokenizerPlans(Plan);
    }
    void Planer(){
        Plan = new Plan();
    }
}

class Board {
    Board[][] Board;
    private int m = ConfigurationFile.m;
    private int n = ConfigurationFile.n;
    int Boardsize(){
        return m*n;
    }
}
class Territory{
    int posX;
    int posY;
    
}
class City {
    private Player Owner;

}
class CityCrew extends City{

}
class CityCenter extends City{

}
