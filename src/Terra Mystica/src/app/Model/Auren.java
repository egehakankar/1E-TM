package app.Model;

public class Auren extends Faction{

    FavorTiles tiles;
    FavorTile tile;
    Player player;
    String name;
    public Auren(){
    
        tiles = new FavorTiles();
        name = "Auren";

    }

    public int[] getColor()
    {
        int colorGreen[] = { 112, 194, 115 };
        return colorGreen;
    }

    public int getDwellings(){
        return 2;
    }
    public void useSpecialAction( Player player){

        int [] temp = player.getCultLevel();
        if ( temp[0] > 7 && temp[0] < 10){
            temp[0] = temp[0] + 2;
        }
        else if ( temp[1] > 7 && temp[1] < 10){
            temp[1] = temp[1] + 2;
        }
        else if ( temp[2] > 7 && temp[2] < 10){
            temp[2] = temp[2] + 2;
        }
        else if ( temp[3] > 7 && temp[3] < 10){
            temp[3] = temp[3] + 2;
        }
        
        player.updateCultLevel(temp);
    }
    public void useAbility(Player player){

    }
    public void useAfterStrongHold(Player player){
        tile = tiles.getFavorTiles().get( (int)( Math.random() * 9) + 0);
        int c = player.getCoin();
        c = c + tile.getCoin();
        player.updateCoin(c);
        c = player.getWorker();
        c = c + tile.getWorker(); 
        player.updateWorker(c);
        c = player.getPoints();
        c = c + tile.getVictoryP();
        player.updatePoints(c);
        int [] arr = player.getPower();
        c = arr[0] + tile.getPower();
        arr[0] = c;
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
        cult[0] = 1;
        cult[1] = 1;
        cult[2] = 0;
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