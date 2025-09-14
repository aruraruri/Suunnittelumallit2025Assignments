package memento.guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history;
    private List<IMemento> redoHistory;// Memento history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    public List<IMemento> getHistory() {
        return history;
    }

    public List<IMemento> getRedoHistory() {
        return redoHistory;
    }

    public void setOption(int optionNumber, int choice) {
        addToHistory();
        clearRedoHistory();
        model.setOption(optionNumber, choice);
        gui.updateGui();
    }

    public void clearRedoHistory() {
        redoHistory.clear();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        addToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void restoreState(IMemento memento) {
        model.restoreState(memento);
        gui.updateGui();
    }

    public void undo() {
        if (!history.isEmpty()) {
            // add current state to redo history
            redoHistory.add(model.createMemento());
            System.out.println("Memento found in history");
            IMemento previousState = history.remove(history.size() - 1);
            restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            // add current state to history
            history.add(model.createMemento());
            System.out.println("Memento found in history");
            IMemento redoState = redoHistory.remove(redoHistory.size() - 1);
            restoreState(redoState);
            gui.updateGui();
        }
    }

    private void addToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    public void reorganizeHistoriesAroundIndex(int index) {

        // move all mementos after index to redoHistory
        for (int i = history.size() - 1; i > index; i--) {
            IMemento memento = history.remove(i);
            redoHistory.add(0, memento); // add to the front of redoHistory
        }
    }
}
