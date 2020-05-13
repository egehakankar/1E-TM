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
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.imageio.ImageIO;

import app.Management.GameManager;

public class SelectionScreen extends DisplayPanel
{
    TextField area;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    int WIDTH = screenSize.width;
    int HEIGHT = screenSize.height;

    private BufferedImage image;

    private Font titleFont = new Font("Bitstream Vera Sans", 1, WIDTH*150/1920);
    private String title = "Terra Mystica";
    
    private int buttonWidth = WIDTH*300/1920;
    private int buttonHeight = HEIGHT*120/1080;

    private int countButtonWidth = WIDTH*100/1920;
    private int countButtonHeight = HEIGHT*60/1080;

    public SelectionScreen(GameManager gM)
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

        GuiButton goBackB = new GuiButton(WIDTH*30/1920, HEIGHT*900/1080, buttonWidth, buttonHeight, colorBB, 50);	
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
        GuiButton playB = new GuiButton(GameManager.WIDTH - buttonWidth - 30, HEIGHT*900/1080, buttonWidth, buttonHeight, colorPB, 50);	
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
        GuiButton set2 = new GuiButton(WIDTH*760/1920, HEIGHT*350/1080, countButtonWidth, countButtonHeight, colorSB, WIDTH*50/1920);	
        GuiButton set3 = new GuiButton((WIDTH*760/1920)+countButtonWidth, HEIGHT*350/1080, countButtonWidth, countButtonHeight, colorSB, WIDTH*50/1920);	
        GuiButton set4 = new GuiButton(WIDTH*760/1920+countButtonWidth*2, HEIGHT*350/1080, countButtonWidth, countButtonHeight, colorSB, WIDTH*50/1920);	
        GuiButton set5 = new GuiButton(WIDTH*760/1920+countButtonWidth*3, HEIGHT*350/1080, countButtonWidth, countButtonHeight, colorSB, WIDTH*50/1920);

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
    public void render(Graphics2D g, GameManager gM)
    {
        g.drawImage(image, 0, 0, 1920, 1080, null);

        g.setFont(titleFont);
        g.setColor(Color.white);
        Rectangle2D b = g.getFontMetrics().getStringBounds(title, g);
        int widthM = (int)b.getWidth();
        g.drawString(title, GameManager.WIDTH / 2 - widthM / 2, 160);

        g.setPaint(new Color(253, 245, 230));
        g.fillRect(WIDTH*30/1920+buttonWidth+10, 220, WIDTH-(WIDTH*30/1920+buttonWidth)-(WIDTH-(GameManager.WIDTH - buttonWidth - 30))-25, HEIGHT-WIDTH*30/1920-buttonWidth-25);

        g.setColor(new Color(72, 61, 139));
        BasicStroke str = new BasicStroke(20);
        g.setStroke(str);
        g.drawRoundRect(WIDTH*30/1920+buttonWidth+10, 220, WIDTH-(WIDTH*30/1920+buttonWidth)-(WIDTH-(GameManager.WIDTH - buttonWidth - 30))-25, HEIGHT-WIDTH*30/1920-buttonWidth-25, 50, 50);

        super.render(g, gM);
    }
}