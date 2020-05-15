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
    private int dwellings;
    private int id;
    private int town;
    private ArrayList<BonusCards> bonusCards;
    private ArrayList<ArrayList<Integer>> buildings;
    private int points;
    private int[] cultLevel;
    private String name;
    private int spade;
    private ArrayList<ArrayList<Integer>> bridges;
    public Player( Faction faction, String name){
        factionType = faction;
        player = new Player(factionType, name);
        this.power = new int[3];
        this.priest = 0;
        this.shovel = 0;
        this.ship = 0;
        this.coin = 0;
        this.dwellings = factionType.getDwellings();
        this.worker = 0;
        this.spade = 0;
        id = 0;
        bonusCards = new ArrayList<BonusCards>();
        buildings = new ArrayList<ArrayList<Integer>>();
        points = 0;
        cultLevel = new int[4];
        this.name = name;
        town = 0;
        bridges = new ArrayList<>();
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

}