package app.Model;

public class Alchemists extends Faction{


    public Alchemists(){

    }
    public void useSpecialAction(Player player){

        
    }

    public void useAbility2(Player player){
        int temp = player.getPoints();
        int coin = player.getCoin();
        temp = temp + 1;
        coin = coin - 1;
        player.updateCoin(coin);
        player.updatePoints(temp);
    }
    public void useAbility(Player player){
        int temp = player.getPoints();
        int coin = player.getCoin();
        temp = temp - 1;
        coin = coin + 1;
        player.updateCoin(coin);
        player.updatePoints(temp);
    }
    public void useAfterStrongHold(Player player){
        int [] arr = player.getPower();
        arr[0] = arr[0] + 4;
        arr[1] = arr[1] + 4;
        arr[2] = arr[2] + 4;
        player.updatePower(arr);
    }
   
}