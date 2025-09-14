package memento.guistate;

import java.time.LocalDateTime;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private LocalDateTime timestamp;

    public Memento(int[] options, boolean isSelected, LocalDateTime timestamp) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.timestamp = timestamp;
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public LocalDateTime getTime() {
        return timestamp;
    }
}
