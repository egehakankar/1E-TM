package app.Model;

public class Halflings extends Faction{

    String name;
    public Halflings(){
        name = "Halflings";
    }

    public int[] getColor()
    {
        int colorBrown[] = { 140, 104, 100 };
        return colorBrown;
    }

    public int getDwellings(){
        return 2;
    }
    public  void useSpecialAction(Player player){

       
    }
    public  void useAbility(Player player){
        player.updatePoints(player.getPoints() + 1);
    }
    public  void useAfterStrongHold(Player player){
        player.updateSpade(player.getSpade() + 3);
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
        cult[0] = 1;
        cult[1] = 0;
        cult[2] = 0;
        cult[3] = 1;
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