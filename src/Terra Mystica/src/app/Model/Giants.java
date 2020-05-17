package app.Model;

public class Giants extends Faction{


String name;
    public Giants(){
        name = "Giants";
    }

    public String getColor()
    {
        return "Red";
    }

    public void useSpecialAction( Player player){
        player.updateSpade(player.getSpade() + 2);
    }
    public void useAbility( Player player){

    }
    public void useAfterStrongHold( Player player){

    }
    public String getName(){
        return name;
    }
    public int getDwellings(){
        return 2;
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
        power[0] = 5;
        power[1] = 7;
        power[2] = 0;
        return power;
    }
}