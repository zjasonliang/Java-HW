package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import sun.nio.ch.sctp.SctpNet;

import javax.swing.*;

public class Main extends Application{


    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        // primaryStage.setTitle("Nemonic");
        // primaryStage.setScene(new Scene(root, 600, 400));

        window = primaryStage;







        Label label1 = new Label("welcome to the first scene");
        Button button1 = new Button("go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2));

        // layout 1: children are laid out in vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);

        scene1 = new Scene(layout1, 600, 300);


        



        Label label2 = new Label("welcome to the second scene");
        Button button2 = new Button("go back to  scene 1");
        button2.setOnAction(e -> window.setScene(scene1));

        // layout 2: stack pane
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(label2, button2);

        scene2 = new Scene(layout2, 600, 300);





        window.setScene(scene1);
        window.setTitle("fuuuuuuuuuck");
        window.show();





        Button button = new Button();
        button.setText("fuck you");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("fuck.....");
            }
        });

        Button btn2 = new Button();
        btn2.setText("fuck you again!");
        btn2.setLayoutX(10);
        btn2.setLayoutY(100);
        btn2.setOnAction(e -> System.out.println("fuck!!!!!!!!"));

        Button btn3 = new Button();
        btn3.setText("fuck you?");
        btn3.setLayoutX(10);
        btn3.setLayoutY(100);
        btn3.setOnAction(e -> {
            System.out.println("fuck!!!!!!!!");
            System.out.println("wooooooow");
        });

        if (true) {
            StackPane layout = new StackPane();
            layout.getChildren().add(button);
            layout.getChildren().add(btn2);
            layout.getChildren().add(btn3);
        } else {
            VBox layout = new VBox(20);
            layout.getChildren().addAll(button, btn2, btn3);
        }

        // Scene scene = new Scene(layout, 600, 400);
        // primaryStage.setTitle("Nemonic");
        // primaryStage.setScene(scene);

        // primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
