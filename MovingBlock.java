import mayflower.*;
public class MovingBlock extends Block
{
    

    public MovingBlock()
    {
        setImage("img/Tiles/14.png");
        
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
