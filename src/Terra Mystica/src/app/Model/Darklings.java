package app.Model;

public class Darklings extends Faction{
    
    String name;
    public Darklings(){
        name = "Darklings";
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



}