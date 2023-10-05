import mayflower.*;

public class Lightning extends AnimatedActor
{
    private String[] frames;
    private Animation move;
    
    public Lightning()
    {
        setImage("img/lightning.png");
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
