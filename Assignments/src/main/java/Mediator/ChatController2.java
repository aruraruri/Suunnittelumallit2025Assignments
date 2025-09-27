package Mediator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatController2 implements IChatBox{
    @FXML
    private ListView<String> messagesListView2;
    @FXML
    private TextField sendToTextField2;
    @FXML
    private TextField chatTextField2;
    @FXML
    private Button sendMessageButton2;

    IChatMediator mediator;

    public void sendMessage2(ActionEvent actionEvent) {
        mediator.sendMessage(chatTextField2.getText(), sendToTextField2.getText());
        messagesListView2.getItems().add(chatTextField2.getText());
    }


    @Override
    public void receiveMessage(String message) {
        messagesListView2.getItems().add(message);
    }

    @Override
    public void setMediator(IChatMediator mediator) {
        this.mediator = mediator;
    }
}
