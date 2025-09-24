package Flyweight.Model.Tiles;

import javafx.scene.image.Image;

public class WaterTile implements Tile {
    private Image img;
    private int[] pos = new int[2];

    public WaterTile(Image img) {
        this.img = img;
    }

    @Override
    public String getType() {
        return "water";
    }

    @Override
    public Image getImg () {
        return img;
    }
}
