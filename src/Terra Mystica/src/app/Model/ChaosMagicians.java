package app.Model;

public class ChaosMagicians extends Faction{

    String name;
    public ChaosMagicians(){
        name = "ChaosMagicians";
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
    
}