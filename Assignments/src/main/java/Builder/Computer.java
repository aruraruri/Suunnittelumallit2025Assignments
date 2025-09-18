package Builder;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    List<Component> componentList;

    public Computer() {
        componentList = new ArrayList<>();
    }

    public void addComponent(Component component) {
        componentList.add(component);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Component component : componentList) {
            sb.append(component.getType());
            if (component.getSize() != null) {
                sb.append(" ").append(component.getSize()).append("MB");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
