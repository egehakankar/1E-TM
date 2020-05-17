package app.Model;

import java.util.ArrayList;
import app.Model.BonusCards;
import app.Model.BonusCard;

public class Player {
    private Player player;
    private Faction factionType;
    private int[] power;
    private int powerInt; // BErdan ekledi
    private int priest;
    private int shovel;
    private int ship;
    private int coin;
    private int worker;
    private int startingDwellings;
    private int id;
    private int town;
    private BonusCard bc;
    private int bonusCardNumber;
    // dwelling, trading, temple, sanctuary,
    private ArrayList<ArrayList<ArrayList<Boolean>>>  buildings;
    private int points;
    // air, water, fire, earth
    private int[] cultLevel;
    private int spade;
    private ArrayList<ArrayList<Integer>> bridges;

    // 0 element of array show empty places, 1 show number of placed structure
    private int[] dwellingsTrack;
    private int[] tradingHouseTrack;
    private int[] templeTrack;
    private int[] sanctuaryTrack;
    private int[] strongholdTrack;

    public Player(Faction faction) {
        factionType = faction;
        this.power = faction.getPower();
        this.priest = faction.getPriests();
        this.shovel = 0;

        if (faction.getName().equals("Mermaids")) {
            this.ship = 1;
        } else {
            this.ship = 0;
        }

        this.coin = faction.getCoins();
        this.startingDwellings = factionType.getDwellings();
        this.worker = faction.getWorkers();
        this.spade = 0;
        id = 0;
        
        points = 0;
        cultLevel = faction.getCult();
        town = 0;
        bridges = new ArrayList<>();

        dwellingsTrack = new int[2];
        dwellingsTrack[0] = 9;
        dwellingsTrack[1] = 0;
        tradingHouseTrack = new int[2];
        tradingHouseTrack[0] = 4;
        tradingHouseTrack[1] = 0;
        templeTrack = new int[2];
        templeTrack[0] = 3;
        templeTrack[1] = 0;
        sanctuaryTrack = new int[2];
        sanctuaryTrack[0] = 1;
        sanctuaryTrack[1] = 1;
        strongholdTrack = new int[2];
        strongholdTrack[0] = 1;
        strongholdTrack[1] = 0;

        int x_axis_length = 5;
        int y_axis_length = 9;
        int z_axis_length = 13;  
        buildings = new ArrayList<>(x_axis_length);
        for (int i = 0; i < x_axis_length; i++) {
            buildings.add(new ArrayList<ArrayList<Boolean>>(y_axis_length));
            for (int j = 0; j < y_axis_length; j++) {
                buildings.get(i).add(new ArrayList<Boolean>(z_axis_length));
                for(int k = 0; k < z_axis_length; k++)
                {
                    if (j % 2 == 0 || k != 12) {
                        buildings.get(i).get(j).add(k,false);
                    }
                }
            }
        }
    }

    public Faction getFaction() {
        return factionType;
    }

    public int getStartingDwellings()
    {
        return startingDwellings;
    }

    public void updatePower(int[] power) {
        this.power = power;
    }

    public int[] getPower() {
        return power;
    }

    public void updatePriest(int priest) {
        this.priest = priest;
    }

    public int getPriest() {
        return priest;
    }

    public void updateShovel(int shovel) {
        this.shovel = shovel;
    }

    public int getShovel() {
        return shovel;
    }

    public void addBuilding(int b, int x, int y)
    {
        buildings.get(b).get(x).add(y, true);
    }

    public void updateShip(int ship) {
        this.ship = ship;
    }

    public int getShip() {
        return ship;
    }

    public void updateCoin(int coin) {
        this.coin = coin;
    }

    public int getCoin() {
        return coin;
    }
    public BonusCard getBonusCard(){
        return bc;
    }

    public void updateBuildings(ArrayList<ArrayList<ArrayList<Boolean>>> placesWithBuildings) {
        this.buildings = placesWithBuildings;
    }

    public ArrayList<ArrayList<ArrayList<Boolean>>> getBuildings() {
        return buildings;
    }

    public void updatePoints(int point) {
        this.points = point;
    }

    public int getPoints() {
        return coin;
    }

    public void updateCultLevel(int[] cultLevel) {
        this.cultLevel = cultLevel;
    }

    public int[] getCultLevel() {
        return cultLevel;
    }

    public int getTown() {
        return town;
    }

    public void updateTown(int town) {
        this.town = town;
    }

    public void updateWorker(int worker) {
        this.worker = worker;
    }

    public int getWorker() {
        return worker;
    }

    public int getSpade() {
        return spade;
    }

    public void updateSpade(int spade) {
        this.spade = spade;
    }

    public ArrayList<ArrayList<Integer>> getBridges() {
        return bridges;
    }

    public void updateBridges(ArrayList<ArrayList<Integer>> bridges) {
        this.bridges = bridges;
    }

    public void updateDwellingTrack(int arr[]) {
        dwellingsTrack = arr;
    }

    public int[] getDwellingTrack() {
        return dwellingsTrack;
    }

    public void updateTradingTrack(int arr[]) {
        tradingHouseTrack = arr;
    }

    public int[] getTradingTrack() {
        return tradingHouseTrack;
    }

    public void updateTempleTrack(int arr[]) {
        templeTrack = arr;
    }

    public int[] getTempleTrack() {
        return templeTrack;
    }

    public void updateSanctuaryTrack(int arr[]) {
        sanctuaryTrack = arr;
    }

    public int[] getSanctuaryTrack() {
        return sanctuaryTrack;
    }

    public void updateStrongholdTrack(int arr[]) {
        strongholdTrack = arr;
    }

    public int[] getStrongholdTrack() {
        return strongholdTrack;
    }

    // Berdan Yazdı
    public void setBonusCardNumber(int number) {
        bonusCardNumber = number;
    }

    // this method updates player's abilities according to their bonus card
    public void updateByBonuscardNumber( int number)
    {
        BonusCards bcards = new BonusCards();
        ArrayList<BonusCard> allCards = bcards.getCards();
        bc = allCards.get(number);
    }

}