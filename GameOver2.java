import mayflower.*;
public class GameOver2 extends World
{
    
    public GameOver2()
    {
        setBackground("img/Basic.png");
        
        showText("Game Over!", 300, 300, Color.BLACK);
            showText("Press Enter to Restart", 300, 400, Color.BLACK);
    }

    public void act()
    {
       if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
       {
           World w = new World2();
           Mayflower.setWorld(w);
       }
    }
}