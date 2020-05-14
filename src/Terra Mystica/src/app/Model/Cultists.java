package app.Model;

public class Cultists extends Faction{
    
    public  Cultists(){}
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

}