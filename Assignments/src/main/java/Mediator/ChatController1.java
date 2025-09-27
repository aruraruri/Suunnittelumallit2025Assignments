package Mediator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatController1 implements IChatBox{
    @FXML
    private ListView<String> messagesListView;
    @FXML
    private TextField sendToTextField;
    @FXML
    private TextField chatTextField;
    @FXML
    private Button sendMessageButton;

    IChatMediator mediator;

    public void sendMessage(ActionEvent actionEvent) {
        mediator.sendMessage(chatTextField.getText(), sendToTextField.getText());
        messagesListView.getItems().add(chatTextField.getText());
    }


    @Override
    public void receiveMessage(String message) {
        messagesListView.getItems().add(message);
    }

    @Override
    public void setMediator(IChatMediator mediator) {
        this.mediator = mediator;
    }
}
