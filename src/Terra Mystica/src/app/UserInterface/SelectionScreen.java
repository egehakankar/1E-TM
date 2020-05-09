package app.UserInterface;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.BasicStroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.TextField;

import javax.imageio.ImageIO;

import app.App;
import app.Management.GameManager;

public class SelectionScreen extends DisplayPanel
{
    TextField area;

    private BufferedImage image;

    private Font titleFont = new Font("Bitstream Vera Sans", 1, 150);
    private String title = "Terra Mystica";
    
    private int buttonWidth = 300;
    private int buttonHeight = 120;

    private int countButtonWidth = 100;
    private int countButtonHeight = 60;

    private boolean hop = false;

    public SelectionScreen()
    {
        super();

        try{
            image = ImageIO.read(getClass().getResourceAsStream("../images/background1.jpg"));
        }catch(IOException e)
        {
            e.printStackTrace();
        }

        int colorBB[] = {255, 178, 102};
        int colorPB[] = {102, 255, 102};

        GuiButton goBackB = new GuiButton(30, 900, buttonWidth, buttonHeight, colorBB, 50);	
        goBackB.setText("Back");
        goBackB.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Display.getInstance().setCurrentPanel("Menu");
            }
        });
        add(goBackB);

        GuiButton playB = new GuiButton(GameManager.WIDTH - buttonWidth - 30, 900, buttonWidth, buttonHeight, colorPB, 50);	
        playB.setText("Play");
        playB.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Display.getInstance().setCurrentPanel("Selection Screen");
            }
        });
        add(playB);

        int colorSB[] = {192, 192, 192};
        GuiButton set2 = new GuiButton(760, 350, countButtonWidth, countButtonHeight, colorSB, 50);	
        GuiButton set3 = new GuiButton(860, 350, countButtonWidth, countButtonHeight, colorSB, 50);	
        GuiButton set4 = new GuiButton(960, 350, countButtonWidth, countButtonHeight, colorSB, 50);	
        GuiButton set5 = new GuiButton(1060, 350, countButtonWidth, countButtonHeight, colorSB, 50);

        set2.setText("2");
        set3.setText("3");
        set4.setText("4");
        set5.setText("5");

        addRadio(set2);
        addRadio(set3);
        addRadio(set4);
        addRadio(set5);
    }

    @Override
    public void update()
    {
    }

    @Override
    public void render(Graphics2D g)
    {
        g.drawImage(image, 0, 0, 1920, 1080, null);

        g.setFont(titleFont);
        g.setColor(Color.white);
        Rectangle2D b = g.getFontMetrics().getStringBounds(title, g);
        int widthM = (int)b.getWidth();
        g.drawString(title, GameManager.WIDTH / 2 - widthM / 2, 160);

        g.setPaint(new Color(253, 245, 230));
        g.fillRect((GameManager.WIDTH / 2 - widthM / 2) - 50, 230, 1050, 780);

        g.setColor(new Color(72, 61, 139));
        BasicStroke str = new BasicStroke(20);
        g.setStroke(str);
        g.drawRoundRect((GameManager.WIDTH / 2 - widthM / 2) - 50, 220, 1050, 800, 50, 50);

        super.render(g);
    }
}