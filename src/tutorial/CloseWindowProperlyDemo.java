package tutorial;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;

import javafx.scene.control.Button;

public class CloseWindowProperlyDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX App");

        primaryStage.setOnCloseRequest(event -> {
            event.consume(); // Consume the close request.
            closeProgram(primaryStage);
        });

        Button button = new Button("Close program");
        button.setOnAction(e -> closeProgram(primaryStage));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void closeProgram(Stage window) {
        boolean answer = ConfirmBox.display("Title", "Are you sure?");
        if (answer) window.close();
    }
}
