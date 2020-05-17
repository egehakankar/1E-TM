package app.Management;

import java.util.ArrayList;

import app.Model.*;

public class GamePlayManager {

    private int playerCount;
    private int round;
    private static ArrayList<Player> playerList;
    private static ArrayList<Player> passingPlayerList;
    private static ArrayList<Integer> scoringTiles;

    public GamePlayManager( ArrayList<Faction> factionList){
        scoringTiles = new ArrayList<Integer>();

        for(int i = 0; i < 6 ; i ++)
        {
            int randomNumber = (int)(Math.random()*8);

            if (scoringTiles.contains(randomNumber))
                i--;
            else
                scoringTiles.add(randomNumber);
        }

        playerList = new ArrayList<Player>();
        for ( int i = 0; i < factionList.size(); i++){
            Player player = new Player(factionList.get(i));
            playerList.add(player);
        }
        playerCount = playerList.size();
        passingPlayerList = new ArrayList<Player>();
        round = 0;
    }

    //Phase1 Income
    public static int[] receiveIncome ( Player player){
        int [] dw = player.getDwellingTrack();
        int [] tr = player.getTradingTrack();
        int [] tmp = player.getTempleTrack();
        
        int all[] = new int[4];
        int addedCoin = 0;
        int power01 = 0;
        int power12 = 0;
        int addedPriest = 0;
        
        if( dw [0] == 9){
            player.updateWorker( player.getWorker() + dw[1] - 1 );
            addedCoin += dw[1] - 1;
        }
        else if ( dw[0] > 1){
            player.updateWorker( player.getWorker() + dw[1]);
            addedCoin += dw[1];
        }
        else{}

        int [] power = player.getPower();
        int c = 0;
        if ( tr[1] == 4){
            
            if( player.getFaction().getName().equals("Swarmlings")){
                player.updateCoin( player.getCoin() + 9);
                addedCoin += 9;
                c = 8;
            }
            else if( player.getFaction().getName().equals("Dwarves")){
                player.updateCoin( player.getCoin() + 10);
                addedCoin += 10;
                c = 6;
            }
            else if( player.getFaction().getName().equals("Nomads") || player.getFaction().getName().equals("Alchemists")){
                player.updateCoin( player.getCoin() + 11);
                addedCoin += 11;
                c = 4;
            }
            else{
                player.updateCoin( player.getCoin() + 8);
                addedCoin += 8;
                c = 6;
            }
        }
        else if ( tr[1] == 3){
            if( player.getFaction().getName().equals("Swarmlings")){
                player.updateCoin( player.getCoin() + 6);
                addedCoin += 6;
                c = 6;
            }
            else if( player.getFaction().getName().equals("Dwarves")){
                player.updateCoin( player.getCoin() + 7);
                addedCoin += 7;
                c = 4;
            }
            else if( player.getFaction().getName().equals("Nomads") || player.getFaction().getName().equals("Alchemists")){
                player.updateCoin( player.getCoin() + 7);
                addedCoin += 7;
                c = 3;
            }
            else{
                player.updateCoin( player.getCoin() + 6);
                addedCoin += 6;
                c = 4;
            }
        }
        else if ( tr[1] == 2){
            if( player.getFaction().getName().equals("Swarmlings")){
                player.updateCoin( player.getCoin() + 4);
                addedCoin += 4;
                c = 4;
            }
            else if( player.getFaction().getName().equals("Dwarves")){
                player.updateCoin( player.getCoin() + 5);
                addedCoin += 5;
                c = 2;
            }
            else if( player.getFaction().getName().equals("Nomads") || player.getFaction().getName().equals("Alchemists")){
                player.updateCoin( player.getCoin() + 4);
                addedCoin += 4;
                c = 2;
            }
            else{
                player.updateCoin( player.getCoin() + 4);
                addedCoin += 4;
                c = 2;
            }
        }
        else if ( tr[1] == 1){
            if( player.getFaction().getName().equals("Swarmlings")){
                player.updateCoin( player.getCoin() + 2);
                addedCoin += 2;
                c = 2;
            }
            else if( player.getFaction().getName().equals("Dwarves")){
                player.updateCoin( player.getCoin() + 3);
                addedCoin += 3;
                c = 1;
            }
            else if( player.getFaction().getName().equals("Nomads") || player.getFaction().getName().equals("Alchemists")){
                player.updateCoin( player.getCoin() + 2);
                addedCoin += 2;
                c = 1;
            }
            else{
                player.updateCoin( player.getCoin() + 2);
                addedCoin += 2;
                c = 1;
            }
        }
        else{}
        if (c > power[0])
        {
            power[1] = power[0] + power[1];
            power01 += power[0];
            c = c - power[0];
            power[0] = 0;
           
            if( c > power[1]){
                power12 += c;
                power[2] = 12;
                power[1] = 0;
                c = 0;
            }
            else{
                power12 += c;
                power[2] = power[2] + c;
                power[1] = power[1] - c;
            }
        }
        else{
            power01 += c;
            power[1] = power[1] + c;
            power[0] = power[0] - c;
        }

        player.updatePower(power);
        player.updatePriest(player.getPriest() + tmp[1]);

        addedPriest += tmp[1];
        all[0] = addedCoin;
        all[1] = addedPriest;
        all[2] = power01;
        all[3] = power12;
        return all;
    }

