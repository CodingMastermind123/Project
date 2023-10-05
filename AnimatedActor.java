import mayflower.*;
public class AnimatedActor extends Actor
{
    public Animation animation;
    private Timer animationTimer;
    public AnimatedActor()
    {
        animationTimer = new Timer(10000000);
    }

    public void act()
    {
        if( animationTimer.isDone() )
        {
            animationTimer.reset();
        }
        MayflowerImage img = animation.getNextFrame();
        setImage(img);
    }

    public void setAnimation(Animation a)
    {
        animation = a;
    }
}
