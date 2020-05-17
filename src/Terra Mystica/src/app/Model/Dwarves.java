package app.Model;

public class Dwarves extends Faction{

    String name;
    public Dwarves(){
        name = "Dwarves";
    }

    public String getColor()
    {
        return "Gray";
    }

    public String getName(){
        return name;
    }
    public int getDwellings(){
        return 2;
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
        cult[0] = 0;
        cult[1] = 0;
        cult[2] = 0;
        cult[3] = 2;
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