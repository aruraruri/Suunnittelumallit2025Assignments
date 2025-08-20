package FactoryMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildernessMap extends Map {
    List<String> tileTypes = Arrays.asList("Swamp", "Forest", "Water");
    @Override
    public Tile createTile() {
        // Randomly select a tile type from the list
        int randomIndex = (int) (Math.random() * tileTypes.size());
        String tileType = tileTypes.get(randomIndex);
        // Create a new Tile object based on the selected type
        return switch (tileType) {
            case "Swamp" -> new SwampTile();
            case "Forest" -> new ForestTile();
            case "Water" -> new WaterTile();
            default -> null;
        };
    }

    @Override
    public void display() {
        // Display the tiles in the city map
        System.out.println("Wilderness Map Tiles:");
        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < 25; i++) { // Create 10 random tiles
            tiles.add(createTile());
        }
        for (int i = 0; i < tiles.size(); i++) {
            System.out.print(tiles.get(i).getCharacter()+" ");
            if ((i + 1) % 5 == 0) {
                System.out.println(); // New line after every 5 tiles
            }
        }
    }
}

