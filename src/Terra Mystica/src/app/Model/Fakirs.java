package app.Model;

public class Fakirs extends Faction{

    String name;
    public Fakirs(){
        name = "Fakirs";
    }
    public int getDwellings(){
        return 2;
    }
    public String getName(){
        return name;
    }

    public void useSpecialAction( Player player){

    }
    public void useAbility( Player player){

    }
    public void useAfterStrongHold( Player player){

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
        cult[0] = 1;
        cult[1] = 0;
        cult[2] = 1;
        cult[3] = 0;
        return cult;
    }

    public  int[] getPower(){

        int[] power = new int[3];
        power[0] = 7;
        power[1] = 5;
        power[2] = 0;
        return power;
    }
}