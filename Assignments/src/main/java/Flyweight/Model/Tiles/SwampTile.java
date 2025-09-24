package Flyweight.Model.Tiles;

import javafx.scene.image.Image;

public class SwampTile implements Tile {
    private Image img;
    private int[] pos = new int[2];

    public SwampTile(Image img) {
        this.img = img;
    }

    @Override
    public String getType() {
        return "swamp";
    }

    @Override
    public void setPosition(int posX, int posY) {
        pos[0] = posX;
        pos[1] = posY;
    }

    @Override
    public int[] getPosition() {
        return pos;
    }

    public Image getImg () {
        return img;
    }
}
