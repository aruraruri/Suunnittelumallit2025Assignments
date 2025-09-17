package Proxy;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;

public class Library {
    private HashMap<Integer, DocumentInterface> documents;

    public Library() {
        documents = new HashMap<>();
    }

    public void putDocument(Integer id, DocumentInterface doc) {
        documents.put(id, doc);
    }

    public String readDocument(int idToRead, String username) throws AccessDeniedException {
        return documents.get(idToRead).getContent(username, idToRead);
    }
}
