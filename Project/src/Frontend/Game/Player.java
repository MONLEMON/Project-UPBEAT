package Frontend.Game;

import java.util.ArrayList;


public class Player {
    private String name;
    private ConstructionPlan plan;
    private CityCenter CityCenter;
    private CityCrew CityCrew;
    Area positoin;
    int temp_dep;
    boolean Planrun = false;
    boolean Revrun = false;
    int money = ConfigurationFile.init_budget;
    ArrayList<City> AllOwner = new ArrayList<City>();
    Player (String name){
        this.name = name;
    }
    void deposit(CityCrew CityCrew,int dep){
       if(CityCrew.deposit()){
           if(money>=dep) {
               temp_dep = CityCrew.deposit+dep;
               if(temp_dep<CityCrew.max_deposit()) {
                   money -= dep;
                   CityCrew.deposit = temp_dep;
               }else{
                   System.out.println("deposit max");
               }
           }else{
               System.out.println("No money");
           }
       }else {
           System.out.println("No money");
       }
    }
    ArrayList<City> CityOwner(){
        return AllOwner;
    }
    int budget(){
        return money;
    }
    Area Position(){
        return positoin;
    }


}
