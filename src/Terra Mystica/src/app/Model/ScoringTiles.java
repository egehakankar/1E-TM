package app.Model;

import java.util.ArrayList;

public class ScoringTiles {
    
    ArrayList<ScoringTile> scoringPack;
    ScoringTile priestCultWater;
    ScoringTile powerCultFire;
    ScoringTile spadeCultAir;
    ScoringTile spadeCultWater;
    ScoringTile workerCultAir;
    ScoringTile workerCultFire;
    ScoringTile coinCultEarth;
    ScoringTile spadeCultEarth;

    public ScoringTiles(){
        priestCultWater = new ScoringTile(2, 1, 0, 4, "dwelling", "water", 0, 0, 0);
        powerCultFire = new ScoringTile(2, 0, 4, 4, "dwelling", "fire", 0, 0, 0);
        spadeCultAir = new ScoringTile(3, 0, 0, 4, "tradingHouse", "air", 1, 0, 0);
        spadeCultWater = new ScoringTile(3, 0, 0, 4, "tradingHouse", "water", 1, 0, 0);
        workerCultAir = new ScoringTile(5, 0, 0, 2, "strongholdOrSanctuary", "air", 0, 1, 0);
        workerCultFire = new ScoringTile(5, 0, 0, 2, "strongholdOrSanctuary", "fire", 0, 1, 0);
        coinCultEarth = new ScoringTile(2, 0, 0, 1, "spade", "earth", 0, 0, 1);
        spadeCultEarth = new ScoringTile(5, 0, 0, 1, "town", "earth", 1, 0, 0);

        scoringPack.add(priestCultWater);
        scoringPack.add(powerCultFire);
        scoringPack.add(spadeCultAir);
        scoringPack.add(spadeCultWater);
        scoringPack.add(workerCultAir);
        scoringPack.add(workerCultFire);
        scoringPack.add(coinCultEarth);
        scoringPack.add(spadeCultEarth);

    }

    public ArrayList<ScoringTile> getScoringTiles(){
        return scoringPack;
    }
}