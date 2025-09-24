package Flyweight.Model.Tiles;

public class WaterTile implements Tile {

    @Override
    public String getCharacter() {
        return "W";
    }

    @Override
    public String getType() {
        return "Water";
    }
}
