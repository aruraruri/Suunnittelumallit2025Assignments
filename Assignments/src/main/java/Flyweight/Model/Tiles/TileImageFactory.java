package Flyweight.Model.Tiles;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class TileImageFactory {
    private HashMap<String, Image> cachedImages;

    public TileImageFactory() {
        cachedImages = new HashMap<>();
    }

    public Image requestImage(String type) {
        if (cachedImages.get(type) != null) {
            return cachedImages.get(type);
        } else {
            try {
                cachedImages.put(type, new Image(new FileInputStream("/img/"+type+".png")));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return cachedImages.get(type);
    }
}
