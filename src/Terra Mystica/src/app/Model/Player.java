package app.Model;

import java.util.ArrayList;

public class Player {
    private Player player;
    private Faction factionType;
    private int[] power;
    private int priest;
    private int shovel;
    private int ship;
    private int coin;
    private int worker;
    private int startingDwellings;
    private int id;
    private int town;
    private ArrayList<BonusCards> bonusCards;
    // dwelling, trading, temple, sanctuary, 
    private ArrayList<ArrayList<Integer>> buildings;
    private int points;
    // air, water, fire, earth
    private int[] cultLevel;
    private String name;
    private int spade;
    private ArrayList<ArrayList<Integer>> bridges;

    // 0 element of array show empty places, 1 show number of placed structure
    private int [] dwellingsTrack;
    private int [] tradingHouseTrack;
    private int [] templeTrack;
    private int [] sanctuaryTrack;
    private int [] strongholdTrack;
    public Player( Faction faction, String name){
        factionType = faction;
        player = new Player(factionType, name);
        this.power = faction.getPower();
        this.priest = faction.getPriests();
        this.shovel = 0;

        if ( faction.getName().equals("Mermaids")){
            this.ship = 1;
        }
        else{
            this.ship = 0;
        }
        
        this.coin = faction.getCoins();
        this.startingDwellings = factionType.getDwellings();
        this.worker = faction.getWorkers();
        this.spade = 0;
        id = 0;
        bonusCards = new ArrayList<BonusCards>();
        buildings = new ArrayList<ArrayList<Integer>>();
        points = 0;
        cultLevel = faction.getCult();
        this.name = name;
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
    }

    public Faction getFaction(){
        return factionType;
    }

    public void updatePower(int[]power){
        this.power = power;
    }
    public int[] getPower(){
        return power;
    }
    public void updatePriest(int priest){
        this.priest = priest;
    }
    public int getPriest(){
        return priest;
    }
    public void updateShovel(int shovel){
        this.shovel= shovel;
    }
    public int getShovel(){
        return shovel;
    }
    public void updateShip(int ship){
        this.ship = ship;
    }
    public int getShip(){
        return ship;
    }
    public void updateCoin(int coin){
        this.coin = coin;
    }
    public int getCoin(){
        return coin;
    }
    public void updateBonusCards(ArrayList<BonusCards> bonusCards){
        this.bonusCards = bonusCards;
    }
    public ArrayList<BonusCards> getBonusCards(){
        return bonusCards;
    }
    public void updateBuildings(ArrayList<ArrayList<Integer>> placesWithBuildings){
        this.buildings = placesWithBuildings;
    }
    public ArrayList<ArrayList<Integer>> getBuildings(){
        return buildings;
    }
    public void updatePoints(int point){
        this.points = point;
    }
    public int getPoints(){
        return coin;
    }
    public void updateCultLevel(int[] cultLevel){
        this.cultLevel = cultLevel;
    }
    public int[] getCultLevel(){
        return cultLevel;
    }
    
    public int getTown(){
        return town;
    }

    public void updateTown( int town){
        this.town = town;
    }

    public void updateWorker( int worker){
        this.worker = worker;
    }

    public int getWorker(){
        return worker;
    }

    public int getSpade(){
        return spade;
    }
    public void updateSpade( int spade){
        this.spade = spade;
    }

    public ArrayList<ArrayList<Integer>> getBridges(){
        return bridges;
    }

    public void updateBridges(ArrayList<ArrayList<Integer>> bridges){
        this.bridges = bridges;
    }

    public void updateDwellingTrack( int arr[]){
        dwellingsTrack = arr;
    }
    public int[] getDwellingTrack(){
        return dwellingsTrack;
    }
    public void updateTradingTrack( int arr[]){
        tradingHouseTrack = arr;
    }
    public int[] getTradingTrack(){
        return tradingHouseTrack;
    }
    public void updateTempleTrack( int arr[]){
        templeTrack = arr;
    }
    public int[] getTempleTrack(){
        return templeTrack;
    }
    public void updateSanctuaryTrack( int arr[]){
        sanctuaryTrack = arr;
    }
    public int[] getSanctuaryTrack(){
        return sanctuaryTrack;
    }
    public void updateStrongholdTrack( int arr[]){
        strongholdTrack = arr;
    }
    public int[] getStrongholdTrack(){
        return strongholdTrack;
    }

}