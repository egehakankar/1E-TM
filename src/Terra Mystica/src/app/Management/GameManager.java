package app.Management;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import app.UserInterface.Display;
import app.UserInterface.HowToPlay;
import app.UserInterface.MainMenu;

public class GameManager extends JPanel implements KeyListener, MouseListener, Runnable, MouseMotionListener
{
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    private Thread game;
    private boolean running;
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    
    private Display disp;

    public GameManager()
    {
        setFocusable(true);
        setPreferredSize(new DimensionUIResource(WIDTH, HEIGHT));

        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);

        disp = Display.getInstance();
        disp.add("Menu", new MainMenu());
        disp.add("How To Play", new HowToPlay());
        disp.setCurrentPanel("Menu");
    }

    private void update()
    {
        disp.update();
    }

    private void render()
    {
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0, WIDTH, HEIGHT);
        disp.render(g);
        g.dispose();

        Graphics2D g2d = (Graphics2D) getGraphics();
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();
    }

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
