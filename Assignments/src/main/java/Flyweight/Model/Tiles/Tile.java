package Flyweight.Model.Tiles;

import javafx.scene.image.Image;

public interface Tile {
    String getType();
    void setPosition(int posX, int posY);
    int[] getPosition();
    Image getImg();
}