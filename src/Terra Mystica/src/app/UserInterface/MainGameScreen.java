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
import java.awt.BasicStroke;

import javax.imageio.ImageIO;

import app.Management.*;
import app.Model.*;

public class MainGameScreen extends DisplayPanel {
    private boolean checkMap = true;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int WIDTH = screenSize.width;
    int HEIGHT = screenSize.height;

    private int scoringStartWidth = WIDTH * 20 / 1920;
    private int scoringStartHeight = HEIGHT * 40 / 1080;
    private int scoringWidth = WIDTH * 200 / 1920;
    private int scoringHeight = HEIGHT * 100 / 1080;

    private int playerStartX = WIDTH * 20 / 1920;
    private int playerStartY = HEIGHT * 200 / 1080;
    private int playerStartWidth = WIDTH * 230 / 1920;
    private int playerStartHeight = HEIGHT * 100 / 1080;

    private int otherPlayerStartX = WIDTH * 1650 / 1920;
    private int otherPlayerStartY = HEIGHT * 150 / 1080;
    private int otherPlayerStartWidth = WIDTH * 230 / 1920;
    private int otherPlayerStartHeight = HEIGHT * 180 / 1080;
    private int otherPlayerSpacing = HEIGHT * 190 / 1080;

    private Font titleFont = new Font("Bitstream Vera Sans", 1, WIDTH * 27 / 1920);
    private String title = "";
    private Font powerFont = new Font("Bitstream Vera Sans", 1, WIDTH * 20 / 1920);
    private Font resFont = new Font("Bitstream Vera Sans", 1, WIDTH * 24 / 1920);

    private Font otherTitleFont = new Font("Bitstream Vera Sans", 1, WIDTH * 24 / 1920);
    private Font otherPowerFont = new Font("Bitstream Vera Sans", 1, WIDTH * 18 / 1920);
    private Font otherResFont = new Font("Bitstream Vera Sans", 1, WIDTH * 20 / 1920);

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

    private ArrayList<ArrayList<Integer>> resources;
    private int resourceSpacing = HEIGHT * 30 / 1080;
    private int otherResourceSpacing = HEIGHT * 27 / 1080;

    public MainGameScreen() {
        resources = new ArrayList<ArrayList<Integer>>();
        try {
            bImage = ImageIO.read(getClass().getResourceAsStream("../images/background2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        drawMap();

        addActionButtons();

        int[] colorCB = { 100, 130, 180 };
        GuiButton cultButton = new GuiButton(otherPlayerStartX + WIDTH * 15 / 1920, otherPlayerStartY - otherPlayerStartHeight / 2 - HEIGHT * 10 / 1080, buttonWidth, buttonHeight, colorCB,
                20);
        cultButton.setText("Cult");
        cultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkMap = true;
                Display.getInstance().setCurrentPanel("Cult Screen");
            }
        });
        add(cultButton);

    }

    @Override
    public void render(Graphics2D g, GameManager gM) {
        turnPlayer = GamePlayManager.getTurnPlayer();
        g.drawImage(bImage, 0, 0, WIDTH, HEIGHT, null);

        allPlayerDwellings = new ArrayList<ArrayList<ArrayList<ArrayList<Boolean>>>>();
        players = GamePlayManager.getPlayerList();
        playerCount = players.size();

        for (int a = 0; a < playerCount; a++) {
            allPlayerDwellings.add(players.get(a).getBuildings());
        }

        super.render(g, gM);

        drawScoringTiles(g);

        if (checkMap) {
            drawMap();
            checkMap = false;
        }
        addInfoCur(g);
        addInfoOther(g);
    }

