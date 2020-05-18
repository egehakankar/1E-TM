package app.Model;

import java.security.PublicKey;
import java.util.ArrayList;
import app.Model.BonusCards;
import app.Model.BonusCard;

public class Player {
    private Player player;
    private Faction factionType;
    private int[] power;
    private int powerInt; // BErdan ekledi
    private int key; //Number of keys. Berdan ekledi.
    private int priest;
    private int shovel;
    private int ship;
    private int coin;
    private int worker;
    private int startingDwellings;
    private int town;
    private BonusCard bc;
    private int bonusCardNumber;
    // dwelling, trading, temple, stronghold, sanctuary
    private ArrayList<ArrayList<ArrayList<Boolean>>>  buildings;
    private int points;
    // air, water, fire, earth
    // fire, water, earth, air olsun.
    private int[] cultLevel;
    // 0 -> 3 space, others 2 space
    private int [][] cultSpaces;
    private int spade;
    //0 -> spade costs 3 workers, 1 -> spade costs 2 workers, 2-> spade costs 1 worker
    private int spadeLevel;
    private ArrayList<ArrayList<Integer>> bridges;

    // 0 element of array show empty places, 1 show number of placed structure
    private int[] dwellingsTrack;
    private int[] tradingHouseTrack;
    private int[] templeTrack;
    private int[] sanctuaryTrack;
    private int[] strongholdTrack;
    private int[] currentAction = {0, 0, 0, 0, 0, 0, 0, 0};

    public Player(Faction faction) {
        factionType = faction;
        this.power = faction.getPower();
        //this.priest = faction.getPriests();
        this.priest = 8;
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
        spadeLevel = 3;
        
        points = 0;
        cultLevel = faction.getCult();
        cultSpaces = new int[4][4];
        for( int i = 0; i < 4; i++){
            for( int j = 0; j < 4; j++){
                cultSpaces[i][j] = 0;
            }
        }
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
        if(b == 0)
        {
            dwellingsTrack[0]--;
            dwellingsTrack[1]++;
        }
        else if(b == 1)
        {
            tradingHouseTrack[0]--;
            tradingHouseTrack[1]++;
        }
        else if(b == 2)
        {
            templeTrack[0]--;
            templeTrack[1]++;
        }
        else if(b == 3)
        {
            sanctuaryTrack[0]--;
            sanctuaryTrack[1]++;
        }
        else
        {
            strongholdTrack[0]--;
            strongholdTrack[1]++;
        }
        buildings.get(b).get(x).set(y, true);
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
        return points;
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
    public int getSpadeLevel(){
        return spadeLevel;
    }
    public void updateSpadeLevel( int spadeLevel){
        this.spadeLevel = spadeLevel;
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

    public void updateCultSpace( int [][] cultSpaces){
        this.cultSpaces = cultSpaces;
    }
    public int[][] getCultSpaces(){
        return cultSpaces;
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

    public int getKeyNumber()
    {
        return key;
    }

    public void resetAction()
    {
        for(int a = 0; a < 8; a++)
        {
            currentAction[a] = 0;
        }
    }

    public void setAction(int a)
    {
        resetAction();
        currentAction[a] = 1;
    }

    public int[] getAction()
    {
        return currentAction;
    }

    public int getPowerInt()
    {
        return powerInt;
    }

    public void setPowerInt(int a)
    {
        powerInt = a;
    }
}