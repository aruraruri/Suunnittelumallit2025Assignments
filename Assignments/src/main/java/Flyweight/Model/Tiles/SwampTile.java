package Flyweight.Model.Tiles;

public class SwampTile implements Tile {

    @Override
    public String getCharacter() {
        return "S";
    }

    @Override
    public String getType() {
        return "Swamp";
    }
}
