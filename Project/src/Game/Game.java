package Game;

import paser.Direction;
import paser.ParserPlans;
import paser.Plan;
import paser.TokenizerPlans;
import java.util.ArrayList;


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

class Game {
    private int turn = 0;
    private Board[][] Board;
    private int m = ConfigurationFile.m;
    private int n = ConfigurationFile.n;
    void CreateMap(){
        this.Board = new Board[m][n];
    }
}

class ConstructionPlan{
//    t = t + 1  # keeping track of the turn number
//    m = 0  # number of random moves
//      while (deposit) { # still our region
//        if (deposit - 100)
//            then collect (deposit / 4)  # collect 1/4 of available deposit
//  else if (budget - 25) then invest 25
//  else {}
//        if (budget - 100) then {} else done  # too poor to do anything else
//        opponentLoc = opponent
//        if (opponentLoc / 10 - 1)
//            then  # opponent afar
//        if (opponentLoc % 10 - 5) then move downleft
//    else if (opponentLoc % 10 - 4) then move down
//    else if (opponentLoc % 10 - 3) then move downright
//    else if (opponentLoc % 10 - 2) then move right
//    else if (opponentLoc % 10 - 1) then move upright
//    else move up
//  else if (opponentLoc)
//            then  # opponent adjacent to city crew
//        if (opponentLoc % 10 - 5) then {
//            cost = 10 ^ (nearby upleft % 100 + 1)
//            if (budget - cost) then shoot upleft cost else {}
//        }
//    else if (opponentLoc % 10 - 4) then {
//            cost = 10 ^ (nearby downleft % 100 + 1)
//            if (budget - cost) then shoot downleft cost else {}
//        }
//    else if (opponentLoc % 10 - 3) then {
//            cost = 10 ^ (nearby down % 100 + 1)
//            if (budget - cost) then shoot down cost else {}
//        }
//    else if (opponentLoc % 10 - 2) then {
//            cost = 10 ^ (nearby downright % 100 + 1)
//            if (budget - cost) then shoot downright cost else {}
//        }
//    else if (opponentLoc % 10 - 1) then {
//            cost = 10 ^ (nearby upright % 100 + 1)
//            if (budget - cost) then shoot upright cost else {}
//        }
//    else {
//            cost = 10 ^ (nearby up % 100 + 1)
//            if (budget - cost) then shoot up cost else {}
//        }
//  else {  # no visible opponent; move in a random direction
//                dir = random % 6
//            if (dir - 4) then move upleft
//    else if (dir - 3) then move downleft
//    else if (dir - 2) then move down
//    else if (dir - 1) then move downright
//    else if (dir) then move upright
//    else move up
//            m = m + 1
//        }
//    }
}
class Timecount{
    private int Plan_min = ConfigurationFile.init_plan_min;
    private int Plan_sec = ConfigurationFile.init_plan_sec;
    int Rev_min = ConfigurationFile.plan_rev_min;
    int Rev_sec = ConfigurationFile.plan_rev_sec;
    void Plantime(){
        for()
    }
}
class Board {
    Board[][] Board;
    private final int m = ConfigurationFile.m;
    private final int n = ConfigurationFile.n;
    int size(){
        return m*n;
    }
}
interface Territory{
    Area Position();

}
class Area{
    int x,y;
    Area(int x,int y){
        this.x = x;
        this.y = y;
    }
}
interface City extends Territory {
    int currow();
    int curcol();
    int deposit();
    default int max_deposit(){
        return ConfigurationFile.max_dep;
    };
}
class CityCenter implements City{
    private final Area area;
    private Player Owner;
    private final boolean HasOwner = false;
    CityCenter(Area area){
        this.area = area;
    }
    boolean move(Direction dir){
        if(true){
            return true;
        }else return false;
    }
    @Override
    public Area Position() {
        return area;
    }
    @Override
    public int currow() {
        return area.x;
    }
    @Override
    public int curcol() {
        return area.y;
    }

    @Override
    public int deposit() {
        if(HasOwner){
            return -1;
        }else return 1;
    }
}
class CityCrew implements City{
    Area area;
    private Player Owner;
    private final boolean HasOwner = false;
    CityCrew(Area area){
        this.area = area;
    }
    @Override
    public Area Position() {
        return area;
    }
    @Override
    public int currow() {
        return area.x;
    }

    @Override
    public int curcol() {
        return area.y;
    }
    @Override
    public int deposit() {
        if(HasOwner){
            return -1;
        }else return 1;
    }
}
