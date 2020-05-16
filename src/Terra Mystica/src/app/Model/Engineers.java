package app.Model;

import java.util.ArrayList;

public class Engineers extends Faction {

    String name;

    public Engineers(){
        name = "Engineers";
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

}