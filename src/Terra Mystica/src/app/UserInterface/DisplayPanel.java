package app.UserInterface;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import app.Management.GameManager;

//Main class for all screens.
public class DisplayPanel
{
    private ArrayList<GuiButton> buttons;
    private ArrayList<GuiButton> radioButtons;
<<<<<<< HEAD
    private ArrayList<Terrain> terrains;
=======
    private ArrayList<BonusCard> bonusCards;
>>>>>>> origin/Berdan

    int black[] = {0, 0, 0};

    public DisplayPanel()
    {
        buttons = new ArrayList<GuiButton>();
        radioButtons = new ArrayList<GuiButton>();
<<<<<<< HEAD
        terrains = new ArrayList<Terrain>();
=======
        bonusCards = new ArrayList<BonusCard>();
>>>>>>> origin/Berdan
    }

    public void update()
    {
        for(GuiButton a: buttons)
        {
            a.update();
        }
        for(GuiButton a: radioButtons)
        {
            a.update();
        } 
<<<<<<< HEAD
        for(Terrain a: terrains)
        {
            a.update();
=======
        for(BonusCard b: bonusCards)
        {
            b.update();
>>>>>>> origin/Berdan
        } 
    }

    public void render(Graphics2D g, GameManager nG)
    {
        for(GuiButton a: buttons)
        {
            a.render(g);
        }
        for(GuiButton a: radioButtons)
        {
            a.render(g);
        }
<<<<<<< HEAD
        for(Terrain a: terrains)
        {
            a.render(g);
        } 
=======
        for(BonusCard b: bonusCards )
        {
            b.render(g);
        }
>>>>>>> origin/Berdan
    }

    public void add(GuiButton button)
    {
        buttons.add(button);
    }
    public void addRadio(GuiButton button)
    {
        radioButtons.add(button);
    }
<<<<<<< HEAD
    public void addTerrain(Terrain button)
    {
        terrains.add(button);
=======
    public void addBonusCard(BonusCard b)
    {
        bonusCards.add(b);
>>>>>>> origin/Berdan
    }
    
    public void remove(GuiButton button)
    {
        buttons.remove(button);
    }
    public void removeRadio(GuiButton button)
    {
        radioButtons.remove(button);
    }
<<<<<<< HEAD
    public void removeTerrain(Terrain button)
    {
        terrains.remove(button);
=======
    public void removeBonusCard( BonusCard b )
    {
        bonusCards.remove(b);
>>>>>>> origin/Berdan
    }

    public void mousePressed(MouseEvent e)
    {
        for(GuiButton a: buttons)
        {
            a.mousePressed(e);
        }

        for(BonusCard b: bonusCards)
        {
            b.mousePressed(e);
        }
        for(GuiButton a: radioButtons)
        {
            if(a.mousePressed(e) != null)
            {
                int setColor[] = {0, 0, 0};
                int color[] = a.getColor();
                a.changeColorExact(setColor);
                for(GuiButton b: radioButtons)
                {
                    if(b != a)
                    {
                        b.setColor(color);
                    }
                }
            }
        }
        for(Terrain a: terrains)
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
        for(GuiButton a: radioButtons)
        {
            a.mouseReleased(e);
        }
<<<<<<< HEAD
        for(Terrain a: terrains)
        {
            a.mouseReleased(e);
=======

        for(BonusCard b: bonusCards)
        {
            b.mouseReleased(e);
>>>>>>> origin/Berdan
        }
    }

    public void mouseDragged(MouseEvent e)
    {
        for(GuiButton a: buttons)
        {
            a.mouseDragged(e);
        }
        for(GuiButton a: radioButtons)
        {
            a.mouseDragged(e);
        }
<<<<<<< HEAD
        for(Terrain a: terrains)
        {
            a.mouseDragged(e);
=======

        for(BonusCard b: bonusCards)
        {
            b.mouseDragged(e);
>>>>>>> origin/Berdan
        }
    }

    public void mouseMoved(MouseEvent e)
    {
        for(GuiButton a: buttons)
        {
            a.mouseMoved(e);
        }
        for(GuiButton a: radioButtons)
        {
            a.mouseMoved(e);
        }
<<<<<<< HEAD
        for(Terrain a: terrains)
        {
            a.mouseMoved(e);
        }
=======
        for(BonusCard b: bonusCards)
        {
            b.mouseMoved(e);
        }

>>>>>>> origin/Berdan
    }
}