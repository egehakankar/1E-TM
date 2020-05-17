package app.Model;

import java.util.ArrayList;

public class BonusCards{
    private ArrayList<BonusCard> cards;
    private BonusCard justPriest;
    private BonusCard workerPower;
    private BonusCard justCoin;
    private BonusCard powerShip;
    private BonusCard coinSpade;
    private BonusCard coinCult;
    private BonusCard coinVicDwell;
    private BonusCard workerVicTrading;
    private BonusCard workerVicStrSanc;

    public BonusCards(){

        coinSpade = new BonusCard(0, 0, 2, "getOneSpade", 0, 0); //bc0
        coinCult = new BonusCard(0, 0, 4, "advanceOneCult", 0, 0); //bc1
        justCoin = new BonusCard(0, 0, 6,  null, 0, 0); //bc2
        powerShip = new BonusCard( 0, 3, 0, "getOneShip", 0, 0); //bc3
        workerPower = new BonusCard(0, 3, 0, null, 3, 0); //bc4
        workerVicStrSanc = new BonusCard( 0, 0, 0, null, 2, 4); //bc5
        workerVicTrading = new BonusCard(0 ,0 , 0, null, 1, 2); //bc6
        justPriest = new BonusCard(1, 0, 0,  null, 0, 0); //bc7
        coinVicDwell = new BonusCard(0, 0, 2, null, 0, 1); //bc8
        
        cards = new ArrayList<BonusCard>();
        cards.add(coinSpade);
        cards.add(coinCult);
        cards.add(justCoin);
        cards.add(powerShip);
        cards.add(workerPower);
        cards.add(workerVicStrSanc);
        cards.add(workerVicTrading);
        cards.add(justPriest);
        cards.add(coinVicDwell);
        
        

    }
    public ArrayList<BonusCard> getCards(){
        return cards;
    }
}