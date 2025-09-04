package ChainOfResponsibility;

public class FeedbackHandler extends CustomerMessageHandler{

    @Override
    public void handleMessage(CustomerMessage message) {
        if (message.getMessageType() == CustomerMessageType.FEEDBACK) {
            System.out.println("Message from "+message.getSenderName()+" of type: feedback. Forwarding feedback to dev department");
        } else {
            super.handleMessage(message);
        }
    }
}
