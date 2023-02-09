public  class UPBEAT {
 /**ConfigurationFile**/
    int m=20;
    int n=15;
    int init_plan_min=5;
    int init_plan_sec=0;
    int init_budget=10000;
    int init_center_dep=100;
    int plan_rev_min=30;
    int plan_rev_sec=0;
    int rev_cost=100;
    int max_dep=1000000;
    int interest_pct=5;
  /**-----------------**/
    boolean owned;
    String rows(int m){
        return "Have "+m+" rows in territory";
    }
    String cols(int n){
        return "Have "+n+" rows in territory";
    }
    void budget(){
        System.out.println("Money remain" + money);
    }
    int deposit(int row,int col){
        if(owned){
            return -1;
        }else return 1;
    }
    class ActionCommands extends UPBEAT {
        void done(){
        }
        void relocate(){
        }
        void move(){
        }
        void invest(){
        }
        void collect(){
        }
        void shoot(){
        }
    }
    class ConfigurationFile {

    }
    class City extends UPBEAT{

    }
    class CityCenter extends City{
    }
    class Player extends UPBEAT{
        int row;
        int col;
        String currows(){
            return "City crew in"+row+"row";
        }
        String curcols(){
            return "City crew in"+col+"col";
        }
        String Pos(){
            return "Position is row" + row + "cols" + col;
        }
    }
}
