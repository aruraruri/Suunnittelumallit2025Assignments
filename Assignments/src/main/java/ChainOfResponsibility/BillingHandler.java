package ChainOfResponsibility;

public class BillingHandler extends CustomerMessageHandler{

    @Override
    public void handleMessage(CustomerMessage message) {
        if (message.getMessageType() == CustomerMessageType.BILLING) {
            System.out.println("Message from "+message.getSenderName()+" of type: billing. Forwarding to the billing department");
        } else {
            super.handleMessage(message);
        }
    }
}
