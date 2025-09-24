package Flyweight.Model;

import Flyweight.Model.Maps.CityMap;
import Flyweight.Model.Maps.Map;
import Flyweight.Model.Maps.WildernessMap;

import java.util.Random;

public class Game {
    Random r;
    Map map;

    public Game() {
        r = new Random();
        map = this.createMap();
    }

    public Map createMap() {
        int mapType = r.nextInt(2);
        if (mapType == 0) {
            return new CityMap();
        } else {
            return new WildernessMap();
        }
    }

    public Map getMap() {
        return map;
    }
}
