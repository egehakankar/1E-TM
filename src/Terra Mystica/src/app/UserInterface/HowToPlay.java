package app.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import app.Management.GameManager;

public class HowToPlay extends DisplayPanel
{
    private Font titleFont = new Font("Courier New", 1, 200);
    private String title = "Terra Mystica";

    private int buttonWidth = 400;
    private int spacing = 170;
    private int buttonHeight = 120;

    public HowToPlay()
    {
        super();

        int colorPB[] = {102, 255, 102};
        int colorHB[] = {255, 178, 102};
        int colorCB[] = {192, 192, 192};
        int colorQB[] = {255, 102, 102};

        GuiButton playB = new GuiButton(GameManager.WIDTH / 2 - buttonWidth / 2, 320, buttonWidth, buttonHeight, colorPB, 50);	
        GuiButton htpB = new GuiButton(GameManager.WIDTH / 2 - buttonWidth / 2, playB.getY() + spacing, buttonWidth, buttonHeight, colorHB, 50);
        GuiButton creditsB = new GuiButton(GameManager.WIDTH / 2 - buttonWidth / 2, htpB.getY() + spacing, buttonWidth, buttonHeight, colorCB, 50);
        GuiButton quitB = new GuiButton(GameManager.WIDTH / 2 - buttonWidth / 2, creditsB.getY() + spacing, buttonWidth, buttonHeight, colorQB, 50);

        playB.setText("Play");
        htpB.setText("How To Playaaa");
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
    {  

    }

	@Override
    public void render(Graphics2D g, GameManager gM)
    {
		super.render(g, gM);
		g.setFont(titleFont);
        g.setColor(Color.black);
        
        Rectangle2D b = g.getFontMetrics().getStringBounds(title, g);
        int widthM = (int)b.getWidth();
		g.drawString(title, GameManager.WIDTH / 2 - widthM / 2, 240);
	}
}