package app.Model;

import java.util.ArrayList;

public class Swarmlings extends Faction{

    String name;
    public Swarmlings(){
        name = "Swarmlings";
    }
    
    public int getDwellings(){
        return 2;
    }
    public void useSpecialAction( Player player){
        ArrayList<ArrayList<Integer>> buildings = player.getBuildings();
        if( buildings.get(0).size() > 0){
            buildings.get(1).add(buildings.get(1).size());
            player.updateBuildings(buildings);
        }

    }
    public void useAbility( Player player){
        player.updateWorker(player.getWorker() + 3);
    }
    public void useAfterStrongHold( Player player){
        useSpecialAction(player);
    }
    public String getName(){
        return name;
    }
}