package app.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.imageio.ImageIO;

import app.Management.GameManager;
import app.Management.GamePlayManager;
import app.Model.Player;
import app.Model.ScoringTile;
import app.Model.ScoringTiles;

public class Phase3 extends DisplayPanel {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int WIDTH = screenSize.width;
    int HEIGHT = screenSize.height;

    private int buttonWidth = WIDTH * 400 / 1920;
    private int buttonHeight = HEIGHT * 120 / 1080;

    private BufferedImage image;
    
    private int playerCount = 0;

    private ArrayList<Player> players = new ArrayList<Player>();
    private int[] colorT = {50,50,50};
    private Font titleFont = new Font("Bitstream Vera Sans", 1, WIDTH * 60 / 1920);
    private String title = "";

    private Font curFont = new Font("Bitstream Vera Sans", 1, WIDTH * 80 / 1920);
    private String curP = "";
    
    private int nameX = WIDTH * 100 / 1920;
    private int nameY = HEIGHT * 300 / 1920;
    private int spacing = HEIGHT * 250 / 1920;
    private int titleX = 100;
    private int titleY = 100;

    public Phase3() {

        try {
            image = ImageIO.read(getClass().getResourceAsStream("../images/background2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int colorPB[] = { 102, 255, 102 };

        GuiButton nextB = new GuiButton(GameManager.WIDTH - buttonWidth - 30, HEIGHT * 900 / 1080, buttonWidth,
        buttonHeight, colorPB, 50);
        nextB.setText("Next");
        nextB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.getInstance().setCurrentPanel("Bonus Card Screen");
            }
        });
        add(nextB);
    }

    
    int round;

    @Override
    public void render(Graphics2D g, GameManager gM) {
        round = GamePlayManager.getRound();
        int scoringTileNo = GamePlayManager.getScoringTiles().get(round-1);
        g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);

        super.render(g, gM);

        players = GamePlayManager.getPlayerList();
        playerCount = players.size();
        g.setFont(titleFont);
        g.setColor(new Color(colorT[0], colorT[1], colorT[2]));

