package app.UserInterface;

import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Toolkit;

import java.awt.font.TextLayout;

public class Terrain {
    private enum State {
        RELEASED, HOVER, PRESSED
    }

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    int WIDTH = screenSize.width;
    int HEIGHT = screenSize.height;

    private int fontSize = 30;
    private Font font = new Font("Courier New", 1, fontSize);
    private String text = " ";

    private State currentState = State.RELEASED;
    private ArrayList<ActionListener> actionListeners;

    private Color released;
    private Color hover;
    private Color pressed;
    private int color0;
    private int color1;
    private int color2;

    private int row;
    private int col;

    private int centX = 0;
    private int centY = 0;

    private int centerXOf00;
    private int centerYOf00;

    private int dimension = WIDTH*60/1920;
    private int h = (int) (dimension * (Math.sqrt(3)));

    private Rectangle clickBox;

    private int colorGreen[] = { 112, 194, 115 };
    private int colorBlue[] = { 112, 155, 219 };
    private int colorRed[] = { 255, 106, 107 };
    private int colorYellow[] = { 250, 218, 100 };
    private int colorBrown[] = { 140, 104, 100 };
    private int colorGray[] = { 192, 192, 192 };
    private int colorBlack[] = { 0, 0, 0 };

    private int[][][] defColors = {
            { colorBrown, colorGray, colorGreen, colorBlue, colorYellow,
                    colorRed, colorBrown, colorBlack, colorRed, colorGreen,
                    colorBlue, colorRed, colorBlack },
            { colorYellow, { 0, 0, 128 }, { 0, 0, 128 }, colorBrown, colorBlack, { 0, 0, 128 },
                    { 0, 0, 128 }, colorYellow, colorBlack, { 0, 0, 128 }, { 0, 0, 128 }, colorYellow,
                    { -1, -1, -1 } },
            { { 0, 0, 128 }, { 0, 0, 128 }, colorBlack, { 0, 0, 128 }, colorGray, { 0, 0, 128 },
                    colorGreen, { 0, 0, 128 }, colorGreen, { 0, 0, 128 }, colorGray,
                    { 0, 0, 128 }, { 0, 0, 128 } },
            { colorGreen, colorBlue, colorYellow, { 0, 0, 128 }, { 0, 0, 128 }, colorRed,
                    colorBlue, { 0, 0, 128 }, colorRed, { 0, 0, 128 }, colorRed,
                    colorBrown, { -1, -1, -1 } },
            { colorBlack, colorBrown, colorRed, colorBlue, colorBlack, colorBrown,
                    colorGray, colorYellow, { 0, 0, 128 }, { 0, 0, 128 }, colorGreen, colorBlack,
                    colorBlue },
            { colorGray, colorGreen, { 0, 0, 128 }, { 0, 0, 128 }, colorYellow, colorGreen,
                    { 0, 0, 128 }, { 0, 0, 128 }, { 0, 0, 128 }, colorBrown, colorGray,
                    colorBrown, { -1, -1, -1 } },
            { { 0, 0, 128 }, { 0, 0, 128 }, { 0, 0, 128 }, colorGray, { 0, 0, 128 }, colorRed,
                    { 0, 0, 128 }, colorGreen, { 0, 0, 128 }, colorYellow, colorBlack, colorBlue,
                    colorYellow },
            { colorYellow, colorBlue, colorBrown, { 0, 0, 128 }, { 0, 0, 128 }, { 0, 0, 128 },
                    colorBlue, colorBlack, { 0, 0, 128 }, colorGray, colorBrown,
                    colorGray, { -1, -1, -1 } },
            { colorRed, colorBlack, colorGray, colorBlue, colorRed,
                    colorGreen, colorYellow, colorBrown, colorGray, { 0, 0, 128 },
                    colorBlue, colorGreen, colorRed } };

    public Terrain(int x, int y, int centerXO, int centerY0, int color[], int fontSize, String b) {
        actionListeners = new ArrayList<ActionListener>();
        row = x;
        col = y;

        centerXOf00 = centerXO;
        centerYOf00 = centerY0;

        if (row % 2 == 0) {
            centX = centerXOf00 + (h * col);
            centY = centerYOf00 + (dimension * row * 3 / 2);
        } else {
            centX = centerXOf00 + (h / 2) + (h * col);
            centY = centerYOf00 + (3 * dimension / 2) + ((row - 1) / 2 * dimension * 3);
        }

        if (color[0] != -1) {
            if (color[0] < 100 || color[1] < 100 || color[2] < 100) {
                color0 = color[0];
                color1 = color[1];
                color2 = color[2];

                released = new Color(color[0], color[1], color[2]);
                hover = new Color(color[0] + 50, color[1] + 50, color[2] + 50);
                pressed = new Color(color[0] + 100, color[1] + 100, color[2] + 100);
            } else {
                color0 = color[0];
                color1 = color[1];
                color2 = color[2];

                released = new Color(color[0], color[1], color[2]);
                hover = new Color(color[0] - 50, color[1] - 50, color[2] - 50);
                pressed = new Color(color[0] - 100, color[1] - 100, color[2] - 100);
            }
        } else {
            if (defColors[x][y][0] != -1) {
                color0 = defColors[x][y][0];
                color1 = defColors[x][y][1];
                color2 = defColors[x][y][2];
                if (color0 < 100 || color1 < 100 || color2 < 100) {
                    released = new Color(color0, color1, color2);
                    hover = new Color(color0 + 50, color1 + 50, color2 + 50);
                    pressed = new Color(color0 + 100, color1 + 100, color2 + 100);
                } else {
                    released = new Color(color0, color1, color2);
                    hover = new Color(color0 - 50, color1 - 50, color2 - 50);
                    pressed = new Color(color0 - 100, color1 - 100, color2 - 100);
                }
            }
        }
        clickBox = new Rectangle(centX - dimension / 2, centY - dimension / 2, dimension, dimension);

        if(b != "")
        {
            text = b;
        }
    }

    public void update() {

    }

    public void render(Graphics2D g) {
        int[] nx = { centX, centX + (h / 2), centX + (h / 2), centX, centX - (h / 2), centX - (h / 2) };
        int[] ny = { centY - dimension, centY - (dimension / 2), centY + (dimension / 2), centY + dimension,
                centY + (dimension / 2), centY - (dimension / 2) };

        if (currentState == State.RELEASED) {
            g.setColor(released);
            g.fillPolygon(nx, ny, 6);
        } else if (currentState == State.HOVER) {
            g.setColor(hover);
            g.fillPolygon(nx, ny, 6);
        } else if (currentState == State.PRESSED) {
            g.setColor(pressed);
            g.fillPolygon(nx, ny, 6);
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

    public String getText()
    {
        return text;
    }

    public void setText(String newT)
    {
        text = newT;
    }

    public String getColor()
    {
        if(color1 == colorGreen[1])
        {
            return "Green";
        }
        else if(color1 == colorBlue[1])
        {
            return "Blue";
        }
        else if(color1 == colorRed[1])
        {
            return "Red";
        }
        else if(color1 == colorBlack[1])
        {
            return "Black";
        }
        else if(color1 == colorYellow[1])
        {
            return "Yellow";
        }
        else if(color1 == colorBrown[1])
        {
            return "Brown";
        }
        else
        {
            return "Gray";
        }

    }

    public void addActionListener(ActionListener listener) {
        actionListeners.add(listener);
    }

    public Terrain mousePressed(MouseEvent e) {
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
}