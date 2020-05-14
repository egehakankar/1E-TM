package app.Model;

public class Witches extends Faction{
    
    public Witches(){
        
    }

    public void useAbility(Player player){

        int c = player.getPoints();
        c = c + 5;
        player.updatePoints(c);
    }
    public void useSpecialAction(Player player){
        boolean [][] arr = player.getBuildings();

            for ( int i = 0 ; i < arr[0].length; i++){

                if ( arr[0][i] == false){
                    arr[0][i] = true;
                    break;
                }
            }
    }

    public void useAfterStrongHold(Player player){
        useSpecialAction(player);
    }

}