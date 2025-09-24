package Flyweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildernessMap extends Map {
    List<String> tileTypes = Arrays.asList("Swamp", "Forest", "Water");
    @Override
    public Tile createTile() {
        // random select tile type from list
        int randomIndex = (int) (Math.random() * tileTypes.size());
        String tileType = tileTypes.get(randomIndex);
        // new Tile object of the selected type
        return switch (tileType) {
            case "Swamp" -> new SwampTile();
            case "Forest" -> new ForestTile();
            case "Water" -> new WaterTile();
            default -> null;
        };
    }

    @Override
    public void display() {
        System.out.println("Wilderness Map Tiles:");
        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < 25; i++) { // create 25 tiles
            tiles.add(createTile());
        }
        for (int i = 0; i < tiles.size(); i++) {
            System.out.print(tiles.get(i).getCharacter()+" ");
            if ((i + 1) % 5 == 0) {
                System.out.println(); // line break every 5 tiles
            }
        }
    }
}

