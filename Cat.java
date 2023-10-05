import mayflower.*;

public class Cat extends AnimatedActor {
    private String[] frame;
    private String[] frame2;
    private String[] frame3;
    private int currentFrame;
    private double gravity = 0.2;
    private double jumpForce = -12;
    private boolean isJumping = false;
    private double velocityY;
    private int groundY = 393;
    private int x;
    private int y;
    private int h;
    private boolean isWalking = false;
    private Animation walk;
    private Animation idle;
    private Animation fall;
    private int score;
    private int lives;
    private boolean isInvincible;
    private int invincibilityCooldown;

    private boolean lifeLost = false;

    public Cat() {
        score = 0;
        lives = 3;
        isInvincible = false;
        invincibilityCooldown = 0;
        frame = new String[10];
        frame2 = new String[10];
        frame3 = new String[10];
        for (int i = 1; i <= frame.length; i++) {
            frame[i - 1] = "img/cat/Walk (" + i + ").png";
        }
        walk = new Animation(3, frame);
        for (int i = 1; i <= frame2.length; i++) {
            frame2[i - 1] = "img/cat/Idle (" + i + ").png";
        }
        idle = new Animation(3, frame2);
        for (int i = 1; i <= frame3.length; i++) {
            frame3[i - 1] = "img/cat/Fall (" + i + ").png";
        }
        fall = new Animation(3, frame3);
    }

    public void act() {

        if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT) || Mayflower.isKeyDown(Keyboard.KEY_LEFT))
        {
            setAnimation(walk);
        }
        else
        {
            setAnimation(idle);
        }

        super.act();

        x = getX();
        y = getY();
        h = getHeight();
        if(Mayflower.isKeyDown(Keyboard.KEY_UP) && isTouching(Dirt.class))
        {
            setAnimation(walk);
            setLocation(x, y - 1);
            
        }
        
        if(isTouching(Dirt.class))
        {
            groundY = 150;
        }
        else
        {
            groundY = 393;
        }

        if (Mayflower.isKeyDown(Keyboard.KEY_UP) && !isJumping) {
            velocityY = jumpForce;
            isJumping = true;
            isWalking = true;
        }

        if (isJumping) {
            velocityY += gravity;
            y += (int) velocityY;

            if (y >= groundY) {
                setAnimation(fall);
                y = groundY;
                isJumping = false;
                velocityY = 0; 
            }
        }

        
        
        
        setLocation(x, y);
        checkCoinCollision();
        checkWaterCollision();
        checkStarCollision();
        checkBoltCollision();
        updateText();

        if (isInvincible) {
            invincibilityCooldown--;
            if (invincibilityCooldown <= 0) {
                isInvincible = false;
                makeVisible();
            }
        }
        
        
        
    }

    private void updateText() {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
    }
private void checkStarCollision()
{
    PowerUp star = getOneIntersectingObject(PowerUp.class);
    
    if(star != null)
    {
        getWorld().removeObject(star);
        jumpForce = jumpForce - 2;
    }
}
private void checkBoltCollision()
{
    Lightning bolt = getOneIntersectingObject(Lightning.class);
    
    if(bolt != null)
    {
        getWorld().removeObject(bolt);
        gravity = gravity - 0.1;
    }
}
    private void checkCoinCollision() {
        Coin coin = getOneIntersectingObject(Coin.class);
        

        if (coin != null) {
            getWorld().removeObject(coin);
            score++;
            updateText();
        }
    }

    public boolean checkWaterCollision() {
    Water water = getOneIntersectingObject(Water.class);

    if (water != null && !isInvincible) {
        lives--;
        updateText(); 
        isInvincible = true;
        invincibilityCooldown = 100; 
        makeInvisible(); 
        resetPosition();
        return true;
    }
    return false;
}

    private void makeInvisible() {
        getImage().setTransparency(0); 
    }

    private void makeVisible() {
        getImage().setTransparency(255); 
    }

    public void resetPosition() {
        setLocation(50, groundY); 
    }

    public int getScore()
    {
        return score;
    }

    public int getLives()
    {
        return lives;
    }

    public void loseLife()
    {
        lives--;
        lifeLost = true;
        updateText();
    }

    public void makeFalse()
    {
        lifeLost = false;
    }
}
