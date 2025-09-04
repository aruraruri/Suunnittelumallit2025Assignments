package ChainOfResponsibility;

public abstract class CustomerMessageHandler{
    private CustomerMessageHandler nextCustomerMessageHandler;

    public void setNextMessageHandler(CustomerMessageHandler next) {
        this.nextCustomerMessageHandler = next;
    }

    public void handleMessage(CustomerMessage message) {
        if (nextCustomerMessageHandler != null) {
            nextCustomerMessageHandler.handleMessage(message);
        }
    }
}