        String title;
        String faction;
        int cultL;
        if( scoringTileNo == 0)
        {
            title = "Get 1 Priest for every 4 steps on Cult of Water.";
            g.drawString(title, titleX, titleY );
            for(int i = 0; i < playerCount ; i ++)
            {
                faction = players.get(i).getFaction().getName();
                int [] c = players.get(i).getFaction().getColor();
                g.setColor(new Color(c[0],c[1],c[2]));
                g.setFont(curFont);
                cultL = players.get(i).getCultLevel()[1];
                faction = faction + ": " + cultL/4 + " Priests";
                g.drawString( faction, nameX, nameY + i*spacing+spacing );
                players.get(i).updatePriest(cultL/4+players.get(i).getPriest());
            }

        }
        else if( scoringTileNo == 1)
        {
            title = "Gain  4  Power  for  every 4 steps on Cult of Fire.";
            g.drawString(title, titleX, titleY );
            for(int i = 0; i < playerCount ; i ++)
            {
                faction = players.get(i).getFaction().getName();
                int [] c = players.get(i).getFaction().getColor();
                g.setColor(new Color(c[0],c[1],c[2]));
                g.setFont(curFont);
                cultL = players.get(i).getCultLevel()[0];
                faction = faction + ": " + (int)(cultL/4)*4 + " Power";
                g.drawString( faction, nameX, nameY + i*spacing+spacing );
            }
            
        }
        else if( scoringTileNo == 2)
        {
            title = "Get 1 Spade for every 4 steps on Cult of Air.";
            g.drawString(title, titleX, titleY );
            for(int i = 0; i < playerCount ; i ++)
            {
                faction = players.get(i).getFaction().getName();
                int [] c = players.get(i).getFaction().getColor();
                g.setColor(new Color(c[0],c[1],c[2]));
                g.setFont(curFont);
                cultL = players.get(i).getCultLevel()[3];
                faction = faction + ": " + cultL/4 + " Spades";
                g.drawString( faction, nameX, nameY + i*spacing+spacing );
                players.get(i).updateSpade(cultL/4 + players.get(i).getSpade());
            }
        }
        else if( scoringTileNo == 3)
        {
            title = "Get 1 Spade for every 4 steps on Cult of Water.";
            g.drawString(title, titleX, titleY );
            for(int i = 0; i < playerCount ; i ++)
            {
                faction = players.get(i).getFaction().getName();
                int [] c = players.get(i).getFaction().getColor();
                g.setColor(new Color(c[0],c[1],c[2]));
                g.setFont(curFont);
                cultL = players.get(i).getCultLevel()[2];
                faction = faction + ": " + cultL/4 + " Spades";
                g.drawString( faction, nameX, nameY + i*spacing+spacing );
                players.get(i).updateSpade(cultL/4+players.get(i).getSpade());
            }
        }
        else if( scoringTileNo == 4)
        {
            title = "Get 1 Worker for every 2 steps on Cult of Air.";
            g.drawString(title, titleX, titleY );
            for(int i = 0; i < playerCount ; i ++)
            {
                faction = players.get(i).getFaction().getName();
                int [] c = players.get(i).getFaction().getColor();
                g.setColor(new Color(c[0],c[1],c[2]));
                g.setFont(curFont);
                cultL = players.get(i).getCultLevel()[3];
                faction = faction + ": " + cultL/2 + " Workers";
                g.drawString( faction, nameX, nameY + i*spacing+spacing );
                players.get(i).updateWorker(cultL/2+players.get(i).getWorker());
            }

        }
        else if( scoringTileNo == 5)
        {
            title = "Get 1 Worker for every 2 steps Cult of Fire.";
            g.drawString(title, titleX, titleY );
            for(int i = 0; i < playerCount ; i ++)
            {
                faction = players.get(i).getFaction().getName();
                int [] c = players.get(i).getFaction().getColor();
                g.setColor(new Color(c[0],c[1],c[2]));
                g.setFont(curFont);
                cultL = players.get(i).getCultLevel()[0];
                faction = faction + ": " + cultL/2 + " Workers";
                g.drawString( faction, nameX, nameY + i*spacing+spacing );
                players.get(i).updateWorker(cultL/2+players.get(i).getWorker());
                players.get(i).updateWorker(cultL/2 + players.get(i).getWorker());
            }

        }
        else if( scoringTileNo == 6)
        {
            title = "Get 1 Coin for every step on Cult of Earth.";
            g.drawString(title, titleX, titleY );
            for(int i = 0; i < playerCount ; i ++)
            {
                faction = players.get(i).getFaction().getName();
                int [] c = players.get(i).getFaction().getColor();
                g.setColor(new Color(c[0],c[1],c[2]));
                g.setFont(curFont);
                cultL = players.get(i).getCultLevel()[2];
                faction = faction + ": " + cultL/4 + " Coins";
                g.drawString( faction, nameX, nameY + i*spacing+spacing );
                players.get(i).updateCoin(cultL/4+players.get(i).getCoin());
            }
        }
        else if( scoringTileNo == 7)
        {
            title = "Get 1 Spade for every 4 steps on Cult of Earth.";
            g.drawString(title, titleX, titleY );
            for(int i = 0; i < playerCount ; i ++)
            {
                faction = players.get(i).getFaction().getName();
                int [] c = players.get(i).getFaction().getColor();
                g.setColor(new Color(c[0],c[1],c[2]));
                g.setFont(curFont);
                cultL = players.get(i).getCultLevel()[2];
                faction = faction + ": " + cultL/4 + " Spades";
                g.drawString( faction, nameX, nameY + i*spacing+spacing );
                players.get(i).updateSpade(cultL/4+players.get(i).getSpade());
            }
        }

    }
}