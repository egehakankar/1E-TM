package app.Management;

import java.util.ArrayList;

import app.Model.*;

public class GamePlayManager {

    ArrayList<Player> playerList;
    public GamePlayManager( ArrayList<Faction> factionList, ArrayList<String> names){

        for ( int i = 0; i < names.size(); i++){
            Player player = new Player( factionList.get(i), names.get(i));
            playerList.add(player);
        }
    }

    //Phase1 Income
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

    //Action2

    public void buildBridge(){}
    //Action3
    public boolean increaseSpadeLevel( Player player){
        if( player.getSpade() < 2 && player.getWorker() >= 2 && player.getCoin() >= 5 && player.getPriest() >= 1){
            player.updateSpade(player.getSpade() + 1);
            player.updateWorker(player.getWorker() - 2);
            player.updateCoin(player.getCoin() - 5);
            player.updatePriest(player.getPriest() - 1);
            return true;
        }
        return false;
    }
    
    //Action5
    public boolean sendPriestCult( Player player, String cultName){
        int cult = 0;
        if( cultName.equals("air")){}
        else if( cultName.equals("water")){
            cult = 1;
        }
        else if( cultName.equals("fire")){
            cult = 2;
        }
        else{
            cult = 3;
        }
        if( player.getPriest() > 0){
            for( int i = 0; i < 4; i++){
                if( player.getCultSpaces()[cult][i] == 0){
                    int k = 2;
                    int c = 0;
                    if( i == 0){
                        k = 3;
                    }
                    int [] temp = player.getCultLevel();
                    temp[cult] = temp[cult] + k;
                    if( temp[cult] > 10){
                        temp[cult] = 10;
                    }
                    player.updateCultLevel(temp);
                    int [] power = player.getPower();
                    if( temp[cult] < 3 && (temp[cult] + k) >= 3){
                        c = 1;
                    }
                    if( temp[cult] < 5 && (temp[cult] + k) >= 5){
                        c = 2;
                    }
                    if( temp[cult] < 7 && (temp[cult] + k) >= 7){
                        c = 2;
                    }
                    if ( temp[cult] < 10 && (temp[cult] + k) == 10){
                        c = 3;
                    }
                    
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
                    
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    //Action6: Power actions there is 6 of them. First build bridge, others are about converting powers to resources

    public boolean convertPower( Player player, String action){

        int [] power = player.getPower();
        if ( action.equals("convertPriest")){

            if( power[2] >= 3){
                player.updatePriest(player.getPriest() + 1);
                power[2] = power[2] - 3;
                power[0] = power[0] + 3;
                return true;
            }
        }

        else if( action.equals("convertWorkers")){
            if( power[2] >= 4){
                player.updateWorker(player.getWorker() + 2);
                power[2] = power[2] - 4;
                power[0] = power[0] + 4;
                return true;
            }
        }

        else if( action.equals("convertCoins")){
            if( power[2] >= 4){
                player.updateCoin(player.getCoin() + 7);
                power[2] = power[2] - 4;
                power[0] = power[0] + 4;
                return true;
            }
        }

        else if( action.equals("convertOneSpade")){
            if( power[2] >= 4){
                player.updateSpade(player.getSpade() + 1);
                power[2] = power[2] - 4;
                power[0] = power[0] + 4;
                return true;
            }
        }
        else if( action.equals("convertTwoSpade")){
            if( power[2] >= 6){
                player.updateSpade(player.getSpade() + 2);
                power[2] = power[2] - 6;
                power[0] = power[0] + 6;
                return true;
            }
        }
        return false;
    }
    //Action7
    public void specialAction( Player player){

    }





    
}