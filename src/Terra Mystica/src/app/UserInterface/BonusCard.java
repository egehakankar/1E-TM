package app.UserInterface;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class BonusCard {
    private enum State {
        selected, nSelected, hover
    }
    private int bonusCardNumber;
    private State currentState;
    private Rectangle clickBox;
    private ArrayList<ActionListener> actionListeners;

    private Color colorS = new Color(0, 0, 0);
    private Color colorNS = new Color(100, 100, 100);
    private Color colorHover = new Color(50, 50, 50);

    private BufferedImage image;

    public BonusCard(int x, int y, int width, int height, int bonusCardNumber) {
        clickBox = new Rectangle(x, y, width, height);
        actionListeners = new ArrayList<ActionListener>();

        String imageLoc = "../images/BonusCards/bc";
        imageLoc += bonusCardNumber;
        imageLoc += ".png";

        try {
            image = ImageIO.read(getClass().getResourceAsStream(imageLoc));
        } catch (IOException e) {
            e.printStackTrace();
        }
        clickBox = new Rectangle(x, y, width, height);
        actionListeners = new ArrayList<ActionListener>();

    }

    public void update() {

    }

    public void render(Graphics2D g) {
        if (currentState == State.selected) {
            g.setColor(colorS);
            g.fill(clickBox);
        } else if (currentState == State.nSelected) {
            g.setColor(colorNS);
            g.fill(clickBox);
        } else if (currentState == State.hover) {
            g.setColor(colorHover);
            g.fill(clickBox);
        }

        g.drawImage(image, clickBox.x + 10, clickBox.y + 10, clickBox.width - 20, clickBox.height - 20, null);

    }

    public void addActionListener(ActionListener listener) {
        actionListeners.add(listener);
    }

    public BonusCard mousePressed(MouseEvent e) {
        if (clickBox.contains(e.getPoint())) {
            currentState = State.selected;
            return this;
        }
        return null;
    }

    public void mouseDragged(MouseEvent e) {
        if (clickBox.contains(e.getPoint())) {
            currentState = State.selected;
        } else {
            currentState = State.nSelected;
        }
    }

    public void mouseMoved(MouseEvent e) {
        if (clickBox.contains(e.getPoint())) {
            currentState = State.hover;
        } else {
            currentState = State.nSelected;
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (clickBox.contains(e.getPoint())) {
            for (ActionListener a : actionListeners) {
                a.actionPerformed(null);
            }
        }
        currentState = State.nSelected;
    }
    // get methods

    public int getCardNumer()
    {
        return bonusCardNumber;
    }

    public int getX()
    {
        return clickBox.x;
    }

    public int getY() {
        return clickBox.y;
    }

    public int getWidth() {
        return clickBox.width;
    }

    public int getHeight() {
        return clickBox.height;
    }

    public void changeColorExact() {
        colorNS = new Color(0, 0, 0);
        colorHover = new Color(0, 0, 0);
        colorS = new Color(0, 0, 0);
    }

    public void changeColorExact(Color c) {
        colorNS = c;
        colorHover = c;
        colorS = c;
    }

}