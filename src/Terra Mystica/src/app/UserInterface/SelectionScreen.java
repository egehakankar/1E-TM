package app.UserInterface;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.BasicStroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.TextField;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.imageio.ImageIO;

import app.Model.*;
import app.Management.*;

public class SelectionScreen extends DisplayPanel {
    TextField area;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    int WIDTH = screenSize.width;
    int HEIGHT = screenSize.height;

    private BufferedImage image;
    private BufferedImage image2;

    private Font titleFont = new Font("Bitstream Vera Sans", 1, WIDTH * 150 / 1920);
    private String title = "Terra Mystica";

    private int buttonWidth = WIDTH * 300 / 1920;
    private int buttonHeight = HEIGHT * 120 / 1080;

    private int countButtonWidth = WIDTH * 100 / 1920;
    private int countButtonHeight = HEIGHT * 60 / 1080;

    private int factionButtonWidth = WIDTH * 70 / 1920;
    private int factionButtonHeight = HEIGHT * 50 / 1080;
    private int factionFont = WIDTH * 12 / 1920;
    private int factionButtonX = WIDTH * 470 / 1920;
    private int factionButtonY = HEIGHT * 500 / 1080;
    private int factionButtonSpacing = HEIGHT * 40 / 1080;
    private Font factionFont2 = new Font("Bitstream Vera Sans", 1, 16);
    private int factionTitleY = HEIGHT * 480 / 1080;

    private int playerCount = 0;

    private ArrayList<ArrayList<GuiButton>> buttonsA;

    private int colorGreen[] = { 112, 194, 115 };
    private int greenC = 0;
    private int colorBlue[] = { 112, 155, 219 };
    private int blueC = 0;
    private int colorRed[] = { 255, 106, 107 };
    private int redC = 0;
    private int colorYellow[] = { 250, 218, 100 };
    private int yellowC = 0;
    private int colorBrown[] = { 140, 104, 100 };
    private int brownC = 0;
    private int colorGray[] = { 192, 192, 192 };
    private int grayC = 0;
    private int colorBlack[] = { 0, 0, 0 };
    private int blackC = 0;

    private Font chooseFont = new Font("Bitstream Vera Sans", 1, WIDTH * 30 / 1920);
    private String choose = "Choose How Many Players";

    ArrayList<GuiButton> first = new ArrayList<GuiButton>();
    ArrayList<GuiButton> second = new ArrayList<GuiButton>();
    ArrayList<GuiButton> third = new ArrayList<GuiButton>();
    ArrayList<GuiButton> forth = new ArrayList<GuiButton>();
    ArrayList<GuiButton> fifth = new ArrayList<GuiButton>();

    private ArrayList<Faction> playerFactions;
    Auren auren = new Auren();
    Witches witches = new Witches();
    Alchemists alchemists = new Alchemists();
    Darklings darklings = new Darklings();
    Mermaids mermaids = new Mermaids();
    Swarmlings swarmlings = new Swarmlings();
    Engineers engineers = new Engineers();
    Dwarves dwarves = new Dwarves();
    Giants giants = new Giants();
    ChaosMagicians chaosMagicians = new ChaosMagicians();
    Halflings halflings = new Halflings();
    Cultists cultists = new Cultists();
    Fakirs fakirs = new Fakirs();
    Nomads nomads = new Nomads();

