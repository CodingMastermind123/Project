import mayflower.*;

public class World2 extends World 
{
    private Cat cat;

    private String[][] tiles;
    public World2() 
    {
        setBackground("img/BG.png");
        cat = new Cat();
        addObject(cat,50, 393);

        tiles = new String[6][100];
        buildWorld();
    }

    public void act()
    {
if (cat.getLives() == 0) {
            removeObject(cat);
            World w = new GameOver();
            Mayflower.setWorld(w);
        }
        if(cat.getScore() == 3)
        {
            removeObject(cat);
            removeText(10, 30);
            showText("YOU WON!", 300, 300, Color.BLACK);
            showText("Press Enter to Continue", 300, 400, Color.BLACK);
            if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
            {
                World w = new World3();
                Mayflower.setWorld(w);
            }
        }
    }

    public void buildWorld()
    {
        for(int i = 0; i < tiles.length; i++)
        {
            for(int j = 0; j < tiles[0].length; j++)
            {
                tiles[i][j] = "";
            }
        }

        tiles[5][15] = "water";
        tiles[5][25] = "water";
        tiles[5][35] = "water";
        tiles[5][45] = "water"; 

        tiles[2][30] = "coin"; 
        tiles[4][10] = "coin"; 
        tiles[4][40] = "coin";
        
        tiles[4][5] = "powerup";
        tiles[4][13] = "lightning";
        for(int i = 0; i < tiles[0].length; i++)
        {
            if(tiles[5][i] == "")
            {
                tiles[5][i] = "ground";
            }

        }
        for(int i = 0; i < tiles.length; i++)
        {
            for(int j = 0; j < tiles[0].length; j++)
            {
                if(tiles[i][j] == "ground")
                {  
                    MovingBlock block = new MovingBlock();
                    addObject(block, j * 128, i + 472);
                }

            }
        }

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {

                if (tiles[i][j].equals("coin")) {
                    Coin coin = new Coin();
                    int x = j * 100;
                    int y = 393; 
                    addObject(coin, x, y);
                }
            }
        }

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {

                if (tiles[i][j].equals("powerup")) {
                    PowerUp star = new PowerUp();
                    int x = j * 100;
                    int y = 393; 
                    addObject(star, x, y);
                }
            }
        }
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {

                if (tiles[i][j].equals("lightning")) {
                    Lightning bolt = new Lightning();
                    int x = j * 100;
                    int y = 393; 
                    addObject(bolt, x, y);
                }
            }
        }
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {

                if (tiles[i][j].equals("water")) {
                    Water water = new Water();
                    addObject(water, j * 128, i + 472);
                }
            }
        }

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                if(j > 10 && j < 20)
                {
                    tiles[3][j] = "dirt";
                    tiles[4][j] = "dirt";
                }
            }
        }
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                if (tiles[i][j].equals("wall")) {
                    int yOffset = i * 50; 
                    MovingBlock block = new MovingBlock();
                    addObject(block, j * 128, i * 128 - yOffset);
                }
                if (tiles[i][j].equals("dirt")) {
                    int yOffset = i * 50; 
                    Dirt dirt = new Dirt();
                    addObject(dirt, j * 128, i * 128 - yOffset);
                }
            }
        }
    }
}
