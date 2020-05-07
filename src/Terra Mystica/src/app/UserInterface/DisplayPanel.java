package app.UserInterface;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DisplayPanel
{
    private ArrayList<GuiButton> buttons;

    public DisplayPanel()
    {
        buttons = new ArrayList<GuiButton>();
    }

    public void update()
    {
        for(GuiButton a: buttons)
        {
            a.update();
        }
    }

    public void render(Graphics2D g)
    {
        for(GuiButton a: buttons)
        {
            a.render(g);
        }
    }

    public void add(GuiButton button)
    {
        buttons.add(button);
    }
    
    public void remove(GuiButton button)
    {
        buttons.remove(button);
    }

    public void mousePressed(MouseEvent e)
    {
        for(GuiButton a: buttons)
        {
            a.mousePressed(e);
        }
    }

    public void mouseReleased(MouseEvent e)
    {
        for(GuiButton a: buttons)
        {
            a.mouseReleased(e);
        }
    }

    public void mouseDragged(MouseEvent e)
    {
        for(GuiButton a: buttons)
        {
            a.mouseDragged(e);
        }
    }

    public void mouseMoved(MouseEvent e)
    {
        for(GuiButton a: buttons)
        {
            a.mouseMoved(e);
        }
    }
}