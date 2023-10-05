import mayflower.*;

public class Coin extends AnimatedActor
{
    private String[] frames;
    private Animation move;
    
    public Coin()
    {
        frames = new String[10];
        for (int i = 1; i <= frames.length; i++) {
            frames[i - 1] = "img/coin/Coin (" + i + ").png";
        }
        move = new Animation(20, frames);
    }
    
    public void act()
    {
        setAnimation(move);
        super.act();
        
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
