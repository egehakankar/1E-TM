package app.Model;
import java.util.*;
public class TownTiles {
    private ArrayList<TownTile> pack;
    private TownTile vicPriest;
    private TownTile vicOneFourCult;
    private TownTile vicWorker;
    private TownTile vicPower;
    private TownTile vicCoins;
    
    public TownTiles(){

        vicPriest = new TownTile(9, 1, 0, 0, 0, 0);
        vicOneFourCult = new TownTile(8, 0, 1, 0, 0, 0);
        vicWorker = new TownTile(7, 0, 0, 2, 0, 0);
        vicPower = new TownTile(6, 0, 0, 0, 8, 0);
        vicCoins = new TownTile(5, 0, 0, 0, 0, 6);

        pack.add(vicPriest);
        pack.add(vicOneFourCult);
        pack.add(vicWorker);
        pack.add(vicPower);
        pack.add(vicCoins);
    }

    public ArrayList<TownTile> getTownTiles(){
        return pack;
    }
}