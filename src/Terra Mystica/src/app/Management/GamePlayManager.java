package app.Management;

import java.util.ArrayList;

import app.Model.*;

public class GamePlayManager {


    private static ArrayList<Player> playerList;
    public GamePlayManager( ArrayList<Faction> factionList){
        playerList = new ArrayList<Player>();
        for ( int i = 0; i < factionList.size(); i++){
            Player player = new Player(factionList.get(i));
            playerList.add(player);
        }
    }

    public void receiveIncome ( Player player){

        int [] dw = player.getDwellingTrack();
        int [] tr = player.getTradingTrack();
        int [] tmp = player.getTempleTrack();

        
        if( dw [0] == 9){
            
            player.updateWorker( player.getWorker() + dw[0] - 1 );
        }
        else if ( dw[0] > 1){
            player.updateWorker( player.getWorker() + dw[0]);
        }
        else{}

        int [] power = player.getPower();
        int c = 0;
        if ( tr[0] == 4){
            
            if( player.getFaction().getName().equals("Swarmlings")){
                player.updateCoin( player.getCoin() + 9);
                c = 8;
            }
            else if( player.getFaction().getName().equals("Dwarves")){
                player.updateCoin( player.getCoin() + 10);
                c = 6;
            }
            else if( player.getFaction().getName().equals("Nomads") || player.getFaction().getName().equals("Alchemists")){
                player.updateCoin( player.getCoin() + 11);
                c = 4;
            }
            else{
                player.updateCoin( player.getCoin() + 8);
                c = 6;
            }
        }
        else if ( tr[0] == 3){
            if( player.getFaction().getName().equals("Swarmlings")){
                player.updateCoin( player.getCoin() + 6);
                c = 6;
            }
            else if( player.getFaction().getName().equals("Dwarves")){
                player.updateCoin( player.getCoin() + 7);
                c = 4;
            }
            else if( player.getFaction().getName().equals("Nomads") || player.getFaction().getName().equals("Alchemists")){
                player.updateCoin( player.getCoin() + 7);
                c = 3;
            }
            else{
                player.updateCoin( player.getCoin() + 6);
                c = 4;
            }
        }
        else if ( tr[0] == 2){
            if( player.getFaction().getName().equals("Swarmlings")){
                player.updateCoin( player.getCoin() + 4);
                c = 4;
            }
            else if( player.getFaction().getName().equals("Dwarves")){
                player.updateCoin( player.getCoin() + 5);
                c = 2;
            }
            else if( player.getFaction().getName().equals("Nomads") || player.getFaction().getName().equals("Alchemists")){
                player.updateCoin( player.getCoin() + 4);
                c = 2;
            }
            else{
                player.updateCoin( player.getCoin() + 4);
                c = 2;
            }
        }
        else if ( tr[0] == 1){
            if( player.getFaction().getName().equals("Swarmlings")){
                player.updateCoin( player.getCoin() + 2);
                c = 2;
            }
            else if( player.getFaction().getName().equals("Dwarves")){
                player.updateCoin( player.getCoin() + 3);
                c = 1;
            }
            else if( player.getFaction().getName().equals("Nomads") || player.getFaction().getName().equals("Alchemists")){
                player.updateCoin( player.getCoin() + 2);
                c = 1;
            }
            else{
                player.updateCoin( player.getCoin() + 2);
                c = 1;
            }
        }
        else{}
        if ( c > power[0]){
            power[1] = power[0] + power[1];
            c = c - power[0];
            power[0] = 0;
           
            if( c > power[1]){
                power[2] = 12;
                power[1] = 0;
                c = 0;
            }
            else{
                power[2] = power[2] + c;
                power[1] = power[1] - c;
            }

        }
        else{
            power[1] = power[1] + c;
            power[0] = power[0] - c;
        }

        player.updatePower(power);
        player.updatePriest(player.getPriest() + tmp[0]);
        
    }

    public static ArrayList<Player> getPlayerList()
    {
         return playerList;
    }
}