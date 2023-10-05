import mayflower.*;
public class WinWorld extends World
{
    
    public WinWorld()
    {
        setBackground("img/Basic.png");
        
        showText("YOU WIN", 300, 300, Color.BLACK);
            showText("Press Enter to Continue", 300, 400, Color.BLACK);
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