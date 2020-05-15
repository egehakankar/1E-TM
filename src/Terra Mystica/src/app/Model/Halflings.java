package app.Model;

public class Halflings extends Faction{

    String name;
    public Halflings(){
        name = "Halflings";
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

}