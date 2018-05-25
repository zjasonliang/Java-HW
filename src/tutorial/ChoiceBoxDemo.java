package tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChoiceBoxDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setVgap(8);
        layout.setHgap(8);

        Label fruitLabel = new Label("Fruit:");
        Label numLabel = new Label("Number:");

        ChoiceBox<String> fruitBox = new ChoiceBox<>();
        fruitBox.getItems().addAll("Apple", "Banana", "Passion Fruit", "Kiwi");
        fruitBox.setValue("Apple");

        // Demo: Listening to selection changes
        fruitBox.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (v, oldValue, newValue)
                                -> System.out.println("Selected fruit changed from " + oldValue + " to " + newValue)
                );

        ChoiceBox<Integer> numBox = new ChoiceBox<>();
        numBox.getItems().addAll(1, 2, 3, 4, 5);
        numBox.setValue(1);

        // Demo: Listening to selection changes
        numBox.getSelectionModel()
                .selectedItemProperty()
                .addListener(
                        (observable, oldValue, newValue)
                                -> System.out.println("Selected number changed from " + oldValue + " to " + newValue)
                );

        Button printBtn = new Button("Print");
        printBtn.setOnAction(event -> printOrder(fruitBox, numBox));

        GridPane.setConstraints(fruitLabel, 0, 0);
        GridPane.setConstraints(numLabel, 2, 0);
        GridPane.setConstraints(fruitBox, 1, 0);
        GridPane.setConstraints(numBox, 3, 0);
        GridPane.setConstraints(printBtn, 0, 1);

        layout.getChildren().addAll(fruitLabel, numLabel, fruitBox, numBox, printBtn);
        primaryStage.setScene(new Scene(layout, 400, 200));
        primaryStage.show();

    }

    private void printOrder(ChoiceBox<String> fruitBox, ChoiceBox<Integer> numBox) {
        if (ConfirmBox.display("Confirm the Order", "Are you sure to order?")) {
            System.out.println(fruitBox.getValue() + " " + numBox.getValue());
            // The following is equivalent to `fruitBox.getValue()`.
            System.out.println(fruitBox.getSelectionModel().getSelectedItem());
        }
    }
}
