package Proxy;

import java.nio.file.AccessDeniedException;

public class Main {
    public static void main(String[] args) throws AccessDeniedException {
        User user1 = new User("user1");
        User user2 = new User("user2");

        Library lib = new Library();

        RealDocument realDocument1 = new RealDocument(1, "This a real ahh document fr");
        DocumentProxy proxyDocument1 = new DocumentProxy(2, "sus");

        lib.putDocument(realDocument1.getId(), realDocument1);
        lib.putDocument(proxyDocument1.getId(), proxyDocument1);

        System.out.println("user2 tries to read real document id 1, document content: "+lib.readDocument(1, user2.getName()));
        System.out.println("user2 tries to read proxy document id 2, document content: "+lib.readDocument(2, user2.getName()));
        //System.out.println("user1 tries to read proxy document id 2, document content: "+lib.readDocument(2, user1.getName()));





    }
}
