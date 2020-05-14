package app.Model;

public class Halflings extends Faction{


    public Halflings(){

    }
    public  void useSpecialAction(Player player){

       
    }
    public  void useAbility(Player player){
        player.updatePoints(player.getPoints() + 1);
    }
    public  void useAfterStrongHold(Player player){
        player.updateSpade(player.getSpade() + 3);
    }

}