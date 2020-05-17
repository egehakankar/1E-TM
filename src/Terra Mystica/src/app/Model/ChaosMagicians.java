package app.Model;

public class ChaosMagicians extends Faction{

    String name;
    public ChaosMagicians(){
        name = "ChaosMagicians";
    }

    public int[] getColor()
    {
        int colorRed[] = { 255, 106, 107 };
        return colorRed;
    }
    
    public int getDwellings(){
        return 1;
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
        return 4;
    }
    public int[] getCult(){
        int [] cult = new int[4];
        cult[0] = 0;
        cult[1] = 0;
        cult[2] = 2;
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