package ChainOfResponsibility;

public class HelpdeskHandler extends CustomerMessageHandler{

    @Override
    public void handleMessage(CustomerMessage message) {
        if (message.getMessageType() == CustomerMessageType.HELPDESK) {
            System.out.println("Message from "+message.getSenderName()+" of type: helpdesk. Forwarding to customer service");
        } else {
            super.handleMessage(message);
        }
    }
}
