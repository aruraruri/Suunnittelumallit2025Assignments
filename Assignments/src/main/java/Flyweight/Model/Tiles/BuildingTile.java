package Flyweight.Model.Tiles;

import javafx.scene.image.Image;

public class BuildingTile implements Tile {
    private Image img;

    public BuildingTile(Image img) {
        this.img = img;
    }

    @Override
    public String getType() {
        return "building";
    }

    @Override
    public Image getImg () {
        return img;
    }
}
