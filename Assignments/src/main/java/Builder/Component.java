package Builder;

public class Component {
    private String type;
    private Double size;

    public Component(String type, Double size) {
        this.type = type;
        this.size = size;
    }
    public Component(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Double getSize() {
        return size;
    }
}
