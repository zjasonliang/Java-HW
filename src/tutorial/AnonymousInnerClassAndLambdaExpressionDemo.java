package tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AnonymousInnerClassAndLambdaExpressionDemo extends Application{


    Stage window;
    Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;

        Button button = new Button();
        button.setText("Using Anonymous Inner Class");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button 1 clicked");
            }
        });

        Button button2 = new Button();
        button2.setText("Using Lambda Expression");
        // button2.setLayoutX(10);
        // button2.setLayoutY(100);
        button2.setOnAction(e -> {
            System.out.println("Button 2 clicked");
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(button, button2);

        scene = new Scene(layout,600, 300);

        window.setScene(scene);
        window.setTitle("Scene Title");
        window.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
