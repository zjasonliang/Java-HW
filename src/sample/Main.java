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
    Scene scene1, scene2, scene3;

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

        Button button3 = new Button("go to alert box test");
        button3.setOnAction(event -> window.setScene(scene3));


        // layout 2: stack pane
        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(label2, button2, button3);

        scene2 = new Scene(layout2, 600, 300);





        window.setScene(scene1);
        window.setTitle("fuuuuuuuuuck");
        window.show();





        Button button = new Button();
        button.setText("fuck");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("fuck.....");
            }
        });

        Button btn2 = new Button();
        btn2.setText("click me");
        // btn2.setLayoutX(10);
        // btn2.setLayoutY(100);
        btn2.setOnAction(e -> AlertBox.display("Title of the window", "This alert box is awesome."));

        Button btn3 = new Button();
        btn3.setText("fuck you?");
        // btn3.setLayoutX(10);
        // btn3.setLayoutY(100);
        btn3.setOnAction(e -> {
            System.out.println("fuck!!!!!!!!");
            System.out.println("wooooooow");
        });

        VBox layout3 = new VBox(10);
        if (false) {
            layout3.getChildren().add(button);
            layout3.getChildren().add(btn2);
            layout3.getChildren().add(btn3);
        } else {
            layout3.getChildren().addAll(button, btn2, btn3);
        }

        scene3 = new Scene(layout3,600, 300);

    }


    public static void main(String[] args) {
        launch(args);
    }


}
