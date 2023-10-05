import mayflower.*;
public class Background extends World
{
    
    public Background()
    {
        setBackground("img/Basic.png");
        
        showText("WELCOME TO SIDESCROLLER!", 300, 300, Color.BLACK);
        showText("Press Enter to Start", 300, 400, Color.BLACK);
    }

    public void act()
    {
       if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
       {
           World w = new MyWorld();
           Mayflower.setWorld(w);
       }
    }
}