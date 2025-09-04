package ChainOfResponsibility;

public class LastResortHandler extends CustomerMessageHandler{
    @Override
    public void handleMessage(CustomerMessage message) {
        System.out.println("Message from "+message.getSenderName()+" was not handled by anyone :(((");
    }
}
