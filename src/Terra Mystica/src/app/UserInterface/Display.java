package app.UserInterface;

import java.awt.Graphics2D;
import java.util.HashMap;
import java.awt.event.*;

public class Display
{
    private static Display disp;
    private HashMap<String, DisplayPanel> panels;
    private String currentPanel = "";


    public Display()
    {
        panels = new HashMap<String, DisplayPanel>();
    }

    public static Display getInstance()
    {
        if(disp == null)
        {
            disp = new Display();
        }
        return disp;
    }

    public void update()
    {
        if(panels.get(currentPanel) != null)
        {
            panels.get(currentPanel).update();
        }
    }

    public void render(Graphics2D g)
    {
        if(panels.get(currentPanel) != null)
        {
            panels.get(currentPanel).render(g);
        }
    }

    public void add(String name, DisplayPanel panel)
    {
        panels.put(name, panel);
    }

    public void setCurrentPanel(String name)
    {
        currentPanel = name;
    }

    public void mousePressed(MouseEvent e)
    {
        if(panels.get(currentPanel) != null)
        {
            panels.get(currentPanel).mousePressed(e);
        }
    }

    public void mouseReleased(MouseEvent e)
    {
        if(panels.get(currentPanel) != null)
        {
            panels.get(currentPanel).mouseReleased(e);
        }
    }

    public void mouseDragged(MouseEvent e)
    {
        if(panels.get(currentPanel) != null)
        {
            panels.get(currentPanel).mouseDragged(e);
        }
    }

    public void mouseMoved(MouseEvent e)
    {
        if(panels.get(currentPanel) != null)
        {
            panels.get(currentPanel).mouseMoved(e);
        }
    }
}