package memento.guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history;
    private int currentIndex;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.currentIndex = -1;

    }

    public void setOption(int optionNumber, int choice) {
        removeRedoHistoryAfterCurrentlySelectedIndex();
        model.setOption(optionNumber, choice);
        addToHistory();
        gui.updateGui();


    }

    // Redo history should be cleared when a new action is performed
    public void removeRedoHistoryAfterCurrentlySelectedIndex() {
        if (currentIndex < history.size() - 1) {
            history = new ArrayList<>(history.subList(0, currentIndex + 1));
        }
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        removeRedoHistoryAfterCurrentlySelectedIndex();
        model.setIsSelected(isSelected);
        addToHistory();

    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void restoreState(int index) {
        IMemento memento = history.get(index);
        model.restoreState(memento);
        //currentIndex = index;
        gui.updateGui();
        System.out.println("Restored state to index: "+index);
    }

    public void undo() {
        if (currentIndex > 0) {
            currentIndex--;
            IMemento previousState = history.get(currentIndex);
            model.restoreState(previousState);
            gui.updateGui();
        }
        System.out.println("Undo action performed, current index: "+currentIndex);
    }

    public void redo() {
        if (currentIndex < history.size() - 1) {
            currentIndex++;
            IMemento nextState = history.get(currentIndex);
            model.restoreState(nextState);
            gui.updateGui();
        }
        System.out.println("Redo action performed, current index: "+currentIndex);
    }

    private void addToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        currentIndex = history.size() - 1; // Set currentIndex to the last element
        gui.updateGui();
    }

    public List<IMemento> getHistory() {
        return history;
    }

    public void addInitialState() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        currentIndex = history.size() - 1;
    }
}
