package Flyweight.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class GUI extends Application {
    GameController controller;
    @Override
    public void start(Stage stage) throws Exception {
        try {
            stage.setTitle("Tile Game");
            URL fxml = GUI.class.getResource("/fxml/tileGameGUI.fxml");
            FXMLLoader loader = new FXMLLoader(fxml);
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();

            controller = loader.getController();

            controller.startGame();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
