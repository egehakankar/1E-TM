package app.Model;

public class Nomads {

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
}