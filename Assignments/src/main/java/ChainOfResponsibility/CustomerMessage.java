package ChainOfResponsibility;


public class CustomerMessage {
    private CustomerMessageType messageType;
    private final String messageContent;
    private final String senderName;

    public CustomerMessage(CustomerMessageType messageType, String content, String sender) {
        this.messageType = messageType;
        this.messageContent = content;
        this.senderName = sender;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public String getSenderName() {
        return senderName;
    }

    public CustomerMessageType getMessageType() {
        return messageType;
    }
}
