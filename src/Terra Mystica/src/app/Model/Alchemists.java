package app.Model;

public class Alchemists extends Faction{

    String name;
    public Alchemists(){
        name = "Alchemists";
    }

    public String getColor()
    {
        return "Black";
    }

    public int getDwellings(){
        return 2;
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
        int c = 12;
        arr[1] = arr[1] + arr[0];
        c = c - arr[0];
        arr[0] = 0;
        arr[2] = arr[2] + c;
        arr[1] = arr[1] - c;
        player.updatePower(arr);

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
        cult[3] = 0;
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