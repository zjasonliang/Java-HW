package tutorial.gui.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExtractAndValidateDataDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TextField text = new TextField();

        Button printBtn = new Button("Print");

        printBtn.setOnAction( event -> {
            // TODO: What is the difference between these two?
            System.out.println(text.getCharacters());
            System.out.println(text.getText());

            // Do some validation here...
        });

        VBox layout = new VBox();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setSpacing(8); // this is equal to "vBox = new VBox(8)"

        layout.getChildren().addAll(text, printBtn);

        primaryStage.setScene(new Scene(layout, 300, 200));
        primaryStage.show();
    }
}
