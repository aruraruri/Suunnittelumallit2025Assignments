package Flyweight.Model.Tiles;

import javafx.scene.image.Image;

public class TileFlyweight implements Flyweight{
    private final Image img;
    private final TileType type;

    public TileFlyweight(Image img, TileType type) {
        this.img = img;
        this.type = type;
    }

    @Override
    public Image getImage() {
        return img;
    }

}
