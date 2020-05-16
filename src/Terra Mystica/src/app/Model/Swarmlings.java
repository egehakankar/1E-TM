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

    public int getPriests(){
        return 0;
    }
    public int getCoins(){
        return 20;
    }
    public int getWorkers(){
        return 8;
    }
    public int[] getCult(){
        int [] cult = new int[4];
        cult[0] = 1;
        cult[1] = 1;
        cult[2] = 1;
        cult[3] = 1;
        return cult;
    }

    public  int[] getPower(){

        int[] power = new int[3];
        power[0] = 3;
        power[1] = 9;
        power[2] = 0;
        return power;
    }
}