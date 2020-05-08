package app;

import javax.swing.JFrame;
import app.Management.GameManager;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        GameManager game = new GameManager();
        JFrame window = new JFrame("Terra Mystica");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.add(game);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		game.start();
		
    }
}