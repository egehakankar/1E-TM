package app.Model;

public class Dwarves extends Faction{

    String name;
    public Dwarves(){
        name = "Dwarves";
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
}