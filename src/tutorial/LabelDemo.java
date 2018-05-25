package tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LabelDemo extends Application{


    Stage window;
    Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;

        Label label = new Label("Welcome to this Label Demo.");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label);

        scene = new Scene(layout,600, 300);

        window.setScene(scene);
        window.setTitle("Scene Title");
        window.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
