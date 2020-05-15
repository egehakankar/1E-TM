package app.UserInterface;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;

public class Terrain {
    private enum State {
        RELEASED, HOVER, PRESSED
    }

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

    private int centerXOf00 = 200;
    private int centerYOf00 = 100;
    private int dimension = 50;
    private int h = (int) (dimension * (Math.sqrt(3)));

    private Rectangle clickBox;

    private Integer[][][] defColors = {
            { { 140, 104, 100 }, { 192, 192, 192 }, { 112, 194, 115 }, { 112, 155, 219 }, { 250, 218, 100 },
                    { 255, 106, 107 }, { 140, 104, 100 }, { 0, 0, 0 }, { 255, 106, 107 }, { 112, 194, 115 },
                    { 112, 155, 219 }, { 255, 106, 107 }, { 0, 0, 0 } },
            { { 250, 218, 100 }, { 0, 0, 128 }, { 0, 0, 128 }, { 140, 104, 100 }, { 0, 0, 0 },
                    { 0, 0, 128 }, { 0, 0, 128 }, { 250, 218, 100 }, { 0, 0, 0 }, { 0, 0, 128 },
                    { 0, 0, 128 }, { 250, 218, 100 }, { null, null, null } },
            { { 0, 0, 128 }, { 0, 0, 128 }, { 0, 0, 0 }, { 0, 0, 128 }, { 192, 192, 192 },
                    { 0, 0, 128 }, { 112, 194, 115 }, { 0, 0, 128 }, { 112, 194, 115 }, { 0, 0, 128 },
                    { 192, 192, 192 }, { 0, 0, 128 }, { 0, 0, 128 } },
            { { 112, 194, 115 }, { 112, 155, 219 }, { 250, 218, 100 }, { 0, 0, 128 }, { 0, 0, 128 },
                    { 255, 106, 107 }, { 112, 155, 219 }, { 0, 0, 128 }, { 255, 106, 107 }, { 0, 0, 128 },
                    { 255, 106, 107 }, { 140, 104, 100 }, { null, null, null } },
            { { 0, 0, 0 }, { 140, 104, 100 }, { 255, 106, 107 }, { 112, 155, 219 }, { 0, 0, 0 }, { 140, 104, 100 },
                    { 192, 192, 192 }, { 250, 218, 100 }, { 0, 0, 128 }, { 0, 0, 128 }, { 112, 194, 115 },
                    { 0, 0, 0 }, { 112, 155, 219 } },
            { { 192, 192, 192 }, { 112, 194, 115 }, { 0, 0, 128 }, { 0, 0, 128 }, { 250, 218, 100 },
                    { 112, 194, 115 }, { 0, 0, 128 }, { 0, 0, 128 }, { 0, 0, 128 }, { 140, 104, 100 },
                    { 192, 192, 192 }, { 140, 104, 100 }, { null, null, null } },
            { { 0, 0, 128 }, { 0, 0, 128 }, { 0, 0, 128 }, { 192, 192, 192 }, { 0, 0, 128 },
                    { 255, 106, 107 }, { 0, 0, 128 }, { 112, 194, 115 }, { 0, 0, 128 }, { 250, 218, 100 },
                    { 0, 0, 0 }, { 112, 155, 219 }, { 250, 218, 100 } },
            { { 250, 218, 100 }, { 112, 155, 219 }, { 140, 104, 100 }, { 0, 0, 128 }, { 0, 0, 128 },
                    { 0, 0, 128 }, { 112, 155, 219 }, { 0, 0, 0 }, { 0, 0, 128 }, { 192, 192, 192 },
                    { 140, 104, 100 }, { 192, 192, 192 }, { null, null, null } },
            { { 255, 106, 107 }, { 0, 0, 0 }, { 192, 192, 192 }, { 112, 155, 219 }, { 255, 106, 107 },
                    { 112, 194, 115 }, { 250, 218, 100 }, { 140, 104, 100 }, { 192, 192, 192 }, { 0, 0, 128 },
                    { 112, 155, 219 }, { 112, 194, 115 }, { 255, 106, 107 } } };

    public Terrain(int x, int y, int width, int height, int color[], int fontSize) {
        actionListeners = new ArrayList<ActionListener>();
        row = x;
        col = y;

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
            if (defColors[x][y][0] != null) {
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