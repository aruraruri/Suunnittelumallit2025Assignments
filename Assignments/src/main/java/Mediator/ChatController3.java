package Mediator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatController3 implements IChatBox{
    @FXML
    private ListView<String> messagesListView3;
    @FXML
    private TextField sendToTextField3;
    @FXML
    private TextField chatTextField3;
    @FXML
    private Button sendMessageButton3;

    IChatMediator mediator;

    public void sendMessage3(ActionEvent actionEvent) {
        mediator.sendMessage(chatTextField3.getText(), sendToTextField3.getText());
        messagesListView3.getItems().add(chatTextField3.getText());
    }


    @Override
    public void receiveMessage(String message) {
        messagesListView3.getItems().add(message);
    }

    @Override
    public void setMediator(IChatMediator mediator) {
        this.mediator = mediator;
    }
}
