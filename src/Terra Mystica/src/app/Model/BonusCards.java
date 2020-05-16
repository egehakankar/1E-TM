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
    private BonusCard workerVicDwell;
    private BonusCard workerVicTrading;
    private BonusCard workerVicStrSanc;

    public BonusCards(){
        justPriest = new BonusCard(1, 0, 0,  null, 0, 0);
        workerPower = new BonusCard(0, 3, 0, null, 3, 0);
        justCoin = new BonusCard(0, 0, 6,  null, 0, 0);
        powerShip = new BonusCard( 0, 3, 0, "getOneShip", 0, 0);
        coinSpade = new BonusCard(0, 0, 3, "getOneSpade", 0, 0);
        coinCult = new BonusCard(0, 0, 4, "advanceOneCult", 0, 0);
        workerVicDwell = new BonusCard(0, 0, 2, null, 0, 1);
        workerVicTrading = new BonusCard(0 ,0 , 0, null, 1, 2);
        workerVicStrSanc = new BonusCard( 0, 0, 0, null, 2, 4);
        cards.add(justPriest);
        cards.add(workerPower);
        cards.add(justCoin);
        cards.add(powerShip);
        cards.add(coinSpade);
        cards.add(coinCult);
        cards.add(workerVicDwell);
        cards.add(workerVicTrading);
        cards.add(workerVicStrSanc);

    }
    public ArrayList<BonusCard> getCards(){
        return cards;
    }
}