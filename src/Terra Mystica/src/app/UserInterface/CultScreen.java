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
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import app.Management.GameManager;
import app.Management.GamePlayManager;
import app.Model.Player;

public class CultScreen extends DisplayPanel{

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = screenSize.width;
    private int height = screenSize.height;
    private BufferedImage image, image2, key;

    //1920,1080
    //1366x768
    private Font numberFont = new Font("Bitstream Vera Sans", 1, 50);
    private Font powerFont = new Font("Bitstream Vera Sans", 1, 30);

    private int buttonWidthB = width * 300 / 1920;
    private int buttonHeightB = height * 120 / 1080;

    private int spacing = height*150/768;
    private int spacing2 = height*40/768;
    private int cultHeight = (height-spacing*2)/4;
    private int cultWidth = width*70/1366;

    private int x = width*350/1366;
    private int y = height*100/768;

    int[][]oldValues;
    int[][] pwAdded;

    int [] cRed = {150, 0, 0};
    int [] cBlue = {112-12, 155-50, 219-50};
    int [] cBrown = {150,75,0};
    int [] cGray = {166, 154, 156};

    private Color red = new Color(cRed[0], cRed[1], cRed[2]);
    private Color blue = new Color( cBlue[0], cBlue[1], cBlue[2] );
    private Color brown = new Color ( cBrown[0], cBrown[1], cBrown[2] );
    private Color gray = new Color ( cGray[0], cGray[1], cGray[2] );
    private Color purple = new Color(189, 19, 149);
    boolean b = true;

    boolean b1 = true;
    boolean b2 = true;
    boolean b3 = true;
    boolean b4 = true;

    BasicStroke str = new BasicStroke(10);
    BasicStroke str2 = new BasicStroke(5);
    BasicStroke str3 = new BasicStroke(20);

    private GuiButton[] buttons;

    int[][] colors = {cRed,cBlue,cBrown, cGray};
    int colorBB[] = { 255, 178, 102 };

    private static ArrayList<Player> players;
    private int turnOfPlayer = 0;
    

