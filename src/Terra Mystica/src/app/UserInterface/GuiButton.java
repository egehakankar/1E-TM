package app.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class GuiButton {
    private enum State {
        RELEASED, HOVER, PRESSED
    }

    private State currentState = State.RELEASED;
    private Rectangle clickBox;
    private ArrayList<ActionListener> actionListeners;
    private String text = " ";

    private Color released;
    private Color hover;
    private Color pressed;
    private Font font;
    private int fontSize;
    private int color0;
    private int color1;
    private int color2;

    public GuiButton(int x, int y, int width, int height, int color[], int fontSize) {
        
        if (color[0] != -1) {
            clickBox = new Rectangle(x, y, width, height);
            actionListeners = new ArrayList<ActionListener>();

            this.fontSize = fontSize;

            if (color[0] < 100 || color[1] < 100 || color[2] < 100) {
                this.color0 = color[0];
                this.color1 = color[1];
                this.color2 = color[2];

                released = new Color(color[0], color[1], color[2]);
                hover = new Color(color[0] + 50, color[1] + 50, color[2] + 50);
                pressed = new Color(color[0] + 100, color[1] + 100, color[2] + 100);
            } else {
                this.color0 = color[0];
                this.color1 = color[1];
                this.color2 = color[2];

                released = new Color(color[0], color[1], color[2]);
                hover = new Color(color[0] - 50, color[1] - 50, color[2] - 50);
                pressed = new Color(color[0] - 100, color[1] - 100, color[2] - 100);
            }

            font = new Font("Courier New", 1, fontSize);
        }
    }

    public void update() {

    }

    public void render(Graphics2D g) {
        if (currentState == State.RELEASED) {
            g.setColor(released);
            g.fill(clickBox);
        } else if (currentState == State.HOVER) {
            g.setColor(hover);
            g.fill(clickBox);
        } else if (currentState == State.PRESSED) {
            g.setColor(pressed);
            g.fill(clickBox);
        }
        g.setColor(Color.white);
        g.setFont(font);

        Rectangle2D b = g.getFontMetrics().getStringBounds(text, g);
        TextLayout t = new TextLayout(text, font, g.getFontRenderContext());
        int widthM = (int) b.getWidth();
        int heightH = (int) t.getBounds().getHeight();

        g.drawString(text, clickBox.x + clickBox.width / 2 - widthM / 2,
                clickBox.y + clickBox.height / 2 + heightH / 2);
    }

    public void addActionListener(ActionListener listener) {
        actionListeners.add(listener);
    }

    public GuiButton mousePressed(MouseEvent e) {
        if (clickBox.contains(e.getPoint())) {
            currentState = State.PRESSED;
            return this;
        }
        return null;
    }

    public void mouseDragged(MouseEvent e) {
        if (clickBox.contains(e.getPoint())) {
            currentState = State.PRESSED;
        } else {
            currentState = State.RELEASED;
        }
    }

    public void mouseMoved(MouseEvent e) {
        if (clickBox.contains(e.getPoint())) {
            currentState = State.HOVER;
        } else {
            currentState = State.RELEASED;
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (clickBox.contains(e.getPoint())) {
            for (ActionListener a : actionListeners) {
                a.actionPerformed(null);
            }
        }
        currentState = State.RELEASED;
    }

    public int getX() {
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

    public int getFontSize() {
        return fontSize;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public void changeColorExact(int setColor[]) {
        released = new Color(setColor[0], setColor[1], setColor[2]);
        hover = new Color(setColor[0], setColor[1], setColor[2]);
        pressed = new Color(setColor[0], setColor[1], setColor[2]);
    }

    public void setColor(int color[]) {
        if (color[0] < 100 || color[1] < 100 || color[2] < 100) {
            released = new Color(color[0], color[1], color[2]);
            hover = new Color(color[0] + 50, color[1] + 50, color[2] + 50);
            pressed = new Color(color[0] + 100, color[1] + 100, color[2] + 100);
        } else {
            released = new Color(color[0], color[1], color[2]);
            hover = new Color(color[0] - 50, color[1] - 50, color[2] - 50);
            pressed = new Color(color[0] - 100, color[1] - 100, color[2] - 100);
        }
    }

    public int[] getColor() {
        int color[] = { color0, color1, color2 };
        return color;
    }
}