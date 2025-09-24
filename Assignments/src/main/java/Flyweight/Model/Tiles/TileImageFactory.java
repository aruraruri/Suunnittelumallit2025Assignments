package Flyweight.Model.Tiles;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class TileImageFactory {
    private final HashMap<String, Image> cachedImages;

    public TileImageFactory() {
        cachedImages = new HashMap<>();
    }

    public Image requestImage(String type) {
        System.out.println("Requesting image of type: " + type);
        System.out.println("Cached images: " + cachedImages.keySet());
        if (cachedImages.get(type) != null) {
            return cachedImages.get(type);
        } else {
            try {
                cachedImages.put(type, new Image(new FileInputStream("C:\\Users\\D\\IdeaProjects\\Suunnittelumalit2025Assignments\\Assignments\\src\\main\\resources\\img\\" + type + ".png")));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return cachedImages.get(type);
    }
}
