package tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ComboBox<String> cbox = new ComboBox <>();
        cbox.getItems().addAll("Apple", "Banana", "Kiwi", "Passion Fruit");
        cbox.setPromptText("What is your favorite fruit?");

        // User can type in their own stuff
        // Note: When setEditable(true), setPromptText() gets overwritten.
        cbox.setEditable(true);

        cbox.setOnAction( event -> System.out.println("Selected: " + cbox.getValue()) );

        Button btn = new Button("Print");
        btn.setOnAction( event -> System.out.println("Print: " + cbox.getValue()));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(cbox, btn);

        primaryStage.setScene(new Scene(layout, 350, 200));
        primaryStage.show();
    }
}
