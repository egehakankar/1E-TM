package app.Model;
public class TownTile{

    private int victoryP;
    private int priest;
    private int cult;
    private int worker;
    private int power;
    private int coin;

    public TownTile( int victoryP, int priest, int cult, int worker, int power, int coin){
        this.victoryP = victoryP;
        this.priest = priest;
        this.cult = cult;
        this.worker = worker;
        this.power = power;
        this.coin = coin;
    }

    public int getVictoryP(){
        return victoryP;
    }

    public int getPriest(){
        return priest;
    }
    public int getCult(){
        return cult;
    }
    public int getWorker(){
        return worker;
    }
    public int getPower(){
        return power;
    }
    public int getCoin(){
        return coin;
    }
}