package Flyweight.Model.Tiles;

public interface Tile {
    String getType();
    void setPosition(int posX, int posY);
    int[] getPosition();
}