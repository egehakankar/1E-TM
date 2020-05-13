package app;
import app.Management.GameManager;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
		GameManager game = new GameManager();
		//Starts game
		game.start();
    }
}