package app.UserInterface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.imageio.ImageIO;

import app.Management.GameManager;

public class HowToPlay extends DisplayPanel {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int WIDTH = screenSize.width;
    int HEIGHT = screenSize.height;
    private Font font = new Font("Arial", 1, WIDTH * 50 / 1920);
    // 1920,1080
    private int buttonWidth = WIDTH * 400 / 1920;
    private int spacing = HEIGHT * 100 / 1080;
    private int buttonHeight = HEIGHT * 120 / 1080;

    private Font titleFont = new Font("Bitstream Vera Sans", 1, WIDTH * 120 / 1920);
    private BufferedImage image;
    private BufferedImage ss0, ss1, ss2, ss3, ss4, ss5, ss6, ss7, ss8;
    private int page = 0;

    public HowToPlay() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("../images/background2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            ss0 = ImageIO.read(getClass().getResourceAsStream("../images/screenshots/ss0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ss1 = ImageIO.read(getClass().getResourceAsStream("../images/screenshots/ss1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ss2 = ImageIO.read(getClass().getResourceAsStream("../images/screenshots/ss2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ss3 = ImageIO.read(getClass().getResourceAsStream("../images/screenshots/ss3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ss4 = ImageIO.read(getClass().getResourceAsStream("../images/screenshots/ss4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ss5 = ImageIO.read(getClass().getResourceAsStream("../images/screenshots/ss5.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ss6 = ImageIO.read(getClass().getResourceAsStream("../images/screenshots/ss6.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ss7 = ImageIO.read(getClass().getResourceAsStream("../images/screenshots/ss7.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ss8 = ImageIO.read(getClass().getResourceAsStream("../images/screenshots/ss8.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        

        int colorBB[] = { 255, 178, 102 };

        GuiButton goBackB = new GuiButton(30, HEIGHT * 900 / 1080, buttonWidth, buttonHeight, colorBB, 50);
        goBackB.setText("Back");
        goBackB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page = 0;
                Display.getInstance().setCurrentPanel("Menu");
            }
         
        });
        add(goBackB);

        GuiButton goForwardB = new GuiButton(WIDTH-30-buttonWidth, HEIGHT * 900 / 1080, buttonWidth, buttonHeight, colorBB, 50);
        goForwardB.setText("Next");
        goForwardB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                page ++;
                if (page ==9)
                    Display.getInstance().setCurrentPanel("Menu");

            }
        });
        add (goForwardB);
    }

    @Override
    public void render(Graphics2D g, GameManager gM) {
        g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);

        g.setColor(Color.BLACK);
        g.setFont(font);

        if( page == 0)
        {
            g.drawImage(ss0, WIDTH/4,0, WIDTH/2, HEIGHT/2, null);
            g.drawString("This is the main menu of the game.", WIDTH/4, HEIGHT/2+40 );
            g.drawString("Click PLAY to start a new game.", WIDTH/4,HEIGHT/2+40+spacing );
            g.drawString("Click QUIT to leave game. ", WIDTH/4, HEIGHT/2+40+spacing*2);
        }
        else if(page == 1)
        {
            g.drawImage(ss1, WIDTH/4,0, WIDTH/2, HEIGHT/2, null);
            g.drawString("This is the selection screen of the game.", WIDTH/4, HEIGHT/2+40 );
            g.drawString("Choose number of players and factions.", WIDTH/4,HEIGHT/2+40+spacing );
            g.drawString("Click PLAY to start playing. ", WIDTH/4, HEIGHT/2+40+spacing*2);
        } 
        else if(page == 2)
        {
            g.drawImage(ss2, WIDTH/4,0, WIDTH/2, HEIGHT/2, null);
            g.drawString("This is the dwelling screen of the game.", WIDTH/4, HEIGHT/2+40 );
            g.drawString("Place dwellings for each faction.", WIDTH/4,HEIGHT/2+40+spacing );
            //g.drawString("Click NEXT to continue. ", WIDTH/4, HEIGHT/2+40+spacing*2);
        }

        else if( page == 3 )
        {
            g.drawImage(ss3, WIDTH/4,0, WIDTH/2, HEIGHT/2, null);
            g.drawString("This is the bonus card selection screen.", WIDTH/4, HEIGHT/2+40 );
            g.drawString("Choose a bonus card for each player.", WIDTH/4,HEIGHT/2+40+spacing );
            //g.drawString("Click NEXT to continue. ", WIDTH/4, HEIGHT/2+40+spacing*2);
        }

        else if (page == 4)
        {
            g.drawImage(ss4, WIDTH/4,0, WIDTH/2, HEIGHT/2, null);
            g.drawString("This is the income phase of game.", WIDTH/4, HEIGHT/2+40 );
            g.drawString("Click NEXT to continue.", WIDTH/4,HEIGHT/2+40+spacing );
            //g.drawString("Click NEXT to continue. ", WIDTH/4, HEIGHT/2+40+spacing*2);
        }

        else if( page == 5 )
        {
            g.drawImage(ss5, WIDTH/4,0, WIDTH/2, HEIGHT/2, null);
            g.drawString("This is the main gameplay screen screen.", WIDTH/4, HEIGHT/2+40 );
            g.drawString("You can reach scoring tiles, cults and actions here.", WIDTH/4,HEIGHT/2+40+spacing );
            g.drawString("Select an action to continue.", WIDTH/4, HEIGHT/2+40+spacing*2);

        }

        else if( page == 6 )
        {
            g.drawImage(ss8, WIDTH/4,0, WIDTH/2, HEIGHT/2, null);
            g.drawString("This is the cult screen.", WIDTH/4, HEIGHT/2+40 );
            g.drawString("You can see your priests and markers here.", WIDTH/4,HEIGHT/2+40+spacing );
            g.drawString("Click button to go back.", WIDTH/4, HEIGHT/2+40+spacing*2);
        }

        else if( page == 7 )
        {
            g.drawImage(ss6, WIDTH/4,0, WIDTH/2, HEIGHT/2, null);
            g.drawString("This is the Phase 3 screen.", WIDTH/4, HEIGHT/2+40 );
            g.drawString("Users receive cult bonuses here.", WIDTH/4,HEIGHT/2+40+spacing );
            g.drawString("Click button to continue.", WIDTH/4, HEIGHT/2+40+spacing*2);

        }

        else if( page == 8 )
        {
            g.drawImage(ss7, WIDTH/4,0, WIDTH/2, HEIGHT/2, null);
            g.drawString("This is the final screen of the game.", WIDTH/4, HEIGHT/2+40 );
            g.drawString("It displays player info according to points.", WIDTH/4,HEIGHT/2+40+spacing );
            g.drawString("Click MENU to go back to main menu.", WIDTH/4, HEIGHT/2+40+spacing*2);

        }


        super.render(g, gM);

    }

        
}