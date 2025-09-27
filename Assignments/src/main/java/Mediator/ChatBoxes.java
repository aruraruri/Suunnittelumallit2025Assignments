package Mediator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class ChatBoxes extends Application {
    IChatBox controller1;
    IChatBox controller2;
    IChatBox controller3;
    IChatMediator mediator;

    @Override
    public void start(Stage stage) throws Exception {

        mediator = new Mediator();

        try {
            stage.setTitle("box1");
            URL fxml = ChatBoxes.class.getResource("/fxml/chatBoxes.fxml");
            FXMLLoader loader = new FXMLLoader(fxml);
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
            controller1 = loader.getController();
            controller1.setMediator(mediator);
            mediator.registerChatbox(controller1, "box1");

            URL fxml2 = ChatBoxes.class.getResource("/fxml/chatBoxes2.fxml");
            FXMLLoader loader2 = new FXMLLoader(fxml2);
            Stage secondStage = new Stage();
            secondStage.setTitle("box2");
            secondStage.setScene(new Scene(loader2.load()));
            secondStage.show();
            controller2 = loader2.getController();
            controller2.setMediator(mediator);
            mediator.registerChatbox(controller2, "box2");

            URL fxml3 = ChatBoxes.class.getResource("/fxml/chatBoxes3.fxml");
            FXMLLoader loader3 = new FXMLLoader(fxml3);
            Stage thirdStage = new Stage();
            thirdStage.setTitle("box3");
            thirdStage.setScene(new Scene(loader3.load()));
            thirdStage.show();
            controller3 = loader3.getController();
            controller3.setMediator(mediator);
            mediator.registerChatbox(controller3, "box3");



        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
