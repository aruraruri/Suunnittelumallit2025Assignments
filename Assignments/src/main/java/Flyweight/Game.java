package Flyweight;

import java.util.Random;

public class Game {
    Random r= new Random();

    public Map createMap() {
        int mapType = r.nextInt(2);
        if (mapType == 0) {
            return new CityMap();
        } else {
            return new WildernessMap();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        Map map = game.createMap();
        map.display();
    }
}
