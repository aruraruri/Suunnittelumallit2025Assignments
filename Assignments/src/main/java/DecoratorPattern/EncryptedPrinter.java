package DecoratorPattern;

public class EncryptedPrinter extends PrinterDecorator{
    public EncryptedPrinter(Printer printer) {
        super(printer);
    }
    @Override
    public void print(String message) {
    StringBuilder encryptedMessage = new StringBuilder();
    for (String stringCharacter : message.split("")) {
        encryptedMessage.append((char) (stringCharacter.charAt(0) + 1));
        }

    super.print(encryptedMessage.toString());
    }
}