    private void drawMap() {
        for (int a = 0; a < playerCount; a++) {
            resources.add(new ArrayList<Integer>());
            /*
             * 0: power1 1: power2 2: power3 3: key 4: priest 5: shovel 6: ship 7: coin 8:
             * worker 9: townCount 10: point 11: spade 12: spade level
             */
            resources.get(a).add(players.get(a).getPower()[0]);
            resources.get(a).add(players.get(a).getPower()[1]);
            resources.get(a).add(players.get(a).getPower()[2]);
            resources.get(a).add(players.get(a).getKeyNumber());
            resources.get(a).add(players.get(a).getPriest());
            resources.get(a).add(players.get(a).getShovel());
            resources.get(a).add(players.get(a).getShip());
            resources.get(a).add(players.get(a).getCoin());
            resources.get(a).add(players.get(a).getWorker());
            resources.get(a).add(players.get(a).getTown());
            resources.get(a).add(players.get(a).getPoints());
            resources.get(a).add(players.get(a).getSpade());
            resources.get(a).add(players.get(a).getSpadeLevel());
        }

        terrains = new ArrayList<ArrayList<Terrain>>();

        int colors[] = { -1, -1, -1 };

        for (int a = 0; a < 9; a++) {
            terrains.add(new ArrayList<Terrain>());
            for (int b = 0; b < 13; b++) {
                terrains.get(a).add(new Terrain(a, b, WIDTH * 310 / 1920, HEIGHT * 100 / 1080, colors, 0, ""));
                if (a % 2 == 0 || b != 12) {
                    addTerrain(terrains.get(a).get(b));
                    final int k = a;
                    final int g = b;
                    terrains.get(a).get(b).addActionListener(new ActionListener() {
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

    private void drawScoringTiles(Graphics2D g) {
        for (int a = 0; a < 6; a++) {
            imageLoc = "../images/ScoringTiles/";
            imageLoc += GamePlayManager.getScoringTiles().get(a);
            imageLoc += ".jpg";
            try {
                image = ImageIO.read(getClass().getResourceAsStream(imageLoc));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g.drawImage(image, scoringStartWidth, scoringStartHeight + a * scoringHeight, scoringWidth, scoringHeight,
                    null);
        }

    }

    private void addActionButtons() {
        int[] colorPB = { 100, 100, 100 };
        GuiButton transformOrBuild = new GuiButton((WIDTH / 2 - buttonWidth / 2) - buttonWidth * 3, HEIGHT * 930 / 1080,
                buttonWidth, buttonHeight, colorPB, 17);
        transformOrBuild.setText("Transform & Build");
        transformOrBuild.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // transformOrBuild(e);
            }
        });

        // int[] colorPB = {0, 0, 0};
        GuiButton advanceShipping = new GuiButton((WIDTH / 2 - buttonWidth / 2 + buttonSpacing) - buttonWidth * 2,
                HEIGHT * 930 / 1080, buttonWidth, buttonHeight, colorPB, 20);
        advanceShipping.setText("Advance Shipping");
        advanceShipping.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // transformOrBuild(e);
            }
        });

        // int[] colorPB = {0, 0, 0};
        GuiButton upgradeSpade = new GuiButton((WIDTH / 2 - buttonWidth / 2 + buttonSpacing * 2) - buttonWidth * 1,
                HEIGHT * 930 / 1080, buttonWidth, buttonHeight, colorPB, 20);
        upgradeSpade.setText("Upgrade Spade");
        upgradeSpade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // transformOrBuild(e);
            }
        });

        // int[] colorPB = {0, 0, 0};
        GuiButton upgradeStructure = new GuiButton((WIDTH / 2 - buttonWidth / 2 + buttonSpacing * 3),
                HEIGHT * 930 / 1080, buttonWidth, buttonHeight, colorPB, 17);
        upgradeStructure.setText("Upgrade Structure");
        upgradeStructure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // transformOrBuild(e);
            }
        });

        // int[] colorPB = {0, 0, 0};
        GuiButton sendPriest = new GuiButton((WIDTH / 2 - buttonWidth / 2 + buttonSpacing * 4) + buttonWidth * 1,
                HEIGHT * 930 / 1080, buttonWidth, buttonHeight, colorPB, 20);
        sendPriest.setText("Send Priest");
        sendPriest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // transformOrBuild(e);
            }
        });

        // int[] colorPB = {0, 0, 0};
        GuiButton powerAction = new GuiButton((WIDTH / 2 - buttonWidth / 2 + buttonSpacing * 5) + buttonWidth * 2,
                HEIGHT * 930 / 1080, buttonWidth, buttonHeight, colorPB, 20);
        powerAction.setText("Power Action");
        powerAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // transformOrBuild(e);
            }
        });

        // int[] colorPB = {0, 0, 0};
        GuiButton specialAction = new GuiButton((WIDTH / 2 - buttonWidth / 2 + buttonSpacing * 6) + buttonWidth * 3,
                HEIGHT * 930 / 1080, buttonWidth, buttonHeight, colorPB, 20);
        specialAction.setText("Special Action");
        specialAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // transformOrBuild(e);
            }
        });

        // int[] colorPB = {0, 0, 0};
        GuiButton pass = new GuiButton((WIDTH / 2 - buttonWidth / 2 + buttonSpacing * 7) + buttonWidth * 4,
                HEIGHT * 930 / 1080, buttonWidth, buttonHeight, colorPB, 20);
        pass.setText("Pass");
        pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GamePlayManager.addPassedPlayer( GamePlayManager.getPlayerList().get(GamePlayManager.getTurnPlayer()));
                if( GamePlayManager.getPassedPlayers().size() == GamePlayManager.getPlayerList().size() )
                {
                    GamePlayManager.setPlayerList(GamePlayManager.getPassedPlayers());
                    System.out.println(GamePlayManager.getPlayerList().size());
                    Display.getInstance().setCurrentPanel("Bonus Card Screen");
                }
                
                else
                {
                    int trp = GamePlayManager.getTurnPlayer();
                    if( trp == GamePlayManager.getPlayerList().size()-1 )
                    {
                        GamePlayManager.setTurnPlayer(0);
                        System.out.println(GamePlayManager.getPlayerList().size());
                    }
                    else
                    {
                        GamePlayManager.setTurnPlayer(trp + 1);
                    }
                }
                
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

    public void addInfoCur(Graphics2D g) {
        if (turnPlayer != playerCount) {
            colorT = players.get(turnPlayer).getFaction().getColor();
            title = players.get(turnPlayer).getFaction().getName();
        }

        g.setPaint(new Color(231, 227, 215));
        g.fillRoundRect(playerStartX, playerStartY + playerStartHeight * 4 + playerStartHeight / 2, playerStartWidth,
                playerStartHeight * 4, 100, 100);

        g.setFont(titleFont);
        g.setColor(new Color(colorT[0], colorT[1], colorT[2]));

        Rectangle2D b = g.getFontMetrics().getStringBounds(title, g);
        int widthM = (int) b.getWidth();
        int tX = scoringStartWidth - widthM / 2 + WIDTH * 115 / 1920;
        int tY = HEIGHT * 700 / 1080;
        g.drawString(title, tX, tY);

        tX = scoringStartWidth + WIDTH * 10 / 1920;
        g.setFont(resFont);
        g.setColor(Color.ORANGE);
        g.drawString("Coins: " + resources.get(turnPlayer).get(7), tX, tY + resourceSpacing);

        g.setFont(powerFont);
        g.setColor(new Color(148, 0, 211));
        g.drawString("Bowl 1: " + resources.get(turnPlayer).get(0) + "   Bowl 2: " + resources.get(turnPlayer).get(1),
                tX, tY + resourceSpacing * 2);
        g.drawString("Bowl 3: " + resources.get(turnPlayer).get(2), tX + WIDTH * 50 / 1920, tY + resourceSpacing * 3);

        g.setFont(resFont);
        g.setColor(Color.DARK_GRAY);
        g.drawString("Priests: " + resources.get(turnPlayer).get(4), tX, tY + resourceSpacing * 4);
        /*
         * 0: power1 1: power2 2: power3 3: key 4: priest ------ 5: shovel ---- not used
         * 6: ship 7: coin 8: worker 9: townCount 10: point 11: spade 12: spade level
         */
        g.setColor(Color.gray);
        g.drawString("Spades: " + resources.get(turnPlayer).get(11), tX, tY + resourceSpacing * 5);
        g.drawString("Spade Level: " + resources.get(turnPlayer).get(12), tX, tY + resourceSpacing * 6);

        g.setColor(Color.BLUE);
        g.drawString("Ship Level: " + resources.get(turnPlayer).get(6), tX, tY + resourceSpacing * 7);

        g.setColor(new Color(150, 75, 0));
        g.drawString("Workers: " + resources.get(turnPlayer).get(8), tX, tY + resourceSpacing * 8);

        g.setColor(new Color(255, 0, 0));
        g.drawString("Victory Points: " + resources.get(turnPlayer).get(10), tX, tY + resourceSpacing * 9);

        g.setColor(new Color(155, 135, 12));
        g.drawString("Keys: " + resources.get(turnPlayer).get(3), tX, tY + resourceSpacing * 10);
    }

    private void addInfoOther(Graphics2D g) {
        for (int a = 0; a < playerCount; a++) {
            if (a != turnPlayer) {
                int c = a;
                if (a != 0) {
                    c--;
                }
                colorT = players.get(a).getFaction().getColor();
                title = players.get(a).getFaction().getName();
                g.setPaint(new Color(231, 227, 215));
                g.fillRoundRect(otherPlayerStartX, otherPlayerStartY + otherPlayerSpacing * c, otherPlayerStartWidth,
                        otherPlayerStartHeight, 100, 100);

                g.setFont(otherTitleFont);
                g.setColor(new Color(colorT[0], colorT[1], colorT[2]));

                Rectangle2D b = g.getFontMetrics().getStringBounds(title, g);
                int widthM = (int) b.getWidth();
                int tX = otherPlayerStartX - widthM / 2 + WIDTH * 115 / 1920;
                int tY = HEIGHT * 180 / 1080 + otherPlayerSpacing * c;
                g.drawString(title, tX, tY);

                tX = otherPlayerStartX + WIDTH * 20 / 1920;
                ;
                g.setFont(otherResFont);
                g.setColor(Color.ORANGE);
                g.drawString("Coins: " + resources.get(a).get(7), tX, tY + otherResourceSpacing);

                g.setFont(otherPowerFont);
                g.setColor(new Color(148, 0, 211));
                g.drawString("Bowl 1: " + resources.get(a).get(0) + "   Bowl 2: " + resources.get(a).get(1), tX,
                        tY + otherResourceSpacing * 2);
                g.drawString("Bowl 3: " + resources.get(a).get(2), tX + WIDTH * 50 / 1920,
                        tY + otherResourceSpacing * 3);

                g.setFont(otherResFont);
                g.setColor(Color.DARK_GRAY);
                g.drawString("Priests: " + resources.get(a).get(4), tX, tY + otherResourceSpacing * 4);
                /*
                 * 0: power1 1: power2 2: power3 3: key 4: priest ------ 5: shovel ---- not used
                 * 6: ship 7: coin 8: worker 9: townCount 10: point 11: spade 12: spade level
                 */

                g.setColor(new Color(150, 75, 0));
                g.drawString("Workers: " + resources.get(a).get(8), tX, tY + otherResourceSpacing * 5);
            }
        }
    }
}