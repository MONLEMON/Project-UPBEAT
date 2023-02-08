public  class UPBEAT {
    boolean owned;
    int rows;
    int cols;
    int money;
    void Pos(){
        System.out.println("Position is row" + rows + "cols" + cols);
    }
    void budget(){
        System.out.println("Money remain" + money);
    }
    int deposit(int row,int col){
        if(owned){
            return -1;
        }else return 1;
    }
    class ActionCommands {
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
    class City{
    }
    class CityCenter extends City{
    }
    class Player{
    }
}
