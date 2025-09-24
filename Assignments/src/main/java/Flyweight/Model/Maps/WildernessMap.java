package Flyweight.Model.Maps;

import Flyweight.Model.Tiles.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildernessMap implements Map {
    List<String> tileTypes = Arrays.asList("Swamp", "Forest", "Water");

    @Override
    public List<Tile> getTiles() {
        return List.of();
    }
}

