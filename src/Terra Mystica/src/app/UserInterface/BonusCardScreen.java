package app.UserInterface;
import app.Model.Player;
import app.Management.GamePlayManager;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import app.Management.GameManager;

public class BonusCardScreen extends DisplayPanel {

    private static ArrayList<Player> players = GamePlayManager.getPlayerList();
    private static int noOfBonusCards = players.size();
    private int turnOfPlayer = 0;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = screenSize.width;
    private int height = screenSize.height;
    private ArrayList<Integer> bonusCardNumbers;
    private BufferedImage image;

    private ArrayList<BonusCard> bonusCards;

    //1920,1080
    private Font titleFont = new Font("Bitstream Vera Sans", 1, width*100/1920);
    private String title = "Select a bonus card for " + players.get(turnOfPlayer).getFaction().getName();
    private int buttonWidth = 150;

    private int buttonHeight = 500;

    private int spacing = 10;

    private boolean addButtons = false;

    public BonusCardScreen() {
        super();

        try {
            image = ImageIO.read(getClass().getResourceAsStream("../images/background1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g, GameManager gM) {

        g.drawImage(image, 0, 0, width, height, null);

        super.render(g, gM);

        g.setFont(titleFont);
        g.setColor(Color.white);

        Rectangle2D b = g.getFontMetrics().getStringBounds(title, g);
        int widthM = (int) b.getWidth();
        g.drawString(title, GameManager.WIDTH / 2 - widthM / 2 + 20, 120);

        players = GamePlayManager.getPlayerList();
        noOfBonusCards = players.size();

        if(!addButtons)
            addBon();

        addButtons = true;
    }

    public void addBon()
    {
        bonusCardNumbers = new ArrayList<Integer>();
        bonusCards = new ArrayList<BonusCard>();

        // creating random numbers to select bonus cards
        for(int i = 0; i < noOfBonusCards ; i ++ )
        {
            int randomNumber = (int)(Math.random()*9);

            if (bonusCardNumbers.contains(randomNumber))
                i--;
            else
                bonusCardNumbers.add(randomNumber);
        }

        int x = 80;
        int y = 150;

        // create bonus cards
        for (int i = 0; i < noOfBonusCards; i++)
            bonusCards.add(new BonusCard(x + i * buttonWidth + i * spacing, y, buttonWidth, buttonHeight,
                    bonusCardNumbers.get(i)));

        // add bonus cards
        for (int i = 0; i < noOfBonusCards; i++) {
            addBonusCard(bonusCards.get(i));
            final int a = i;
            bonusCards.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bonusCards.get(a).changeColorExact();
                    players.get(turnOfPlayer).setBonusCardNumber(bonusCards.get(a).getCardNumer());
                    players.get(turnOfPlayer).updateByBonuscardNumber();
                    turnOfPlayer ++;
                    if( players.size() == turnOfPlayer )
                        Display.getInstance().setCurrentPanel("Credits");
                }
            });
        }
    }

}