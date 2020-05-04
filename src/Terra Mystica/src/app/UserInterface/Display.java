package app.UserInterface;

public class Display 
{
    public void displayMainMenu()
    {
        Menu newMenu = new Menu();
        newMenu.showMainMenu();
    }

    public void displayHowToPlay()
    {
        HowToPlay newHtp = new HowToPlay();
        newHtp.showHowToPlay();
    }
}