package Flyweight.Model.Maps;

import Flyweight.Model.Tiles.Tile;

public abstract class Map {
    public abstract Tile createTile();
    public abstract void display();
}
