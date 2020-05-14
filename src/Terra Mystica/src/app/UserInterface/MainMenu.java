package app.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import app.Management.GameManager;

public class MainMenu extends DisplayPanel
{
    private BufferedImage image;

    private Font titleFont = new Font("Bitstream Vera Sans", 1, 200);
    private String title = "Terra Mystica";
    private int buttonWidth = 200;
    private int spacing = 80;
    private int buttonHeight = 60;

    public MainMenu()
    {
        super();

        try{
            image = ImageIO.read(getClass().getResourceAsStream("../images/background1.jpg"));
        }catch(IOException e)
        {
            e.printStackTrace();
        }

        int colorPB[] = {102, 255, 102};
        int colorHB[] = {255, 178, 102};
        int colorCB[] = {192, 192, 192};
        int colorQB[] = {255, 102, 102};

        GuiButton playB = new GuiButton(GameManager.WIDTH / 2 - buttonWidth / 2, 320, buttonWidth, buttonHeight, colorPB, 50);	
        GuiButton htpB = new GuiButton(GameManager.WIDTH / 2 - buttonWidth / 2, playB.getY() + spacing, buttonWidth, buttonHeight, colorHB, 50);
        GuiButton creditsB = new GuiButton(GameManager.WIDTH / 2 - buttonWidth / 2, htpB.getY() + spacing, buttonWidth, buttonHeight, colorCB, 50);
        GuiButton quitB = new GuiButton(GameManager.WIDTH / 2 - buttonWidth / 2, creditsB.getY() + spacing, buttonWidth, buttonHeight, colorQB, 50);

        playB.setText("Play");
        htpB.setText("How To Play");
        creditsB.setText("Credits");
        quitB.setText("Quit");

        playB.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Display.getInstance().setCurrentPanel("Selection Screen");
            }
        });

        htpB.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Display.getInstance().setCurrentPanel("How To Play");
            }
        });

        creditsB.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Display.getInstance().setCurrentPanel("Credits");
            }
        });

        quitB.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0);
            }
        });
        add(playB);
        add(htpB);
        add(creditsB);
        add(quitB);
    }

    @Override
    public void update()
    {}

	@Override
    public void render(Graphics2D g)
    {
        g.drawImage(image, 0, 0, 1920, 1080, null);

        super.render(g);
        
		g.setFont(titleFont);
        g.setColor(Color.white);

        Rectangle2D b = g.getFontMetrics().getStringBounds(title, g);
        int widthM = (int)b.getWidth();
        g.drawString(title, GameManager.WIDTH / 2 - widthM / 2, 240);
	}
}