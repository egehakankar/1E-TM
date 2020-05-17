package app.Model;

public class Cultists extends Faction{
    
    String name;
    public  Cultists(){
        name = "Cultists";
    }

    public String getColor()
    {
        return "Brown";
    }

    public int getDwellings(){
        return 2;
    }
    public void useSpecialAction( Player player){

    }

    public void useAbility( Player player){
        int c = (int) (Math.random() + 4);
        int [] arr = player.getCultLevel();
        if ( arr[c] < 10){
            arr[c] = arr[c] + 1;
        }
        else{
            for ( int i = 0; i < 4; i++){
                if( arr[i] < 10){
                    arr[i] = arr[i] + 1;
                    break;
                }
            }
        }
    }
    public void useAfterStrongHold( Player player){
        player.updatePoints(player.getPoints() + 7);
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
        cult[0] = 0;
        cult[1] = 0;
        cult[2] = 1;
        cult[3] = 1;
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