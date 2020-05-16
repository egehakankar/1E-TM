package app.Model;

import java.util.ArrayList;

public class Witches extends Faction {
    
    String name;
    public Witches(){
        name = "Witches";
    }

    public int getDwellings(){
        return 2;
    }
    public void useAbility(Player player){

        int c = player.getPoints();
        c = c + 5;
        player.updatePoints(c);
    }
    public void useSpecialAction(Player player){
        ArrayList<ArrayList<Integer>> arr = player.getBuildings();

            if (arr.get(0).size() < 3){

                arr.get(0).add(arr.get(0).size());
            }
    }

    public void useAfterStrongHold(Player player){
        useSpecialAction(player);
    }

    public String getName(){
        return name;
    }

}