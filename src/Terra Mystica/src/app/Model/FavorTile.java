package app.Model;

public class FavorTile {
    
    private int cult;
    private int powForTown;
    private int coin;
    private String condition;
    private int victoryP;
    private int power;
    private int worker;

    public FavorTile( int cult, int powForTown, int coin, String condition, int victoryP, int power, int worker){

        this.cult = cult;
        this.powForTown = powForTown;
        this.coin = coin;
        this.condition = condition;
        this.victoryP = victoryP;
        this.power = power;
        this.worker = worker;
    }

    public int getCult(){
        return cult;
    }
    public int getPowForTown(){
        return powForTown;
    }
    public int getCoin(){
        return coin;
    }
    public String getCondition(){
        return condition;
    }
    public int getVictoryP(){
        return victoryP;
    }
    public int getPower(){
        return power;
    }
    public int getWorker(){
        return worker;
    }
}