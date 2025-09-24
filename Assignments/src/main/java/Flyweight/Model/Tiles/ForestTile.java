package Flyweight.Model.Tiles;

import javafx.scene.image.Image;

public class ForestTile implements Tile {
    private Image img;
    private int[] pos = new int[2];

    public ForestTile(Image img) {
        this.img = img;
    }

    @Override
    public String getType() {
        return "forest";
    }

    @Override
    public Image getImg () {
        return img;
    }
}
