package memento.guistate;

import Observer.Observable;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;
    private ListView<String> historyMetaData;

    public void start(Stage stage) {

        controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        // Add the ColorBoxes and CheckBox to a HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);


        Label label = new Label("Press Ctrl-Z to undo the last change.");
        label.setPadding(insets);

        // create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(hBox, checkBox, label);
        // call controller when the CheckBox is clicked
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
        });

        // history scene
        historyMetaData = new ListView<>();
        Scene historyScene = new Scene(historyMetaData);

        // Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                // Ctrl-Z: undo
                System.out.println("Undo key combination pressed");
                controller.undo();
            }
            if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                // Ctrl-Y: redo
                System.out.println("Redo key combination pressed");
                controller.redo();
            }
        });


        Stage historyStage = new Stage();
        historyStage.setScene(historyScene);
        historyStage.setTitle("Undo History");
        historyStage.show();

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
        historyStage.show();
    }

    public void updateGui() {
        // called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());

        // update undo history list
        historyMetaData.getItems().clear();
        for (IMemento memento : controller.getHistory()) {
            historyMetaData.getItems().add(String.valueOf(memento.getTime()));
        }
        // same for redo history
        for (IMemento memento : controller.getRedoHistory()) {
            historyMetaData.getItems().add(String.valueOf(memento.getTime()));
        }
        // add keypress observers to all history list items
        historyMetaData.setOnMouseClicked(event -> {
            int selectedIndex = historyMetaData.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < controller.getHistory().size()) {
                IMemento selectedMemento = controller.getHistory().get(selectedIndex);
                controller.restoreState(selectedMemento);
            }
            controller.reorganizeHistoriesAroundIndex(selectedIndex);
            updateGui();
        });
    }
}
