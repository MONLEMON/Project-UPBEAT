package Game;

import java.util.ArrayList;

public class Player {
    private String name;
    private ConstructionPlan plan;
    private CityCenter CityCenter;
    private CityCrew CityCrew;
    boolean Planrun = false;
    boolean Revrun = false;
    int money = ConfigurationFile.init_budget;
    ArrayList<City> AllOwner = new ArrayList<City>();
    Player (String name){
        this.name = name;
    }
    ArrayList CityOwner(){
        return AllOwner;
    }
    int budget(){
        return money;
    }

}
