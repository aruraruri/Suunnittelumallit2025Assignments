package Flyweight.Model.Maps;

import Flyweight.Model.Tiles.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CityMap implements Map{
    private List<Tile> tiles;
    private TileImageFactory tileFactory;
    List<String> tileTypes = Arrays.asList("road","building");

    public CityMap() {
        tiles = new ArrayList<>();
        tileFactory = new TileImageFactory();

        Random r = new Random();

        for (int i=0; i<25; i++) {
            switch (tileTypes.get(r.nextInt(2))) {
                case "road":
                    tiles.add(new RoadTile(tileFactory.requestImage("road")));
                    break;
                case "building":
                    tiles.add(new BuildingTile(tileFactory.requestImage("building")));
                    break;
            }
        }
    }

    @Override
    public List<Tile> getTiles() {
        return tiles;
    }
}
