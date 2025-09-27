package Mediator;

public interface IChatMediator {
    void registerChatbox(IChatBox IChatBox, String name);
    void sendMessage(String message, String recipient);
}
