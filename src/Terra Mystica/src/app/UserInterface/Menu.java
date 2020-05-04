package app.UserInterface;

import javax.swing.*;
import java.awt.*;

public class Menu 
{
    public void showMainMenu()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //Creating the Frame
        JFrame frame = new JFrame("TERRA MYSTICA 1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(1200, 730);
        frame.setSize(screenSize.width, screenSize.height);

        //Creating the panel at bottom and adding components
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        //menu.setPreferredSize(new Dimension(800, 800));
        menu.setPreferredSize(screenSize);
        menu.setMinimumSize(screenSize);
        JLabel label = new JLabel("TERRA MYSTICA");

        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        label.setFont(new Font("ShelleyVolante BT", Font.PLAIN, 75));
        
        //EMPTY LABELS
        JLabel labelE0 = new JLabel("  ");
        labelE0.setFont(new Font("Arial", Font.PLAIN, 55));
        JLabel labelE1 = new JLabel("  ");
        labelE1.setFont(new Font("Arial", Font.PLAIN, 55));
        JLabel labelE2 = new JLabel("  ");
        labelE2.setFont(new Font("Arial", Font.PLAIN, 55));
        JLabel labelE3 = new JLabel("  ");
        labelE3.setFont(new Font("Arial", Font.PLAIN, 55));


        JButton playB = new JButton("Play");
        playB.setAlignmentX(Component.CENTER_ALIGNMENT);
        playB.setSize(800, 800);
        playB.setFont(new Font("Arial", Font.PLAIN, 60));

        JButton htpB = new JButton("How To Play");
        htpB.setAlignmentX(Component.CENTER_ALIGNMENT);
        htpB.setPreferredSize(new Dimension(120, 120));
        htpB.setFont(new Font("Arial", Font.PLAIN, 60));

        JButton creditsB = new JButton("Credits");
        creditsB.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditsB.setPreferredSize(new Dimension(40, 40));
        creditsB.setFont(new Font("Arial", Font.PLAIN, 60));

        JButton quitB = new JButton("Quit");
        quitB.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitB.setPreferredSize(new Dimension(40, 40));
        quitB.setFont(new Font("Arial", Font.PLAIN, 60));

        menu.add(Box.createHorizontalGlue());

        menu.add(label);
        menu.add(labelE0); //EMPTY LINE
        menu.add(playB);
        menu.add(labelE1); //EMPTY LINE
        menu.add(htpB);
        menu.add(labelE2); //EMPTY LINE
        menu.add(creditsB);
        menu.add(labelE3); //EMPTY LINE
        menu.add(quitB);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.CENTER, menu);
        frame.setVisible(true);
    }
}