    public SelectionScreen(GameManager gM) {
        super();

        playerFactions = new ArrayList<Faction>();
        buttonsA = new ArrayList<ArrayList<GuiButton>>();

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
        int colorPB[] = { 102, 255, 102 };

        GuiButton goBackB = new GuiButton(WIDTH * 30 / 1920, HEIGHT * 900 / 1080, buttonWidth, buttonHeight, colorBB,50);
        goBackB.setText("Back");
        goBackB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.getInstance().setCurrentPanel("Menu");
            }
        });
        add(goBackB);
        GuiButton playB = new GuiButton(GameManager.WIDTH - buttonWidth - 30, HEIGHT * 900 / 1080, buttonWidth,
                buttonHeight, colorPB, 50);
        playB.setText("Play");
        playB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.setPlay(playerFactions);
                Display.getInstance().setCurrentPanel("GameStart");
            }
        });
        add(playB);

        int colorSB[] = { 192, 192, 192 };
        GuiButton set2 = new GuiButton(WIDTH * 760 / 1920, HEIGHT * 350 / 1080, countButtonWidth, countButtonHeight,
                colorSB, WIDTH * 50 / 1920);
        GuiButton set3 = new GuiButton((WIDTH * 760 / 1920) + countButtonWidth, HEIGHT * 350 / 1080, countButtonWidth,
                countButtonHeight, colorSB, WIDTH * 50 / 1920);
        GuiButton set4 = new GuiButton(WIDTH * 760 / 1920 + countButtonWidth * 2, HEIGHT * 350 / 1080, countButtonWidth,
                countButtonHeight, colorSB, WIDTH * 50 / 1920);
        GuiButton set5 = new GuiButton(WIDTH * 760 / 1920 + countButtonWidth * 3, HEIGHT * 350 / 1080, countButtonWidth,
                countButtonHeight, colorSB, WIDTH * 50 / 1920);

        set2.setText("2");
        set3.setText("3");
        set4.setText("4");
        set5.setText("5");

        addRadio(set2);
        addRadio(set3);
        addRadio(set4);
        addRadio(set5);

        set2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOption(2);
            }
        });
        set3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOption(3);
            }
        });
        set4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOption(4);
            }
        });
        set5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOption(5);
            }
        });
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics2D g, GameManager gM) {
        g.drawImage(image, 0, 0, 1920, 1080, null);

        g.setFont(titleFont);
        g.setColor(Color.white);
        Rectangle2D b = g.getFontMetrics().getStringBounds(title, g);
        int widthM = (int) b.getWidth();
        g.drawString(title, GameManager.WIDTH / 2 - widthM / 2, 160);

        g.setPaint(new Color(253, 245, 230));
        g.fillRect(WIDTH * 30 / 1920 + buttonWidth + 10, 220,
                WIDTH - (WIDTH * 30 / 1920 + buttonWidth) - (WIDTH - (GameManager.WIDTH - buttonWidth - 30)) - 25,
                HEIGHT - WIDTH * 30 / 1920 - buttonWidth - 25);

        g.drawImage(image2, WIDTH * 30 / 1920 + buttonWidth + 10, 220,
        WIDTH - (WIDTH * 30 / 1920 + buttonWidth) - (WIDTH - (GameManager.WIDTH - buttonWidth - 30)) - 25,
        HEIGHT - WIDTH * 30 / 1920 - buttonWidth - 25, null);
        g.setColor(new Color(72, 61, 139));
        BasicStroke str = new BasicStroke(20);
        g.setStroke(str);
        g.drawRoundRect(WIDTH * 30 / 1920 + buttonWidth + 10, 220,
                WIDTH - (WIDTH * 30 / 1920 + buttonWidth) - (WIDTH - (GameManager.WIDTH - buttonWidth - 30)) - 25,
                HEIGHT - WIDTH * 30 / 1920 - buttonWidth - 25, 50, 50);

        g.setFont(chooseFont);
        g.setColor(Color.black);
        Rectangle2D b2 = g.getFontMetrics().getStringBounds(choose, g);
        int widthM2 = (int) b2.getWidth();
        g.drawString(choose, GameManager.WIDTH / 2 - (HEIGHT * 400 / 1080) - widthM2 / 2,
                (HEIGHT * 350 / 1080) + (HEIGHT * 60 / 1080) / 2);

        super.render(g, gM);

        g.setFont(factionFont2);
        g.setColor(Color.black);
        for (int a = 0; a < playerCount; a++) {
            g.drawString("Player " + (a + 1), WIDTH / 2,
                    factionTitleY + a * (factionButtonSpacing + factionButtonHeight));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        for (GuiButton a : first) {
            int newColor[] = a.getColor();
            if (newColor[0] > 100) {
                newColor[0] -= 100;
                newColor[1] -= 100;
                newColor[2] -= 100;
            } else {
                newColor[0] += 100;
                newColor[1] += 100;
                newColor[2] += 100;
            }
            if (a.mousePressed(e) != null) {
                if ((greenC == 1 || greenC == 0) && a.getColor()[0] == colorGreen[0] && a.getColor()[1] == colorGreen[1]
                        && a.getColor()[2] == colorGreen[2]) {
                    playerEditor(a, newColor, greenC, 1, first);
                } else if ((blueC == 1 || blueC == 0) && a.getColor()[0] == colorBlue[0]
                        && a.getColor()[1] == colorBlue[1] && a.getColor()[2] == colorBlue[2]) {
                    playerEditor(a, newColor, blueC, 1, first);
                } else if ((redC == 1 || redC == 0) && a.getColor()[0] == colorRed[0] && a.getColor()[1] == colorRed[1]
                        && a.getColor()[2] == colorRed[2]) {
                    playerEditor(a, newColor, redC, 1, first);
                } else if ((brownC == 1 || brownC == 0) && a.getColor()[0] == colorBrown[0]
                        && a.getColor()[1] == colorBrown[1] && a.getColor()[2] == colorBrown[2]) {
                    playerEditor(a, newColor, brownC, 1, first);
                } else if ((yellowC == 1 || yellowC == 0) && a.getColor()[0] == colorYellow[0]
                        && a.getColor()[1] == colorYellow[1] && a.getColor()[2] == colorYellow[2]) {
                    playerEditor(a, newColor, yellowC, 1, first);
                } else if ((blackC == 1 || blackC == 0) && a.getColor()[0] == colorBlack[0]
                        && a.getColor()[1] == colorBlack[1] && a.getColor()[2] == colorBlack[2]) {
                    playerEditor(a, newColor, blackC, 1, first);
                } else if ((grayC == 1 || grayC == 0) && a.getColor()[0] == colorGray[0]
                        && a.getColor()[1] == colorGray[1] && a.getColor()[2] == colorGray[2]) {
                    playerEditor(a, newColor, grayC, 1, first);
                }
            }
        }
        for (GuiButton a : second) {
            int newColor[] = a.getColor();
            if (newColor[0] > 100) {
                newColor[0] -= 100;
                newColor[1] -= 100;
                newColor[2] -= 100;
            } else {
                newColor[0] += 100;
                newColor[1] += 100;
                newColor[2] += 100;
            }
            if (a.mousePressed(e) != null) {
                if ((greenC == 2 || greenC == 0) && a.getColor()[0] == colorGreen[0] && a.getColor()[1] == colorGreen[1]
                        && a.getColor()[2] == colorGreen[2]) {
                    playerEditor(a, newColor, greenC, 2, second);
                } else if ((blueC == 2 || blueC == 0) && a.getColor()[0] == colorBlue[0]
                        && a.getColor()[1] == colorBlue[1] && a.getColor()[2] == colorBlue[2]) {
                    playerEditor(a, newColor, blueC, 2, second);
                } else if ((redC == 2 || redC == 0) && a.getColor()[0] == colorRed[0] && a.getColor()[1] == colorRed[1]
                        && a.getColor()[2] == colorRed[2]) {
                    playerEditor(a, newColor, redC, 2, second);
                } else if ((brownC == 2 || brownC == 0) && a.getColor()[0] == colorBrown[0]
                        && a.getColor()[1] == colorBrown[1] && a.getColor()[2] == colorBrown[2]) {
                    playerEditor(a, newColor, brownC, 2, second);
                } else if ((yellowC == 2 || yellowC == 0) && a.getColor()[0] == colorYellow[0]
                        && a.getColor()[1] == colorYellow[1] && a.getColor()[2] == colorYellow[2]) {
                    playerEditor(a, newColor, yellowC, 2, second);
                } else if ((blackC == 2 || blackC == 0) && a.getColor()[0] == colorBlack[0]
                        && a.getColor()[1] == colorBlack[1] && a.getColor()[2] == colorBlack[2]) {
                    playerEditor(a, newColor, blackC, 2, second);
                } else if ((grayC == 2 || grayC == 0) && a.getColor()[0] == colorGray[0]
                        && a.getColor()[1] == colorGray[1] && a.getColor()[2] == colorGray[2]) {
                    playerEditor(a, newColor, grayC, 2, second);
                }
            }
        }
        for (GuiButton a : third) {
            int newColor[] = a.getColor();
            if (newColor[0] > 100) {
                newColor[0] -= 100;
                newColor[1] -= 100;
                newColor[2] -= 100;
            } else {
                newColor[0] += 100;
                newColor[1] += 100;
                newColor[2] += 100;
            }
            if (a.mousePressed(e) != null) {
                if ((greenC == 3 || greenC == 0) && a.getColor()[0] == colorGreen[0] && a.getColor()[1] == colorGreen[1]
                        && a.getColor()[2] == colorGreen[2]) {
                    playerEditor(a, newColor, greenC, 3, third);
                } else if ((blueC == 3 || blueC == 0) && a.getColor()[0] == colorBlue[0]
                        && a.getColor()[1] == colorBlue[1] && a.getColor()[2] == colorBlue[2]) {
                    playerEditor(a, newColor, blueC, 3, third);
                } else if ((redC == 3 || redC == 0) && a.getColor()[0] == colorRed[0] && a.getColor()[1] == colorRed[1]
                        && a.getColor()[2] == colorRed[2]) {
                    playerEditor(a, newColor, redC, 3, third);
                } else if ((brownC == 3 || brownC == 0) && a.getColor()[0] == colorBrown[0]
                        && a.getColor()[1] == colorBrown[1] && a.getColor()[2] == colorBrown[2]) {
                    playerEditor(a, newColor, brownC, 3, third);
                } else if ((yellowC == 3 || yellowC == 0) && a.getColor()[0] == colorYellow[0]
                        && a.getColor()[1] == colorYellow[1] && a.getColor()[2] == colorYellow[2]) {
                    playerEditor(a, newColor, yellowC, 3, third);
                } else if ((blackC == 3 || blackC == 0) && a.getColor()[0] == colorBlack[0]
                        && a.getColor()[1] == colorBlack[1] && a.getColor()[2] == colorBlack[2]) {
                    playerEditor(a, newColor, blackC, 3, third);
                } else if ((grayC == 3 || grayC == 0) && a.getColor()[0] == colorGray[0]
                        && a.getColor()[1] == colorGray[1] && a.getColor()[2] == colorGray[2]) {
                    playerEditor(a, newColor, grayC, 3, third);
                }
            }
        }
        for (GuiButton a : forth) {
            int newColor[] = a.getColor();
            if (newColor[0] > 100) {
                newColor[0] -= 100;
                newColor[1] -= 100;
                newColor[2] -= 100;
            } else {
                newColor[0] += 100;
                newColor[1] += 100;
                newColor[2] += 100;
            }
            if (a.mousePressed(e) != null) {
                if ((greenC == 4 || greenC == 0) && a.getColor()[0] == colorGreen[0] && a.getColor()[1] == colorGreen[1]
                        && a.getColor()[2] == colorGreen[2]) {
                    playerEditor(a, newColor, greenC, 4, forth);
                } else if ((blueC == 4 || blueC == 0) && a.getColor()[0] == colorBlue[0]
                        && a.getColor()[1] == colorBlue[1] && a.getColor()[2] == colorBlue[2]) {
                    playerEditor(a, newColor, blueC, 4, forth);
                } else if ((redC == 4 || redC == 0) && a.getColor()[0] == colorRed[0] && a.getColor()[1] == colorRed[1]
                        && a.getColor()[2] == colorRed[2]) {
                    playerEditor(a, newColor, redC, 4, forth);
                } else if ((brownC == 4 || brownC == 0) && a.getColor()[0] == colorBrown[0]
                        && a.getColor()[1] == colorBrown[1] && a.getColor()[2] == colorBrown[2]) {
                    playerEditor(a, newColor, brownC, 4, forth);
                } else if ((yellowC == 4 || yellowC == 0) && a.getColor()[0] == colorYellow[0]
                        && a.getColor()[1] == colorYellow[1] && a.getColor()[2] == colorYellow[2]) {
                    playerEditor(a, newColor, yellowC, 4, forth);
                } else if ((blackC == 4 || blackC == 0) && a.getColor()[0] == colorBlack[0]
                        && a.getColor()[1] == colorBlack[1] && a.getColor()[2] == colorBlack[2]) {
                    playerEditor(a, newColor, blackC, 4, forth);
                } else if ((grayC == 4 || grayC == 0) && a.getColor()[0] == colorGray[0]
                        && a.getColor()[1] == colorGray[1] && a.getColor()[2] == colorGray[2]) {
                    playerEditor(a, newColor, grayC, 4, forth);
                }
            }
        }
        for (GuiButton a : fifth) {
            int newColor[] = a.getColor();
            if (newColor[0] > 100) {
                newColor[0] -= 100;
                newColor[1] -= 100;
                newColor[2] -= 100;
            } else {
                newColor[0] += 100;
                newColor[1] += 100;
                newColor[2] += 100;
            }
            if (a.mousePressed(e) != null) {
                if ((greenC == 5 || greenC == 0) && a.getColor()[0] == colorGreen[0] && a.getColor()[1] == colorGreen[1]
                        && a.getColor()[2] == colorGreen[2]) {
                    playerEditor(a, newColor, greenC, 5, fifth);
                } else if ((blueC == 5 || blueC == 0) && a.getColor()[0] == colorBlue[0]
                        && a.getColor()[1] == colorBlue[1] && a.getColor()[2] == colorBlue[2]) {
                    playerEditor(a, newColor, blueC, 5, fifth);
                } else if ((redC == 5 || redC == 0) && a.getColor()[0] == colorRed[0] && a.getColor()[1] == colorRed[1]
                        && a.getColor()[2] == colorRed[2]) {
                    playerEditor(a, newColor, redC, 5, fifth);
                } else if ((brownC == 5 || brownC == 0) && a.getColor()[0] == colorBrown[0]
                        && a.getColor()[1] == colorBrown[1] && a.getColor()[2] == colorBrown[2]) {
                    playerEditor(a, newColor, brownC, 5, fifth);
                } else if ((yellowC == 5 || yellowC == 0) && a.getColor()[0] == colorYellow[0]
                        && a.getColor()[1] == colorYellow[1] && a.getColor()[2] == colorYellow[2]) {
                    playerEditor(a, newColor, yellowC, 5, fifth);
                } else if ((blackC == 5 || blackC == 0) && a.getColor()[0] == colorBlack[0]
                        && a.getColor()[1] == colorBlack[1] && a.getColor()[2] == colorBlack[2]) {
                    playerEditor(a, newColor, blackC, 5, fifth);
                } else if ((grayC == 5 || grayC == 0) && a.getColor()[0] == colorGray[0]
                        && a.getColor()[1] == colorGray[1] && a.getColor()[2] == colorGray[2]) {
                    playerEditor(a, newColor, grayC, 5, fifth);
                }
            }
        }
    }

    private void playerEditor(GuiButton a, int newColor[], int col, int pl, ArrayList<GuiButton> wh) {
        if (a.getText() == "Auren")
            playerFactions.set(pl - 1, auren);
        else if (a.getText() == "Witch")
            playerFactions.set(pl - 1, witches);
        else if (a.getText() == "Alchemist")
            playerFactions.set(pl - 1, alchemists);
        else if (a.getText() == "Darklings")
            playerFactions.set(pl - 1, darklings);
        else if (a.getText() == "Mermaid")
            playerFactions.set(pl - 1, mermaids);
        else if (a.getText() == "Swarmling")
            playerFactions.set(pl - 1, swarmlings);
        else if (a.getText() == "Engineer")
            playerFactions.set(pl - 1, engineers);
        else if (a.getText() == "Dwarve")
            playerFactions.set(pl - 1, dwarves);
        else if (a.getText() == "Giant")
            playerFactions.set(pl - 1, giants);
        else if (a.getText() == "Chaos")
            playerFactions.set(pl - 1, chaosMagicians);
        else if (a.getText() == "Halfling")
            playerFactions.set(pl - 1, halflings);
        else if (a.getText() == "Cultist")
            playerFactions.set(pl - 1, cultists);
        else if (a.getText() == "Fakir")
            playerFactions.set(pl - 1, fakirs);
        else if (a.getText() == "Nomad")
            playerFactions.set(pl - 1, nomads);

        if (a.getColor()[0] == colorBlack[0] && a.getColor()[1] == colorBlack[1] && a.getColor()[2] == colorBlack[2]) {
            blackC = pl;
            if (greenC == pl) {
                greenC = 0;
            } else if (redC == pl) {
                redC = 0;
            } else if (yellowC == pl) {
                yellowC = 0;
            } else if (grayC == pl) {
                grayC = 0;
            } else if (blueC == pl) {
                blueC = 0;
            } else if (brownC == pl) {
                brownC = 0;
            }
        }
        if (a.getColor()[0] == colorGreen[0] && a.getColor()[1] == colorGreen[1] && a.getColor()[2] == colorGreen[2]) {
            greenC = pl;
            if (blackC == pl) {
                blackC = 0;
            } else if (redC == pl) {
                redC = 0;
            } else if (yellowC == pl) {
                yellowC = 0;
            } else if (grayC == pl) {
                grayC = 0;
            } else if (blueC == pl) {
                blueC = 0;
            } else if (brownC == pl) {
                brownC = 0;
            }
        }
        if (a.getColor()[0] == colorBrown[0] && a.getColor()[1] == colorBrown[1] && a.getColor()[2] == colorBrown[2]) {
            brownC = pl;
            if (greenC == pl) {
                greenC = 0;
            } else if (redC == pl) {
                redC = 0;
            } else if (yellowC == pl) {
                yellowC = 0;
            } else if (grayC == pl) {
                grayC = 0;
            } else if (blueC == pl) {
                blueC = 0;
            } else if (blackC == pl) {
                blackC = 0;
            }
        }
        if (a.getColor()[0] == colorYellow[0] && a.getColor()[1] == colorYellow[1]
                && a.getColor()[2] == colorYellow[2]) {
            yellowC = pl;
            if (greenC == pl) {
                greenC = 0;
            } else if (redC == pl) {
                redC = 0;
            } else if (blackC == pl) {
                blackC = 0;
            } else if (grayC == pl) {
                grayC = 0;
            } else if (blueC == pl) {
                blueC = 0;
            } else if (brownC == pl) {
                brownC = 0;
            }
        }
        if (a.getColor()[0] == colorBlue[0] && a.getColor()[1] == colorBlue[1] && a.getColor()[2] == colorBlue[2]) {
            blueC = pl;
            if (greenC == pl) {
                greenC = 0;
            } else if (redC == pl) {
                redC = 0;
            } else if (yellowC == pl) {
                yellowC = 0;
            } else if (grayC == pl) {
                grayC = 0;
            } else if (blackC == pl) {
                blackC = 0;
            } else if (brownC == pl) {
                brownC = 0;
            }
        }
        if (a.getColor()[0] == colorGray[0] && a.getColor()[1] == colorGray[1] && a.getColor()[2] == colorGray[2]) {
            grayC = pl;
            if (greenC == pl) {
                greenC = 0;
            } else if (redC == pl) {
                redC = 0;
            } else if (yellowC == pl) {
                yellowC = 0;
            } else if (blackC == pl) {
                blackC = 0;
            } else if (blueC == pl) {
                blueC = 0;
            } else if (brownC == pl) {
                brownC = 0;
            }
        }
        if (a.getColor()[0] == colorRed[0] && a.getColor()[1] == colorRed[1] && a.getColor()[2] == colorRed[2]) {
            redC = pl;
            if (greenC == pl) {
                greenC = 0;
            } else if (blackC == pl) {
                blackC = 0;
            } else if (yellowC == pl) {
                yellowC = 0;
            } else if (grayC == pl) {
                grayC = 0;
            } else if (blueC == pl) {
                blueC = 0;
            } else if (brownC == pl) {
                brownC = 0;
            }
        }
        a.setColor(newColor);

        for (GuiButton b : wh) {
            if (b != a) {
                b.setColor(b.getColor());
            }
        }
    }

    private void addOption(int count) {
        for (ArrayList a : buttonsA) {
            ArrayList<GuiButton> temp = a;
            for (GuiButton b : temp) {
                remove(b);
            }
        }

        playerFactions = new ArrayList<Faction>();

        for (int a = 0; a < count; a++) {
            playerFactions.add(null);
        }

        buttonsA.clear();
        greenC = 0;
        brownC = 0;
        redC = 0;
        blackC = 0;
        yellowC = 0;
        blueC = 0;
        greenC = 0;

        if (count == 2) {
            playerCount = 2;

            first = addArr(0);
            second = addArr(1);
            buttonsA.add(first);
            buttonsA.add(second);

            for (ArrayList a : buttonsA) {
                ArrayList<GuiButton> temp = a;
                for (GuiButton b : temp) {
                    add(b);
                }
            }
        }
        if (count == 3) {
            playerCount = 3;

            first = addArr(0);
            second = addArr(1);
            third = addArr(2);
            buttonsA.add(first);
            buttonsA.add(second);
            buttonsA.add(third);

            for (ArrayList a : buttonsA) {
                ArrayList<GuiButton> temp = a;
                for (GuiButton b : temp) {
                    add(b);
                }
            }
        }
        if (count == 4) {
            playerCount = 4;

            first = addArr(0);
            second = addArr(1);
            third = addArr(2);
            forth = addArr(3);
            buttonsA.add(first);
            buttonsA.add(second);
            buttonsA.add(third);
            buttonsA.add(forth);

            for (ArrayList a : buttonsA) {
                ArrayList<GuiButton> temp = a;
                for (GuiButton b : temp) {
                    add(b);
                }
            }
        }
        if (count == 5) {
            playerCount = 5;

            first = addArr(0);
            second = addArr(1);
            third = addArr(2);
            forth = addArr(3);
            fifth = addArr(4);
            buttonsA.add(first);
            buttonsA.add(second);
            buttonsA.add(third);
            buttonsA.add(forth);
            buttonsA.add(fifth);

            for (ArrayList a : buttonsA) {
                ArrayList<GuiButton> temp = a;
                for (GuiButton b : temp) {
                    add(b);
                }
            }
        }

    }

    private ArrayList<GuiButton> addArr(int playerNo) {
        ArrayList<GuiButton> newButtons = new ArrayList<GuiButton>();
        GuiButton f1 = new GuiButton(factionButtonX,
                factionButtonY + factionButtonHeight * playerNo + factionButtonSpacing * playerNo, factionButtonWidth,
                factionButtonHeight, colorGreen, factionFont);
        newButtons.add(f1);
        f1.setText("Auren");
        GuiButton f2 = new GuiButton(factionButtonX + factionButtonWidth * 1,
                factionButtonY + factionButtonHeight * playerNo + factionButtonSpacing * playerNo, factionButtonWidth,
                factionButtonHeight, colorGreen, factionFont);
        newButtons.add(f2);
        f2.setText("Witch");
        GuiButton f3 = new GuiButton(factionButtonX + factionButtonWidth * 2,
                factionButtonY + factionButtonHeight * playerNo + factionButtonSpacing * playerNo, factionButtonWidth,
                factionButtonHeight, colorBlack, factionFont);
        newButtons.add(f3);
        f3.setText("Alchemist");
        GuiButton f4 = new GuiButton(factionButtonX + factionButtonWidth * 3,
                factionButtonY + factionButtonHeight * playerNo + factionButtonSpacing * playerNo, factionButtonWidth,
                factionButtonHeight, colorBlack, factionFont);
        newButtons.add(f4);
        f4.setText("Darklings");
        GuiButton f5 = new GuiButton(factionButtonX + factionButtonWidth * 4,
                factionButtonY + factionButtonHeight * playerNo + factionButtonSpacing * playerNo, factionButtonWidth,
                factionButtonHeight, colorBlue, factionFont);
        newButtons.add(f5);
        f5.setText("Mermaid");
        GuiButton f6 = new GuiButton(factionButtonX + factionButtonWidth * 5,
                factionButtonY + factionButtonHeight * playerNo + factionButtonSpacing * playerNo, factionButtonWidth,
                factionButtonHeight, colorBlue, factionFont);
        newButtons.add(f6);
        f6.setText("Swarmling");
        GuiButton f7 = new GuiButton(factionButtonX + factionButtonWidth * 6,
                factionButtonY + factionButtonHeight * playerNo + factionButtonSpacing * playerNo, factionButtonWidth,
                factionButtonHeight, colorGray, factionFont);
        newButtons.add(f7);
        f7.setText("Engineer");
        GuiButton f8 = new GuiButton(factionButtonX + factionButtonWidth * 7,
                factionButtonY + factionButtonHeight * playerNo + factionButtonSpacing * playerNo, factionButtonWidth,
                factionButtonHeight, colorGray, factionFont);
        newButtons.add(f8);
        f8.setText("Dwarve");
        GuiButton f9 = new GuiButton(factionButtonX + factionButtonWidth * 8,
                factionButtonY + factionButtonHeight * playerNo + factionButtonSpacing * playerNo, factionButtonWidth,
                factionButtonHeight, colorRed, factionFont);
        newButtons.add(f9);
        f9.setText("Giant");
        GuiButton f10 = new GuiButton(factionButtonX + factionButtonWidth * 9,
                factionButtonY + factionButtonHeight * playerNo + factionButtonSpacing * playerNo, factionButtonWidth,
                factionButtonHeight, colorRed, factionFont);
        newButtons.add(f10);
        f10.setText("Chaos");
        GuiButton f11 = new GuiButton(factionButtonX + factionButtonWidth * 10,
                factionButtonY + factionButtonHeight * playerNo + factionButtonSpacing * playerNo, factionButtonWidth,
                factionButtonHeight, colorBrown, factionFont);
        newButtons.add(f11);
        f11.setText("Halfling");
        GuiButton f12 = new GuiButton(factionButtonX + factionButtonWidth * 11,
                factionButtonY + factionButtonHeight * playerNo + factionButtonSpacing * playerNo, factionButtonWidth,
                factionButtonHeight, colorBrown, factionFont);
        newButtons.add(f12);
        f12.setText("Cultist");
        GuiButton f13 = new GuiButton(factionButtonX + factionButtonWidth * 12,
                factionButtonY + factionButtonHeight * playerNo + factionButtonSpacing * playerNo, factionButtonWidth,
                factionButtonHeight, colorYellow, factionFont);
        newButtons.add(f13);
        f13.setText("Fakir");
        GuiButton f14 = new GuiButton(factionButtonX + factionButtonWidth * 13,
                factionButtonY + factionButtonHeight * playerNo + factionButtonSpacing * playerNo, factionButtonWidth,
                factionButtonHeight, colorYellow, factionFont);
        newButtons.add(f14);
        f14.setText("Nomad");
        return newButtons;
    }
}