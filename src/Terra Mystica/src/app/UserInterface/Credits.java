package app.UserInterface;

import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import app.Management.GameManager;


public class Credits extends DisplayPanel
{
    private int buttonWidth = 400;
    private int spacing = 100;
    private int buttonHeight = 120;

    private Font titleFont = new Font("Bitstream Vera Sans", 1, 120);
    private String title = "Credits";

    private Font creditsFont = new Font("Arial", 1, 50);
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
    }

    @Override
    public void render(Graphics2D g)
    {
        g.drawImage(image, 0, 0, 1920, 1080, null);

		super.render(g);
		g.setFont(titleFont);
        g.setColor(new Color(240, 255, 255));
        Rectangle2D b = g.getFontMetrics().getStringBounds(title, g);
        int widthM = (int)b.getWidth();
        g.drawString(title, GameManager.WIDTH / 2 - widthM / 2 + 30, 160);

        g.setPaint(new Color(253, 245, 230));
        g.fillRect((GameManager.WIDTH / 2 - widthM / 2) - 50, 210, 580, 680);

        g.setColor(new Color(72, 61, 139));
        BasicStroke str = new BasicStroke(20);
        g.setStroke(str);
        g.drawRoundRect((GameManager.WIDTH / 2 - widthM / 2) - 60, 200, 600, 700, 50, 50);

        g.setFont(creditsFont);
        g.setColor(new Color(72, 61, 139));
        g.drawString(creditsT1, GameManager.WIDTH / 2 - widthM / 2, 270);
        g.drawString(creditsT2, GameManager.WIDTH / 2 - widthM / 2, 270 + spacing);
        g.drawString(creditsT3, GameManager.WIDTH / 2 - widthM / 2, 270 + spacing*2);
        g.drawString(creditsT4, GameManager.WIDTH / 2 - widthM / 2, 270 + spacing*3);
        g.drawString(creditsT5, GameManager.WIDTH / 2 - widthM / 2, 270 + spacing*4);
	}
}