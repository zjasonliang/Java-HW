package tutorial;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Tuna");
        box2.setSelected(true);

        Button orderBtn = new Button("Order new!");
        orderBtn.setOnAction(event -> {
            printOrder(box1, box2);
            primaryStage.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(box1, box2, orderBtn);

        primaryStage.setScene(new Scene(layout, 300, 200));
        primaryStage.show();
    }

    private void printOrder(CheckBox box1, CheckBox box2) {
        System.out.println("Customer's order:");
        if (box1.isSelected())
            System.out.println(box1.getText());
        if (box2.isSelected())
            System.out.println(box2.getText());
    }
}
