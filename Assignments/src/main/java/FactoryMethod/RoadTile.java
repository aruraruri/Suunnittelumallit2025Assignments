package FactoryMethod;

public class RoadTile implements Tile {

    @Override
    public String getCharacter() {
        return "R";
    }

    @Override
    public String getType() {
        return "Road";
    }
}
