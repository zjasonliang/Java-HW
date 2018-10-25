package tutorial.gui.javafx;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

import javafx.scene.control.Button;

/**
 * A quick demo of embedding layouts using BorderPane.
 */
public class BorderPaneDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox topMenu = new HBox();
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        topMenu.getChildren().addAll(btn1, btn2, btn3);

        VBox leftMenu = new VBox();
        Button btn4 = new Button("Button 4");
        Button btn5 = new Button("Button 5");
        Button btn6 = new Button("Button 6");
        leftMenu.getChildren().addAll(btn4, btn5, btn6);

        BorderPane layout = new BorderPane();
        layout.getChildren().addAll(topMenu, leftMenu);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
