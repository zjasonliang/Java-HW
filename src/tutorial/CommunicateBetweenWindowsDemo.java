package tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class CommunicateBetweenWindowsDemo extends Application {

    Stage window;
    Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;

        Button button = new Button("To confirm box");
        button.setOnAction(e -> {
            boolean result = ConfirmBox.display("Confirm", "Confirm or not?");
            System.out.println(result);
        });

        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);

        scene = new Scene(layout,600, 300);
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
