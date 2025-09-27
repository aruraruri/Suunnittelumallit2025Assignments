package Mediator;

public interface IChatBox {
    void receiveMessage(String message);
    void setMediator(IChatMediator mediator);
}
