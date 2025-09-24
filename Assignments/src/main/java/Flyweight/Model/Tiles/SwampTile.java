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
    public Image getImg () {
        return img;
    }
}
