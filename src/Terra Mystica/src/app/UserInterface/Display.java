package app.UserInterface;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import app.Management.GameManager;

public class Display {
    private static Display disp;
    private static HashMap<String, DisplayPanel> panels;
    private String currentPanel = "";

    public Display() {
        panels = new HashMap<String, DisplayPanel>();
    }

    public static Display getInstance() {
        if (disp == null) {
            disp = new Display();
        }
        return disp;
    }

    public void removeAll()
    {
        panels.clear();
    }

    public void update() {
        if (panels.get(currentPanel) != null) {
            panels.get(currentPanel).update();
        }
    }

    public void render(Graphics2D g, GameManager gM) {
        if (panels.get(currentPanel) != null) {
            panels.get(currentPanel).render(g, gM);
        }
    }

    public static void remB()
    {
        panels.replace("Bonus Card Screen", new BonusCardScreen());
    }

    public void add(String name, DisplayPanel panel) {

        panels.put(name, panel);
    }
    public void reset(String name, DisplayPanel panel)
    {
        panels.remove(name,panel);
        panels.put(name,panel);
    }

    public void setCurrentPanel(String name) {
        currentPanel = name;
    }

    public void mousePressed(MouseEvent e) {
        if (panels.get(currentPanel) != null) {
            panels.get(currentPanel).mousePressed(e);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (panels.get(currentPanel) != null) {
            panels.get(currentPanel).mouseReleased(e);
        }
    }

    public void mouseDragged(MouseEvent e) {
        if (panels.get(currentPanel) != null) {
            panels.get(currentPanel).mouseDragged(e);
        }
    }

    public void mouseMoved(MouseEvent e) {
        if (panels.get(currentPanel) != null) {
            panels.get(currentPanel).mouseMoved(e);
        }
    }
}