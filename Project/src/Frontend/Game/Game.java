package Frontend.Game;

import Frontend.paser.Direction;


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
class Timecount{
    private int Plan_min = ConfigurationFile.init_plan_min;
    private int Plan_sec = ConfigurationFile.init_plan_sec;
    private Player player;
    int Rev_min = ConfigurationFile.plan_rev_min;
    int Rev_sec = ConfigurationFile.plan_rev_sec;
    int Plan_time = (Plan_min*60)+Plan_sec;
    int Rev_time = (Rev_min*60)+Rev_sec;
    Timecount(Player name){
        this.player = name;
    }
//    void Plantime(){
//        if(player.Planrun){
//            for(RevTime()){
//
//            }
//        }else {
//
//        }
//    }
    void RevTime(){
        if(player.Revrun){

        }
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

    boolean deposit();

    default int max_deposit(){
        return ConfigurationFile.max_dep;
    };
}
class CityCenter implements City{
    private final Area area;
    private Player Owner;
    int deposit = 0;
    private final boolean HasOwner = false;
    int max_deposit = ConfigurationFile.max_dep;
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
    public boolean deposit() {
        if(HasOwner){
            return true;
        }else return false;
    }
}
class CityCrew implements City{
    Area area;
    private Player Owner;
    int deposit = 0;
    int interest_pct = ConfigurationFile.interest_pct;
    int max_deposit = ConfigurationFile.max_dep;
    boolean Checkdep(){
        if(deposit > max_deposit()){
           return  false;
        }else return true;
    }
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
    public boolean deposit() {
        if(HasOwner){
            return true;
        }else return false;
    }
}
