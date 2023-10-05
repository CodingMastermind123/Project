import mayflower.*;
public class YouWin extends World
{
    
    public YouWin()
    {
        setBackground("img/Basic.png");
        
        showText("YOU WIN", 300, 300, Color.BLACK);
            showText("Press Enter to Restart", 300, 400, Color.BLACK);
    }

    public void act()
    {
       if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
       {
           World w = new Background();
           Mayflower.setWorld(w);
       }
    }
}