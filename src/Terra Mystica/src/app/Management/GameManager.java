package app.Management;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;

import app.UserInterface.Credits;
import app.UserInterface.Display;
import app.UserInterface.HowToPlay;
import app.UserInterface.MainMenu;
import app.UserInterface.SelectionScreen;

public class GameManager extends JFrame implements KeyListener, MouseListener, Runnable, MouseMotionListener
{
    private static final long serialVersionUID = 1L;

    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static int WIDTH = screenSize.width;
    public static int HEIGHT = screenSize.height;
    

    //Refreshes the game.
    private Thread game;

    //Checks if the game is running.
    private boolean running;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    
    private Display disp;

    public GameManager()
    {
        super("Terra Mystica");
        setLayout(new FlowLayout());

        setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		
		setVisible(true);
		setSize(WIDTH, HEIGHT);
        setLocation(0, 0);
        
        setVisible(true);

        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);

        //Creates display.
        disp = Display.getInstance();

        //Adds screens.
        disp.add("Menu", new MainMenu());
        disp.add("How To Play", new HowToPlay());
        disp.add("Credits", new Credits());
        disp.add("Selection Screen", new SelectionScreen(this));

        //Sets current screen.
        disp.setCurrentPanel("Menu"); 
    }

    private void update()
    {
        disp.update();
    }

    private void render()
    {
        //Creates a graphics2D object to use in frame.
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0, WIDTH, HEIGHT);
        disp.render(g, this);
        g.dispose();

        Graphics2D g2d = (Graphics2D) getGraphics();
		g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
    }

    //Refreshes the game.
    @Override
    public void run() 
    {
        double nsPerUpdate = 1000000000.0 / 60;

        double then = System.nanoTime();
        double unprocessed = 0;

        while(running) 
        {
            boolean shouldRender = false;
            double now = System.nanoTime();
            unprocessed += (now - then) / nsPerUpdate;
            then = now;

            while(unprocessed >= 1) 
            {
                update();
                unprocessed--;
                shouldRender = true;
            }

            if (shouldRender) 
            {
                render();
                shouldRender = false;
            }
            else 
            {
                try 
                {
                    Thread.sleep(1);
                } 
                catch(Exception e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }

    //Starts the game.
    public synchronized void start()
    {
        if(running)
        {
            return;
        }
        running = true;
        game = new Thread(this, "game");
        game.start();
    }

    //Stops the game.
    public synchronized void stop()
    {
        if(!running)
        {
            return;
        }
        running = false;
        System.exit(0);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) 
    {
        disp.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) 
    {
        disp.mouseMoved(e);
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        disp.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        disp.mouseReleased(e);
    }
}