    //Action1 Transform and build

    public boolean buildDwelling( Player player, int x, int y){
        int reqWorker = 1;
        int reqCoin = 2;
        if( player.getFaction().getName().equals("Engineers")){
            reqCoin = 1;
        }
        else if( player.getFaction().getName().equals("Swarmlings")){
            reqWorker = 2;
            reqCoin = 3;
        }
        if( player.getWorker() >= reqWorker && player.getCoin() >= reqCoin){
            player.addBuilding(0, x, y);
            return true;
        }
        return false;
    }

    public boolean transformTerrainToHome(){

        return false;
    }


    //Action2 advance on shipping track by one
    public boolean advanceShipping( Player player){

        int ship = player.getShip();
        if( ship == 0){
            player.updatePoints(player.getPoints() + 2);
            player.updateShip( ship + 1);
            return true;
        }
        else if( ship == 1){
            player.updatePoints(player.getPoints() + 3);
            player.updateShip( ship + 1);
            return true;
        }
        else if( ship == 2){
            player.updatePoints(player.getPoints() + 4);
            player.updateShip( ship + 1);
            return true;
        }
        return false;
        
    }
    
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

    //Action 4
    public boolean upgradeToTradingHouse( Player player, int x, int y){

        int reqWorker = 2;
        int reqCoin = 6;
        ArrayList<ArrayList<ArrayList<Boolean>>> buildings = player.getBuildings();
        if( player.getFaction().getName().equals("Swarmlings")){
            reqWorker = 3;
            reqCoin = 8;
        }
        else if( player.getFaction().getName().equals("Engineers")){
            reqWorker = 1;
            reqCoin = 4;
        }
        if( player.getWorker() >= reqWorker && player.getCoin() >= reqCoin && buildings.get(0).get(x).get(y) == true){
            player.addBuilding(1, x, y);
            buildings.get(0).get(x).add(y, false);
            player.updateBuildings(buildings);
            return true;
        }
        

        return false;
    }

    public boolean upgradeToTemple( Player player, int x, int y){

        int reqWorker = 2;
        int reqCoin = 5;
        ArrayList<ArrayList<ArrayList<Boolean>>> buildings = player.getBuildings();
        if( player.getFaction().getName().equals("Swarmlings")){
            reqWorker = 3;
            reqCoin = 6;
        }
        else if( player.getFaction().getName().equals("Engineers")){
            reqWorker = 1;
            reqCoin = 4;
        }
        if( player.getWorker() >= reqWorker && player.getCoin() >= reqCoin && buildings.get(1).get(x).get(y) == true){
            player.addBuilding(2, x, y);
            buildings.get(1).get(x).add(y, false);
            player.updateBuildings(buildings);
            return true;
        }
        

        return false;
    }

