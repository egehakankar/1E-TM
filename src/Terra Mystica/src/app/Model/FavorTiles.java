package app.Model;

import java.util.ArrayList;

public class FavorTiles {

    private ArrayList<FavorTile> pack;
    private FavorTile advThreeAir;
    private FavorTile advThreeWater;
    private FavorTile advThreeEarth;
    private FavorTile advThreeFire;
    private FavorTile foundTown6Pow;
    private FavorTile threeCoin;
    private FavorTile oneCult;
    private FavorTile threeVicP;
    private FavorTile fourPower;
    private FavorTile threeVicForTradingH;
    private FavorTile workerPower;
    private FavorTile twoVicPDwell;

    public FavorTiles(){

        advThreeAir = new FavorTile(3, 0, 0, null, 0, 0, 0);
        advThreeWater = new FavorTile(3, 0, 0, null, 0, 0, 0);
        advThreeEarth = new FavorTile(3, 0, 0, null, 0, 0, 0);
        advThreeFire = new FavorTile(3, 0, 0, null, 0, 0, 0);
        foundTown6Pow = new FavorTile(0, 6, 0, "foundingTown", 0, 0, 0);
        threeCoin = new FavorTile(0, 0, 3, null, 0, 0, 0);
        oneCult = new FavorTile(1, 0, 0, "specialAction", 0, 0, 0);
        threeVicP = new FavorTile(0, 0, 0, "dwellingToTrading", 3, 0, 0);
        fourPower = new FavorTile(0, 0, 0, null, 0, 4, 0);
        threeVicForTradingH = new FavorTile(0, 0, 0, "tradingHouseForEachFour", 3, 0, 0);
        workerPower = new FavorTile(0, 0, 0, null, 0, 1, 1);
        twoVicPDwell = new FavorTile(0, 0, 0, "buildingDwelling", 2, 0, 0);

        pack.add( advThreeAir);
        pack.add( advThreeWater);
        pack.add( advThreeEarth);
        pack.add( advThreeFire);
        pack.add( foundTown6Pow);
        pack.add( threeCoin);
        pack.add( oneCult);
        pack.add( threeVicP);
        pack.add( fourPower);
        pack.add( threeVicForTradingH);
        pack.add( workerPower);
        pack.add( twoVicPDwell);
    }
    
    public ArrayList<FavorTile> getFavorTiles(){
        return pack;
    }

}