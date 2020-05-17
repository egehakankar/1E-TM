package app.UserInterface;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.awt.Toolkit;
import java.awt.Font;

import javax.imageio.ImageIO;

import app.Management.*;
import app.Model.*;

public class GameStartScreen extends DisplayPanel {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int WIDTH = screenSize.width;
    int HEIGHT = screenSize.height;

    private Font titleFont = new Font("Bitstream Vera Sans", 1, WIDTH * 80 / 1920);
    private String title = "";

    private ArrayList<ArrayList<Terrain>> terrains;

    private BufferedImage image;

    private ArrayList<ArrayList<ArrayList<ArrayList<Boolean>>>> allPlayerDwellings;
    private int playerCount = 0;

    private static ArrayList<Player> players;
    private static int turnPlayer;
    private int[] currentPlayerD = {0,0,0,0,0};
    private int[] dwC = {0,0,0,0,0};

    

    public GameStartScreen() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("../images/background1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        turnPlayer = 0;

        drawMap();
    }

    @Override
    public void render(Graphics2D g, GameManager gM) {
        allPlayerDwellings = new ArrayList<ArrayList<ArrayList<ArrayList<Boolean>>>>();
        players = GamePlayManager.getPlayerList();
        playerCount = players.size();

        for(int a = 0; a < playerCount; a++)
        {
            currentPlayerD[a] = players.get(a).getStartingDwellings();
        }

        for (int a = 0; a < playerCount; a++) {
            allPlayerDwellings.add(players.get(a).getBuildings());
        }

        title = players.get(turnPlayer).getFaction().getName() + " choose Dwelling Places " + (currentPlayerD[turnPlayer] - dwC[turnPlayer]);

        g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);

        g.setFont(titleFont);
        g.setColor(Color.white);

        Rectangle2D b = g.getFontMetrics().getStringBounds(title, g);
        int widthM = (int) b.getWidth();
        g.drawString(title, GameManager.WIDTH / 2 - widthM / 2, HEIGHT * 130/1080);

        super.render(g, gM);
    }

    private void drawMap() {
        terrains = new ArrayList<ArrayList<Terrain>>();

        int colors[] = { -1, -1, -1 };

        for (int a = 0; a < 9; a++) {
            terrains.add(new ArrayList<Terrain>());
            for (int b = 0; b < 13; b++) {
                terrains.get(a).add(new Terrain(a, b, WIDTH*330/1920, HEIGHT*240/1080, colors, 0, ""));
                if (a % 2 == 0 || b != 12) {
                    addTerrain(terrains.get(a).get(b));
                    final int k = a;
                    final int g = b;
                    terrains.get(a).get(b).addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            whatToDo(terrains.get(k).get(g), k, g);
                        }
                    });
                }
            }
        }

        for (int a = 0; a < playerCount; a++) {
            for (int b = 0; b < 5; b++) {
                for (int c = 0; c < 9; c++) {
                    for (int d = 0; d < 13; d++) {
                        if (c % 2 == 0 || d != 12) {
                            if (allPlayerDwellings.get(a).get(b).get(c).get(d)) {
                                if (b == 0) {
                                    terrains.get(c).get(d).setText("D");
                                } else if (b == 1) {
                                    terrains.get(c).get(d).setText("TH");
                                } else if (b == 2) {
                                    terrains.get(c).get(d).setText("TE");
                                } else if (b == 3) {
                                    terrains.get(c).get(d).setText("SA");
                                } else if (b == 4) {
                                    terrains.get(c).get(d).setText("SH");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void whatToDo(Terrain nT, int x, int y)
    {
        if(dwC[turnPlayer] < currentPlayerD[turnPlayer])
        {
            if(players.get(turnPlayer).getFaction().getColor() == nT.getColor())
            {
                int build = 0;
                if(nT.getText() == " ")
                {
                    build = 0;
                    nT.setText("D");
                    dwC[turnPlayer]++;
                }
                players.get(turnPlayer).addBuilding(build, x, y);
            }
            if(dwC[turnPlayer] == currentPlayerD[turnPlayer])
            {
                turnPlayer++;
            }
            if(turnPlayer == playerCount)
            {
                Display.getInstance().setCurrentPanel("Bonus Card Screen");
            }
        }
    }
}