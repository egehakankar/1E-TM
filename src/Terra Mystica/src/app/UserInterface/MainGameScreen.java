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

public class MainGameScreen extends DisplayPanel
{
    private boolean checkMap = true;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int WIDTH = screenSize.width;
    int HEIGHT = screenSize.height;

    private int scoringStartWidth = WIDTH*20/1920;
    private int scoringStartHeight = HEIGHT*40/1080;
    private int scoringWidth = WIDTH*200/1920;
    private int scoringHeight = HEIGHT*100/1080;



    private Font titleFont = new Font("Bitstream Vera Sans", 1, WIDTH * 35 / 1920);
    private String title = "";

    private ArrayList<ArrayList<Terrain>> terrains;

    private ArrayList<ArrayList<ArrayList<ArrayList<Boolean>>>> allPlayerDwellings;
    private int playerCount = 0;

    private static ArrayList<Player> players = GamePlayManager.getPlayerList();
    private static int turnPlayer = 0;

    int[] colorT = players.get(turnPlayer).getFaction().getColor();

    private BufferedImage image;
    private String imageLoc;

    private BufferedImage bImage;

    private int buttonWidth = WIDTH * 200 / 1920;
    private int buttonHeight = HEIGHT * 90 / 1080;
    private int buttonSpacing = WIDTH * 5 / 1920;

    public MainGameScreen()
    {
        try {
            bImage = ImageIO.read(getClass().getResourceAsStream("../images/background2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        drawMap();

        addActionButtons();
        
    }

    @Override
    public void render(Graphics2D g, GameManager gM) {
        g.drawImage(bImage, 0, 0, WIDTH, HEIGHT, null);


        allPlayerDwellings = new ArrayList<ArrayList<ArrayList<ArrayList<Boolean>>>>();
        players = GamePlayManager.getPlayerList();
        playerCount = players.size();

        for (int a = 0; a < playerCount; a++) {
            allPlayerDwellings.add(players.get(a).getBuildings());
        }
        
        if(turnPlayer != playerCount)
        {
            colorT = players.get(turnPlayer).getFaction().getColor();
            title = players.get(turnPlayer).getFaction().getName();
        }
        
        g.setFont(titleFont);
        g.setColor(new Color(colorT[0], colorT[1], colorT[2]));

        Rectangle2D b = g.getFontMetrics().getStringBounds(title, g);
        int widthM = (int) b.getWidth();
        g.drawString(title, scoringStartWidth - widthM / 2 + WIDTH * 130 / 1920, HEIGHT * 740/1080);

        super.render(g, gM);

        drawScoringTiles(g);

        if(checkMap)
        {
            drawMap();
            checkMap = false;
        }
    }

    private void drawMap() {
        terrains = new ArrayList<ArrayList<Terrain>>();

        int colors[] = { -1, -1, -1 };

        for (int a = 0; a < 9; a++) {
            terrains.add(new ArrayList<Terrain>());
            for (int b = 0; b < 13; b++) {
                terrains.get(a).add(new Terrain(a, b, WIDTH*310/1920, HEIGHT*100/1080, colors, 0, ""));
                if (a % 2 == 0 || b != 12) {
                    addTerrain(terrains.get(a).get(b));
                    final int k = a;
                    final int g = b;
                    terrains.get(a).get(b).addActionListener(new ActionListener() 
                    {
                        @Override
                        public void actionPerformed(ActionEvent e) {
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

    private void drawScoringTiles(Graphics2D g)
    {
        for(int a = 0; a < 6; a++)
        {
            imageLoc = "../images/ScoringTiles/";
            imageLoc += GamePlayManager.getScoringTiles().get(a);
            imageLoc += ".jpg";
            try {
                image = ImageIO.read(getClass().getResourceAsStream(imageLoc));
            } catch (IOException e) {
                e.printStackTrace();
            }
    
            g.drawImage(image, scoringStartWidth, scoringStartHeight + a * scoringHeight, scoringWidth, scoringHeight, null);
        }
        
    }

    private void addActionButtons()
    {
        int[] colorPB = {100, 100, 100};
        GuiButton transformOrBuild = new GuiButton((WIDTH / 2 - buttonWidth / 2 ) - buttonWidth * 3 , HEIGHT * 930 / 1080, buttonWidth,
            buttonHeight, colorPB, 17);
        transformOrBuild.setText("Transform & Build");
        transformOrBuild.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //transformOrBuild(e);
            }
        });

        //int[] colorPB = {0, 0, 0};
        GuiButton advanceShipping = new GuiButton((WIDTH / 2 - buttonWidth / 2  + buttonSpacing) - buttonWidth * 2 , HEIGHT * 930 / 1080, buttonWidth,
            buttonHeight, colorPB, 20);
        advanceShipping.setText("Advance Shipping");
        advanceShipping.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //transformOrBuild(e);
            }
        });

        //int[] colorPB = {0, 0, 0};
        GuiButton upgradeSpade = new GuiButton((WIDTH / 2 - buttonWidth / 2 + buttonSpacing * 2) - buttonWidth * 1, HEIGHT * 930 / 1080, buttonWidth,
            buttonHeight, colorPB, 20);
        upgradeSpade.setText("Upgrade Spade");
        upgradeSpade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //transformOrBuild(e);
            }
        });

        //int[] colorPB = {0, 0, 0};
        GuiButton upgradeStructure = new GuiButton((WIDTH / 2 - buttonWidth / 2 + buttonSpacing* 3), HEIGHT * 930 / 1080, buttonWidth,
            buttonHeight, colorPB, 17);
        upgradeStructure.setText("Upgrade Structure");
        upgradeStructure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //transformOrBuild(e);
            }
        });

        //int[] colorPB = {0, 0, 0};
        GuiButton sendPriest = new GuiButton((WIDTH / 2 - buttonWidth / 2 + buttonSpacing*4) + buttonWidth * 1, HEIGHT * 930 / 1080, buttonWidth,
            buttonHeight, colorPB, 20);
        sendPriest.setText("Send Priest");
        sendPriest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //transformOrBuild(e);
            }
        });

        //int[] colorPB = {0, 0, 0};
        GuiButton powerAction = new GuiButton((WIDTH / 2 - buttonWidth / 2 + buttonSpacing*5) + buttonWidth * 2 , HEIGHT * 930 / 1080, buttonWidth,
            buttonHeight, colorPB, 20);
        powerAction.setText("Power Action");
        powerAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //transformOrBuild(e);
            }
        });

        //int[] colorPB = {0, 0, 0};
        GuiButton specialAction = new GuiButton((WIDTH / 2 - buttonWidth / 2 + buttonSpacing*6) + buttonWidth * 3, HEIGHT * 930 / 1080, buttonWidth,
            buttonHeight, colorPB, 20);
        specialAction.setText("Special Action");
        specialAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //transformOrBuild(e);
            }
        });

        //int[] colorPB = {0, 0, 0};
        GuiButton pass = new GuiButton((WIDTH / 2 - buttonWidth / 2 + buttonSpacing*7) + buttonWidth * 4, HEIGHT * 930 / 1080, buttonWidth,
            buttonHeight, colorPB, 20);
        pass.setText("Pass");
        pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //transformOrBuild(e);
            }
        });
        add(upgradeSpade);
        add(pass);
        add(upgradeStructure);
        add(specialAction);
        add(powerAction);
        add(sendPriest);
        add(advanceShipping);
        add(transformOrBuild);
    }
}