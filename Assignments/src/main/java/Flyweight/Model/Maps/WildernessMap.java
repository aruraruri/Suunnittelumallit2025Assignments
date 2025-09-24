package Flyweight.Model.Maps;

import Flyweight.Model.Tiles.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WildernessMap implements Map {
    private List<Tile> tiles;
    private TileImageFactory tileImgFactory;
    List<String> tileTypes = Arrays.asList("forest","swamp","water");

    public WildernessMap() {
        tiles = new ArrayList<>();
        tileImgFactory = new TileImageFactory();

        Random r = new Random();

        for (int i=0; i<25; i++) {
            switch (tileTypes.get(r.nextInt(2))) {
                case "forest":
                    tiles.add(new RoadTile(tileImgFactory.requestImage("forest")));
                    break;
                case "swamp":
                    tiles.add(new BuildingTile(tileImgFactory.requestImage("swamp")));
                    break;
                case "water":
                    tiles.add(new BuildingTile(tileImgFactory.requestImage("water")));
                    break;
            }
        }
    }

    @Override
    public List<Tile> getTiles() {
        return tiles;
    }
}

