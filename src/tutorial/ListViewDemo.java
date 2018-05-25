package tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ListView<String> fruits = new ListView <>();
        fruits.getItems().addAll("Apple", "Kiwi",
                "Passion Fruit", "Mango",
                "Coconut", "Blueberry", "Strawberry");

        // By default you can only select one item.
        // Set SelectionMode.MULTIPLE to allow selecting multiple items
        fruits.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button btn = new Button("Print");
        btn.setOnAction( event -> printSelected(fruits));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(fruits, btn);

        primaryStage.setScene(new Scene(layout, 300, 200));
        primaryStage.show();
    }

    private void printSelected(ListView<String> listView) {
        System.out.println("All items:");
        System.out.println(listView.getItems());

        System.out.println("Selection Mode: "
            + listView.getSelectionModel().getSelectionMode());

        System.out.println("Selected items:");
        System.out.println(listView.getSelectionModel().getSelectedItems());
    }
}