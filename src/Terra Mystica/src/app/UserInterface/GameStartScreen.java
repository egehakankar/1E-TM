package app.UserInterface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.imageio.ImageIO;

import app.Management.*;
import app.Model.*;

public class GameStartScreen extends DisplayPanel {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int WIDTH = screenSize.width;
    int HEIGHT = screenSize.height;

    private ArrayList<ArrayList<Terrain>> terrains;

    private BufferedImage image;
    

    public GameStartScreen() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("../images/background1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        terrains = new ArrayList<ArrayList<Terrain>>();

        int colors[] = { -1, -1, -1 };

        for (int a = 0; a < 9; a++) {
            terrains.add(new ArrayList<Terrain>());
            for (int b = 0; b < 13; b++) {
                terrains.get(a).add(new Terrain(a, b, 0, 0, colors, 0));
                if (a % 2 == 0 || b != 12) {
                    addTerrain(terrains.get(a).get(b));
                }
            }
        }
    }

    @Override
    public void render(Graphics2D g, GameManager gM) {
        g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);

        super.render(g, gM);
    }
}