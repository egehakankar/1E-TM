package app.UserInterface;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import app.Management.GameManager;

//Main class for all screens.
public class DisplayPanel {
    protected ArrayList<GuiButton> buttons;
    private ArrayList<GuiButton> radioButtons;
    private ArrayList<Terrain> terrains;
    private ArrayList<BonusCard> bonusCards;

    int black[] = { 0, 0, 0 };

    public DisplayPanel() {
        buttons = new ArrayList<GuiButton>();
        radioButtons = new ArrayList<GuiButton>();
        bonusCards = new ArrayList<BonusCard>();
        terrains = new ArrayList<Terrain>();

    }

    public void update() {
        for (GuiButton a : buttons) {
            a.update();
        }
        for (GuiButton a : radioButtons) {
            a.update();
        }
        for (BonusCard b : bonusCards) {
            b.update();
        }
    }

    public void render(Graphics2D g, GameManager nG) {
        for( int i = 0; i < buttons.size(); i++ )
        {
            buttons.get(i).render(g);
        }
        for (GuiButton a : radioButtons) {
            a.render(g);
        }
        for (Terrain a : terrains) {
            a.render(g);
        }
        for (BonusCard b : bonusCards) {
            b.render(g);
        }
    }

    public void add(GuiButton button) {
        buttons.add(button);
    }

    public void addRadio(GuiButton button) {
        radioButtons.add(button);
    }

    public void addTerrain(Terrain button) {
        terrains.add(button);
    }

    public void addBonusCard(BonusCard b) {
        bonusCards.add(b);
    }

    public void remove(GuiButton button) {
        for( int i = 0; i < buttons.size(); i++ )
        {
            if(buttons.get(i).equals(button))
            {
                buttons.remove(button);
            }  
        }
        
    }

    public void removeRadio(GuiButton button) {
        radioButtons.remove(button);
    }

    public void removeTerrain(Terrain button) {
        terrains.remove(button);
    }

    public void removeBonusCard(BonusCard b) {
        bonusCards.remove(b);
    }

    public void mousePressed(MouseEvent e) {
        for (GuiButton a : buttons) {
            a.mousePressed(e);
        }

        for (BonusCard b : bonusCards) {
            b.mousePressed(e);
        }
        for (GuiButton a : radioButtons) {
            if (a.mousePressed(e) != null) {
                int setColor[] = { 0, 0, 0 };
                int color[] = a.getColor();
                a.changeColorExact(setColor);
                for (GuiButton b : radioButtons) {
                    if (b != a) {
                        b.setColor(color);
                    }
                }
            }
        }
        for (Terrain a : terrains) {
            a.mousePressed(e);
        }
    }

    public void mouseReleased(MouseEvent e) {
        for( int i = 0; i < buttons.size(); i++ )
        {
            buttons.get(i).mouseReleased(e);
        }
        for (GuiButton a : radioButtons) {
            a.mouseReleased(e);
        }
        for (Terrain a : terrains) {
            a.mouseReleased(e);
        }
        for (BonusCard b : bonusCards) {
            b.mouseReleased(e);
        }
    }

    public void mouseDragged(MouseEvent e) {
        for (GuiButton a : buttons) {
            a.mouseDragged(e);
        }
        for (GuiButton a : radioButtons) {
            a.mouseDragged(e);
        }
        for (Terrain a : terrains) {
            a.mouseDragged(e);
        }

        for (BonusCard b : bonusCards) {
            b.mouseDragged(e);
        }
    }

    public void mouseMoved(MouseEvent e) {
        for (GuiButton a : buttons) {
            a.mouseMoved(e);
        }
        for (GuiButton a : radioButtons) {
            a.mouseMoved(e);
        }
        for (Terrain a : terrains) {
            a.mouseMoved(e);
        }
        for (BonusCard b : bonusCards) {
            b.mouseMoved(e);
        }

    }
}