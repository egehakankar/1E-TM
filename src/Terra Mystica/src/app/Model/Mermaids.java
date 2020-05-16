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

}