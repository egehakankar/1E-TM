package app.Model;

public class Nomads extends Faction{

    String name;
    public Nomads(){
        name = "Nomads";
    }
    public int getDwellings(){
        return 3;
    }
    public String getName(){
        return name;
    }

    public void useSpecialAction( Player player){

    }
    public void useAbility( Player player){
        getDwellings();
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
        return 2;
    }
    public int[] getCult(){
        int [] cult = new int[4];
        cult[0] = 0;
        cult[1] = 0;
        cult[2] = 1;
        cult[3] = 1;
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