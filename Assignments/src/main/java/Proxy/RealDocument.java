package Proxy;
import java.time.LocalDateTime;

public class RealDocument implements DocumentInterface{
    private int id;
    private LocalDateTime creationLocalDateTime;
    private String content;

    public RealDocument(int id, String content) {
        this.id = id;
        this.content = content;
        creationLocalDateTime = LocalDateTime.now();
    }

    @Override
    public LocalDateTime getLocalCreationDateTime() {
        return creationLocalDateTime;
    }

    @Override
    public String getContent(String username, int docId) {
        return content;
    }

    @Override
    public int getId() {
        return id;
    }
}
