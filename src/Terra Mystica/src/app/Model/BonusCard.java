package app.Model;

public class BonusCard {

    private int priest;
    private int power;
    private int coin;
    private String specialAction;
    private int worker;
    private int victoryPoints;

    public BonusCard( int priest, int power, int coin, String specialAction, int worker, int victoryPoints){
        this.priest = priest;
        this.power = power;
        this.coin = coin;
        this.specialAction = specialAction;
        this.worker = worker;
        this.victoryPoints = victoryPoints;
    }
    public int getPriest(){
        return priest;
    }
    public int getPower(){
        return power;
    }
    public int getCoin(){
        return coin;
    }
    public String specialAction(){
        return specialAction;
    }
    public int getWorker(){
        return worker;
    }
    public int getVictoryPoints(){
        return victoryPoints;
    }
}