import mayflower.*;
public class Dirt extends Block
{
    

    public Dirt()
    {
        setImage("img/Tiles/5.png");
        
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
        super.act();
    }
}
