package Proxy;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;

public interface DocumentInterface {
    int getId();
    LocalDateTime getLocalCreationDateTime();

    String getContent(String username, int docId) throws AccessDeniedException;
}
