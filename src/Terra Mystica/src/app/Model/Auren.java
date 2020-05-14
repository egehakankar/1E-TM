package app.Model;

public class Auren extends Faction{

    FavorTiles tiles;
    FavorTile tile;
    Player player;
    public Auren(){
    
        tiles = new FavorTiles();

    }

    public void useSpecialAction( Player player){

        int t = (int)( Math.random() * 4) + 0;
        int [] temp = player.getCultLevel();
        temp[t] = temp[t] + 2;
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

}