    public boolean upgradeToSanctuary( Player player, int x, int y){

        int reqWorker = 4;
        int reqCoin = 6;
        ArrayList<ArrayList<ArrayList<Boolean>>> buildings = player.getBuildings();
        if( player.getFaction().getName().equals("Swarmlings")){
            reqWorker = 5;
            reqCoin = 8;
        }
        else if( player.getFaction().getName().equals("Engineers")){
            reqWorker = 3;
        }
        else if( player.getFaction().getName().equals("Darklings")){
            reqCoin = 10;
        }
        else if( player.getFaction().getName().equals("ChaosMagicians") || player.getFaction().getName().equals("Cultists")){
            reqCoin = 8;
        }
        else if( player.getFaction().getName().equals("Mermaids") || player.getFaction().getName().equals("Auren")){
            reqCoin = 8;
        }
        
        if( player.getWorker() >= reqWorker && player.getCoin() >= reqCoin && buildings.get(2).get(x).get(y) == true){
            player.addBuilding(4, x, y);
            buildings.get(2).get(x).add(y, false);
            player.updateBuildings(buildings);
            return true;
        }
        

        return false;
    }

    public boolean upgradeToStronghold( Player player, int x, int y){

        int reqWorker = 4;
        int reqCoin = 6;
        ArrayList<ArrayList<ArrayList<Boolean>>> buildings = player.getBuildings();
        if( player.getFaction().getName().equals("Swarmlings")){
            reqWorker = 5;
            reqCoin = 8;
        }
        else if( player.getFaction().getName().equals("Engineers")){
            reqWorker = 3;
        }
        else if( player.getFaction().getName().equals("Darklings")){
            reqCoin = 10;
        }
        else if( player.getFaction().getName().equals("Nomads") || player.getFaction().getName().equals("Cultists") || player.getFaction().getName().equals("Halflings")){
            reqCoin = 8;
        }
        else if( player.getFaction().getName().equals("ChaosMagicians")){
            reqCoin = 10;
        }
        
        if( player.getWorker() >= reqWorker && player.getCoin() >= reqCoin && buildings.get(1).get(x).get(y) == true){
            player.addBuilding(3, x, y);
            buildings.get(1).get(x).add(y, false);
            player.updateBuildings(buildings);
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

    public void buildBridge(){}

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
    public void specialAction( Player player, String condition){

        if ( condition.equals("bonusCard")){
            BonusCards bc = new BonusCards();
            ArrayList<BonusCard> bnc = bc.getCards();
            if( player.getBonusCard() == bnc.get(0)){
                player.updateSpade(player.getSpade() + 1);
            }
            else if( player.getBonusCard() == bnc.get(1)){

            }
            else if( player.getBonusCard() == bnc.get(3)){
                player.updateShip(player.getShip() + 1);
            }
        }

        else{
            if ( player.getBuildings().get(3).size() > 0){
                if ( player.getFaction().getName() == "Auren"){
                    player.getFaction().useSpecialAction(player);
                }
                
                else if ( player.getFaction().getName() == "Swarmlings"){

                    ArrayList<ArrayList<ArrayList<Boolean>>>  buildings = player.getBuildings();
                    for( int i = 0; i < buildings.get(0).size(); i++){
                        for( int j = 0; j < buildings.get(0).get(i).size(); j++){
                            if( buildings.get(0).get(i).get(j) == true){
                                player.updateCoin(player.getCoin() + 3);
                                player.updateWorker(player.getWorker() + 8);
                                upgradeToTradingHouse( player, i, j);
                                break;
                            }
                        }
                    }
                    
                }
                else if ( player.getFaction().getName() == "ChaosMagicians"){
                    
                }
                else if ( player.getFaction().getName() == "Giants"){
                    player.getFaction().useSpecialAction(player);
                }
                else if ( player.getFaction().getName() == "Nomads"){
                    transformTerrainToHome();
                }
            }
        }
    }

    //Action8

    public void passThePhase( Player player){
        passingPlayerList.add(player);
        if( passingPlayerList.size() == playerCount){
            playerList = passingPlayerList;

        }

    }

    public static ArrayList<Integer> getScoringTiles()
    {
        return scoringTiles;
    }


    public static ArrayList<Player> getPlayerList()
    {
         return playerList;
    }

    public int getRound()
    {
        return round;
    }

    public void addRound()
    {
        round++;
    }
}