package Mediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mediator implements IChatMediator{

    private HashMap<String, IChatBox> chatBoxes;

    public Mediator() {
        chatBoxes = new HashMap<>();
    }

    @Override
    public void registerChatbox(IChatBox chatBox, String name) {
        chatBoxes.put(name, chatBox);
    }

    @Override
    public void sendMessage(String message, String recipient) {
        chatBoxes.get(recipient).receiveMessage(message);
    }
}
