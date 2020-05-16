package app.Model;

public class Mermaids extends Faction{

    String name;
    public Mermaids(){
        name = "Mermaids";
    }
    
    public int getDwellings(){
        return 2;
    }
    public void useSpecialAction( Player player){

    }
    public void useAbility( Player player){

    }
    public void useAfterStrongHold( Player player){
        player.updateShip(player.getShip() + 1);
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
        cult[0] = 0;
        cult[1] = 2;
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