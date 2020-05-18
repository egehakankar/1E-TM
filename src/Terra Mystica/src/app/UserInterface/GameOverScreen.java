package app.UserInterface;

import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import app.Management.GameManager;
import app.Management.GamePlayManager;
import app.Model.Player;
import app.Model.Faction;
import app.Model.Fakirs;
import app.Model.Auren;


public class GameOverScreen extends DisplayPanel {

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = screenSize.width;
    private int height = screenSize.height;
    private BufferedImage image, image2;

    private int buttonWidth = width * 380 / 1920;
    private int spacing = height * 100 / 1080;
    private int buttonHeight = height * 120 / 1080;

    private Font titleFont = new Font("Bitstream Vera Sans", 1, width * 120 / 1920);
    private Font factionFont = new Font("Arial", 1, width * 50 / 1920);

    private String title = "Game Over";
    
    private ArrayList<Player> players;
    private ArrayList<Player> playersSorted;
    private boolean check = true;
    private int[] colorWinner = {0,0,0};


    public GameOverScreen()
    {
        super();

        try {
            image = ImageIO.read(getClass().getResourceAsStream("../images/background1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            image2 = ImageIO.read(getClass().getResourceAsStream("../images/background2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int colorBB[] = { 255, 178, 102 };
        playersSorted = new ArrayList<Player>();
        GuiButton goBackB = new GuiButton( width*20/1366, height * 900 / 1080, buttonWidth, buttonHeight, colorBB, 50);
        goBackB.setText("Menu");
        goBackB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                ArrayList<Faction> factionTemp = new ArrayList<Faction>();
                Auren auren = new Auren();
                factionTemp.add(auren);
                Fakirs fakir = new Fakirs();
                factionTemp.add(fakir);
                GameManager.setPlay(factionTemp);
                check = true;
                Display.getInstance().setCurrentPanel("Menu");
            }
        });
        add(goBackB);
    }

    @Override
    public void update() 
    {

    }

    @Override
    public void render(Graphics2D g, GameManager gM) 
    {
        
        if( check)
        {
            players = GamePlayManager.getPlayerList();
            
            // Sort players according to their victory points
            int max;
            int maxIndex;
            
            int noOfPlayer = players.size();
            System.out.println(noOfPlayer);
            int i = 0;
            while( noOfPlayer >0 )
            {
                max = 0;
                maxIndex = -1;
                for( int j = 0; j < noOfPlayer; j ++ )
                {
                    if(players.get(j).getPoints()>= max)
                    {
                        max = players.get(j).getPoints();
                        maxIndex = j;
                    }
                }
                
                playersSorted.add(players.get(maxIndex));
                players.remove(maxIndex);
                noOfPlayer--;
                i ++;
                if( i == noOfPlayer - 1)
                    break;
            }
            check = false;
            colorWinner = playersSorted.get(0).getFaction().getColor();
            
        }
        
        g.drawImage(image, 0, 0, width, height, null);

        g.setFont(titleFont);
        g.setColor(new Color(240, 255, 255));
        Rectangle2D b = g.getFontMetrics().getStringBounds(title, g);
        int widthM = (int) b.getWidth();
        g.setColor(new Color(colorWinner[0], colorWinner[1], colorWinner[2]));
        g.drawString(title, GameManager.WIDTH / 2 - widthM / 2 + 30, 160);

        g.setPaint(new Color(253, 245, 230));
        g.fillRect(((width * 580 / 1080) / 2) - 50, 210, width * 580 / 1080, height* 690 / 1080);

        g.drawImage(image2, ((width * 580 / 1080) / 2) - 60, 200, width * 580 / 1080 + 10, height * 690 / 1080 + 10, null);
        g.setColor(new Color(72, 61, 139));
        BasicStroke str = new BasicStroke(20);
        g.setStroke(str);
        g.drawRoundRect(((width * 580 / 1080) / 2) - 60, 200, width * 580 / 1080 + 10, height * 690 / 1080 + 10, 50, 50);
        
        //draw players

        int[] currentColor;
        g.setFont(factionFont);
        for( int i = 0; i < playersSorted.size() ; i ++ )
        {
            currentColor= playersSorted.get(i).getFaction().getColor();
            g.setColor(new Color(currentColor[0],currentColor[1],currentColor[2]));
            g.drawString(playersSorted.get(i).getFaction().getName() 
                + ": " + playersSorted.get(i).getPoints() + " victory points!", 
                (width * 580 / 1080) / 2 - 40, 250+spacing*i);
        }
        
        super.render(g, gM);
    }
}