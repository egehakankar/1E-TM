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

public class Credits extends DisplayPanel
{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int WIDTH = screenSize.width;
    int HEIGHT = screenSize.height;
    //1920,1080
    private int buttonWidth = WIDTH*400/1920;
    private int spacing = HEIGHT*100/1080;
    private int buttonHeight = HEIGHT*120/1080;

    private Font titleFont = new Font("Bitstream Vera Sans", 1, WIDTH*120/1920);
    private String title = "Credits";

    private Font creditsFont = new Font("Arial", 1, WIDTH*50/1920);
    private String creditsT1 = "Ege Hakan Karaağaç";
    private String creditsT2 = "Berdan Akyürek";
    private String creditsT3 = "Ömer Olkun";
    private String creditsT4 = "Aziz Ozan Azizoğlu";
    private String creditsT5 = "Fırat Yönak";

    private BufferedImage image;

    public Credits()
    {
        try{
            image = ImageIO.read(getClass().getResourceAsStream("../images/background1.jpg"));
        }catch(IOException e)
        {
            e.printStackTrace();
        }

        int colorBB[] = {255, 178, 102};

        GuiButton goBackB = new GuiButton(30, HEIGHT*900/1080, buttonWidth, buttonHeight, colorBB, 50);	
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
    }

    @Override
    public void render(Graphics2D g, GameManager gM)
    {
        g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);

        super.render(g, gM);

		g.setFont(titleFont);
        g.setColor(new Color(240, 255, 255));
        Rectangle2D b = g.getFontMetrics().getStringBounds(title, g);
        int widthM = (int)b.getWidth();
        g.drawString(title, GameManager.WIDTH / 2 - widthM / 2 + 30, 160);

        g.setPaint(new Color(253, 245, 230));
        g.fillRect(((WIDTH*580/1080) / 2) - 50, 210, WIDTH*580/1080, HEIGHT*690/1080);

        g.setColor(new Color(72, 61, 139));
        BasicStroke str = new BasicStroke(20);
        g.setStroke(str);
        g.drawRoundRect(((WIDTH*580/1080) / 2) - 60, 200, WIDTH*580/1080 + 10, HEIGHT*690/1080 + 10, 50, 50);

        g.setFont(creditsFont);
        g.setColor(new Color(72, 61, 139));
        g.drawString(creditsT1, GameManager.WIDTH / 2 - widthM / 2, HEIGHT*320/1080 + 30);
        g.drawString(creditsT2, GameManager.WIDTH / 2 - widthM / 2, HEIGHT*320/1080 + 30+spacing);
        g.drawString(creditsT3, GameManager.WIDTH / 2 - widthM / 2, HEIGHT*320/1080 + 30+spacing*2);
        g.drawString(creditsT4, GameManager.WIDTH / 2 - widthM / 2, HEIGHT*320/1080 + 30+spacing*3);
        g.drawString(creditsT5, GameManager.WIDTH / 2 - widthM / 2, HEIGHT*320/1080 + 30+spacing*4);
	}
}