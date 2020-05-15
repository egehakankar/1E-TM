package app.UserInterface;

import java.awt.Dimension;
import java.awt.Toolkit;

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
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = screenSize.width;
    int height = screenSize.height;
    private BufferedImage image;
    //1920,1080 hakanin ekranı
    private Font titleFont = new Font("Bitstream Vera Sans", 1, width*200/1920);
    private String title = "Terra Mystica";
    private int buttonWidth = width/3;
    private int spacing = height*170/1080-20;
    private int buttonHeight = height*120/1080;

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
    public void render(Graphics2D g, GameManager gM)
    {
        g.drawImage(image, 0, 0, width, height, null);

        super.render(g, gM);
        
		g.setFont(titleFont);
        g.setColor(Color.white);

        Rectangle2D b = g.getFontMetrics().getStringBounds(title, g);
        int widthM = (int)b.getWidth();
        g.drawString(title, GameManager.WIDTH / 2 - widthM / 2, 240);
	}
}