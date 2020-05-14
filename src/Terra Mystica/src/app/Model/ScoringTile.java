package app.Model;

public class ScoringTile {
    
    private int victoryP;
    private int priest;
    private int power;
    private int space;
    private String condition;
    private String cult;
    private int spade;
    private int worker;
    private int coin;

    public ScoringTile( int victoryP, int priest, int power, int space, String condition, String cult, int spade, int worker, int coin){
        this.victoryP = victoryP;
        this.priest = priest;
        this.space = space;
        this.condition = condition;
        this.cult = cult;
        this.spade = spade;
        this.worker = worker;
        this.coin = coin;
        this.power = power;
    }

    public int getVictoryP(){
        return victoryP;
    }
    public int getPriest(){
        return priest;
    }
    public int getSpace(){
        return space;
    }
    public String getCondition(){
        return condition;
    }
    public String getCult(){
        return cult;
    }
    public int getSpade(){
        return spade;
    }
    public int getWorker(){
        return worker;
    }
    public int getCoin(){
        return coin;
    }
    public int getPower(){
        return power;
    }
}