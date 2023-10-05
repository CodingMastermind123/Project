import mayflower.*;
public class Water extends Actor
{
    
    public Water()
    {
        setImage("img/Tiles/17.png");
    }

    public void act()
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_LEFT))
        {
            setLocation(getX() + 2, getY());
        }
        if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT))
        {
            setLocation(getX() - 2, getY());
        }
        
    }

}
