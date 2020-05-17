package app.Model;

public class Darklings extends Faction{
    
    String name;
    public Darklings(){
        name = "Darklings";
    }   

    public String getColor()
    {
        return "Black";
    }

    public int getDwellings(){
        return 2;
    }
    public void useSpecialAction(Player player){

    }
    public void useAbility(Player player){

        int c = player.getPriest();
        c = c - 1;
        int vic = player.getPoints();
        vic = vic + 2;
        player.updatePriest(c);
        player.updatePoints(vic);

    }
    public void useAfterStrongHold(Player player){
        int worker = player.getWorker();
        if( worker >= 3){
            worker = worker - 3;
            int c = player.getPriest();
            c = c - 1;
            player.updatePriest(c);
            player.updateWorker(worker);
        }
        
    }

    public String getName(){
        return name;
    }

    public int getPriests(){
        return 1;
    }
    public int getCoins(){
        return 15;
    }
    public int getWorkers(){
        return 1;
    }
    public int[] getCult(){
        int [] cult = new int[4];
        cult[0] = 0;
        cult[1] = 1;
        cult[2] = 0;
        cult[3] = 1;
        return cult;
    }

    public  int[] getPower(){

        int[] power = new int[3];
        power[0] = 5;
        power[1] = 7;
        power[2] = 0;
        return power;
    }



}