    public CultScreen() {
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

        try {
            key = ImageIO.read(getClass().getResourceAsStream("../images/key.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //1366x768
        GuiButton goBackB = new GuiButton( width*125/1366, height-spacing , buttonWidthB, buttonHeightB, colorBB, 50);
        goBackB.setText("Back");

        goBackB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.getInstance().setCurrentPanel("MainGameScreen");
            }
        });
        add(goBackB);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g, GameManager gM) {
        players = GamePlayManager.getPlayerList();
        
        if(b)
        {
            pwAdded = new int[players.size()][4];
            oldValues = new int[players.size()][4];
            buttons = new GuiButton[16];
            int c = 0;
            //drawing buttons
            for(int i = 0; i < 4 ; i ++)
            {
                for(int j = 0; j < 4 ; j ++ )
                {
                    if( j>1)
                        y += cultHeight/2;
                    if( i %2 == 1 )
                        y -= cultHeight/2;
                    buttons[c] = new GuiButton(x+11*cultWidth+(j % 2)*cultHeight/2, y+i*(cultHeight+spacing2)+(i % 2)*cultHeight/2, cultHeight/2, cultHeight/2, colors[i], 35);
                    add(buttons[c]);
                    
                    //buttons[c].setText(""+i+j);

                    if(j == 0)
                        buttons[c].setText("3");
                    else
                        buttons[c].setText("2");

                    if( j>1)
                        y -= cultHeight/2;
                    if( i %2 == 1 )
                        y += cultHeight/2;
                    
                    
                    c++;
                }
            }
        }
        b = false;


        //title = "Select a cult for " + players.get(turnOfPlayer).getFaction().getName();
        
        g.drawImage(image, 0, 0, width, height, null);
        g.drawImage(image2, 100, 50, width-150, height-100, null);
        g.drawImage( key, 140, 80, 160,90, null );
        //temp = g
        g.setFont(numberFont);
        int[] colorOfPlayer = players.get(turnOfPlayer).getFaction().getColor();
        g.setColor( new Color(colorOfPlayer[0], colorOfPlayer[1], colorOfPlayer[2]) );
        g.drawString("" + players.get(turnOfPlayer).getKeyNumber(), 220, 180);

        g.setStroke(str3);
        g.setColor(new Color(72, 61, 139));
        g.drawRoundRect(100, 50, width-150, height-100, 50,50);
        
        
        g.setColor(Color.RED);
        g.setStroke(str);
        g.setFont(numberFont);
        int n = 0;

        //drawing cult cells
        for(int i = 0; i < 4 ; i ++)
        {
            for( int j = 0; j < 11 ; j ++ )
            {
                if(i == 0)
                    g.setColor(red);
                else if(i == 1)
                    g.setColor(blue);
                else if(i == 2)
                    g.setColor(brown);
                else if(i == 3)
                    g.setColor(gray);
                g.fillRoundRect(x+j*cultWidth, y+i*cultHeight+i*spacing2, cultWidth, cultHeight, 13, 13);
                g.setColor(Color.BLACK);
                g.drawRoundRect(x+j*cultWidth, y+i*cultHeight+i*spacing2, cultWidth, cultHeight, 13, 13);
                
                if(j == 1 || j == 4 || j == 6 || j == 8)
                {
                    Color temp = g.getColor();
                    g.setColor(purple);
                    g.drawLine( x+j*cultWidth, y+i*cultHeight+i*spacing2, x+j*cultWidth, y+i*cultHeight+i*spacing2+cultHeight);
                    g.setFont(powerFont);
                    //if( i ==0 )
                    {
                        if( j == 8 )
                            g.drawString( "1", x+j*cultWidth-cultWidth/8, y+i*cultHeight+i*spacing2-12 );
                        else if( j == 1 )
                            g.drawString( "3", x+j*cultWidth-cultWidth/8, y+i*cultHeight+i*spacing2-12 );
                        else
                            g.drawString( "2", x+j*cultWidth-cultWidth/8, y+i*cultHeight+i*spacing2-12 );
                    }
                    g.setFont(numberFont);
                    g.setColor(temp);
                }
                
                if(j == 0)
                    n = 0;
                else
                    n = cultWidth/5;
                g.drawString(""+(10-j), x+j*cultWidth + n, y+i*cultHeight+(i+2)*spacing2);

                
                
            }
            
        }
        
        for( int i = 0; i < players.size() ; i ++ )
        {
             
            int[] cl = players.get(i).getCultLevel();

            for( int j = 0; j < 4; j++ )
            {
                
                int[] tClr = players.get(i).getFaction().getColor();
                g.setColor(new Color(tClr[0],tClr[1],tClr[2]));
                if( i == 0)
                    g.fillOval((x +5)+(10-cl[j])*cultWidth,(y+5)+j*cultHeight+j*spacing2, 20,20);
                else if( i == 1 )
                    g.fillOval((x-25)+(11-cl[j])*cultWidth,(y+5)+j*cultHeight+j*spacing2, 20,20);
                else if( i == 2 )
                    g.fillOval((x +5)+(10-cl[j])*cultWidth,(y-25)+(j+1)*cultHeight+j*spacing2, 20,20);
                else if( i == 3 )
                    g.fillOval((x-25)+(11-cl[j])*cultWidth,(y-25)+(j+1)*cultHeight+j*spacing2, 20,20);
                else
                    g.fillOval(x+cultWidth/2+(10-cl[j])*cultWidth, y+cultHeight/2+j*cultHeight+j*spacing2, 20, 20);
            }
        }

        for(int k = 0; k < players.size(); k ++)
        {
            int c = 0;
            for(int i = 0; i < 4 ; i ++)
            {
                for(int j = 0; j < 4 ; j ++)
                {
                    if(players.get(k).getCultSpaces()[i][j] == 1 )
                    {
                        int [] clr = players.get(k).getFaction().getColor();
                        //int [] clr = {0,0,0};
                        buttons[c].setColor(clr);
                    }
                    c ++;
                }
            }
        }
        super.render(g, gM);
        g.setColor(Color.BLACK);
        g.setStroke(str2);
        for(int i = 0; i < 4 ; i ++)
        {
            for(int j = 0; j < 4 ; j ++ )
            {
                if( j>1)
                    y += cultHeight/2;
                if( i %2 == 1 )
                    y -= cultHeight/2;
                
                g.drawRoundRect(x+11*cultWidth+(j % 2)*cultHeight/2, y+i*(cultHeight+spacing2)+(i % 2)*cultHeight/2, cultHeight/2, cultHeight/2,13,13);
                if( j>1)
                    y -= cultHeight/2;
                if( i %2 == 1 )
                    y += cultHeight/2;
                
                
            }
        }
        
        /*
        private Color blue = new Color( 112, 155, 219 );
    private Color red = new Color( 255, 106, 107 );
    private Color brown = new Color ( 140, 104, 100 );
    private Color gray = new Color ( 192, 192, 192 );
        */
        
        
    }
}