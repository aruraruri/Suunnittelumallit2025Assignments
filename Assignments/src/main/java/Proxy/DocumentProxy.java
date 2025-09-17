package Proxy;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;

public class DocumentProxy implements DocumentInterface{
    private int id;
    private LocalDateTime creationLocalDateTime;
    private String content;
    private RealDocument realDocument;

    public DocumentProxy(int id, String content) {
        this.id = id;
        this.content = content;
        creationLocalDateTime = LocalDateTime.now();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public LocalDateTime getLocalCreationDateTime() {
        return creationLocalDateTime;
    }

    @Override
    public String getContent(String username, int docId) throws AccessDeniedException {
        if (AccessControlService.getAccessControlService().hasAccess(username, docId)) {
            if (realDocument == null) {
                 realDocument = new RealDocument(this.id, this.content);
            }
            return realDocument.getContent(username, docId);
        } else {
            throw new AccessDeniedException("User does not have access to this document!");
        }
    }
}
