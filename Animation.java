import mayflower.*;
public class Animation {
    private MayflowerImage[] frames;
    private int currentFrame;
    private int frameDelay;
    private int frameCounter;

    public Animation(int frameDelay, String[] filename) {
        this.frameDelay = frameDelay;
        frames = new MayflowerImage[filename.length];
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new MayflowerImage(filename[i]);
            frames[i].scale(100, 87);
        }
        currentFrame = 0;
        frameCounter = 0;
    }
    public void setFrameDelay(int a)
    {
        frameDelay = a;
    }
    public MayflowerImage getNextFrame() {
        if (frameCounter >= frameDelay) {
            currentFrame = (currentFrame + 1) % frames.length;
            frameCounter = 0;
        } else {
            frameCounter++;
        }
        return frames[currentFrame];
    }
}