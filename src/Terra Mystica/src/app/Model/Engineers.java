package app.Model;

import java.util.ArrayList;

public class Engineers extends Faction {

    String name;

    public Engineers(){
        name = "Engineers";
    }

    public int[] getColor()
    {
        int colorGray[] = { 192, 192, 192 };
        return colorGray;
    }

    public void useSpecialAction( Player player){

    }

    public int getDwellings(){
        return 2;
    }
    public void useAbility( Player player){

    }
    public void useAfterStrongHold( Player player){
        ArrayList<ArrayList<Integer>> pack = player.getBridges();
        int vic = player.getPoints();
        for ( int i = 0; i < pack.size(); i++){
            for ( int j = 0; j < pack.get(i).size(); j++){
                vic = vic + 3;
            }
        }
    }
    public String getName(){
        return name;
    }

    public int getPriests(){
        return 0;
    }
    public int getCoins(){
        return 10;
    }
    public int getWorkers(){
        return 2;
    }
    public int[] getCult(){
        int [] cult = new int[4];
        cult[0] = 0;
        cult[1] = 0;
        cult[2] = 0;
        cult[3] = 0;
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