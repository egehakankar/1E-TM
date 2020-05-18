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

public class PhaseIncome extends DisplayPanel {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int WIDTH = screenSize.width;
    int HEIGHT = screenSize.height;
    // 1920,1080

    private int buttonWidth = WIDTH * 400 / 1920;
    private int buttonHeight = HEIGHT * 120 / 1080;

    private BufferedImage image;
    
    private int playerCount = 0;

    private ArrayList<Player> players = new ArrayList<Player>();
    private int[] colorT;
    private Font titleFont = new Font("Bitstream Vera Sans", 1, WIDTH * 80 / 1920);
    private String title = "";

    private Font curFont = new Font("Bitstream Vera Sans", 1, WIDTH * 40 / 1920);
    private String curP = "";

    private boolean check = true;
    private int[][] incomes = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
    
    private int nameX = WIDTH * 100 / 1920;
    private int nameY = HEIGHT * 300 / 1920;
    private int spacing = HEIGHT * 250 / 1920;

    public PhaseIncome() {
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
                check = true;
                Display.getInstance().setCurrentPanel("MainGameScreen");
            }
        });
        add(nextB);
    }

    @Override
    public void render(Graphics2D g, GameManager gM) {

        g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);

        super.render(g, gM);

        players = GamePlayManager.getPlayerList();
        playerCount = players.size();

        if(check)
        {
            for(int a  = 0; a < playerCount; a++)
            {
                incomes[a] = GamePlayManager.receiveIncome(players.get(a));
            }
            check = false;
        }

        for(int a  = 0; a < playerCount; a++)
        {
            title = players.get(a).getFaction().getName();
            colorT = players.get(a).getFaction().getColor();

            g.setFont(titleFont);
            g.setColor(new Color(colorT[0], colorT[1], colorT[2]));

            g.drawString(title + ": ", nameX, nameY + a * spacing);
            
            Rectangle2D b = g.getFontMetrics().getStringBounds(title, g);
            int widthM = (int) b.getWidth();
 
            g.setFont(curFont);
            g.setColor(Color.white);
            curP = "Workers added: " + incomes[a][4] + " Coins added: "+ incomes[a][0] + " Priests added: " + incomes[a][1]; 
            g.drawString(curP, nameX + widthM +  WIDTH * 50 / 1920, nameY - HEIGHT * 30 / 1080 + a * spacing);
            curP = "Power 0-1: " + incomes[a][2] + " Power 1-2: "+ incomes[a][3]; 
            g.drawString(curP, nameX + widthM + WIDTH * 50 / 1920, nameY + HEIGHT * 30 / 1080 + a * spacing);

        }
    }
}