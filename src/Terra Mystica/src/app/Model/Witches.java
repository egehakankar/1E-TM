package app.Model;

import java.util.ArrayList;

public class Witches extends Faction {
    
    String name;
    public Witches(){
        name = "Witches";
    }

    public String getColor()
    {
        return "Green";
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
        /*ArrayList<ArrayList<Integer>> arr = player.getBuildings();

            if (arr.get(0).size() < 3){

                arr.get(0).add(arr.get(0).size());
            }*/
    }

    public void useAfterStrongHold(Player player){
        useSpecialAction(player);
    }

    public String getName(){
        return name;
    }

    public int getPriests(){
        return 0;
    }
    public int getCoins(){
        return 15;
    }
    public int getWorkers(){
        return 3;
    }
    public int[] getCult(){
        int [] cult = new int[4];
        cult[0] = 2;
        cult[1] = 0;
        cult[2] = 0;
        cult[3] = 0;
        return cult;
    }

    public  int[] getPower(){

        int[] power = new int[3];
        power[0] = 5;
        power[1] = 7;
        power[2] = 0;
        return power;
    }

}