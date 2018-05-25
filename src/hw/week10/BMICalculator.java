/*
*
*
*
*
 */

package hw.week10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

enum Gender {
    FEMALE,
    MALE
}

class MessageBox {
    public static void display(String title, String message, String buttonString) {
        Stage window = new Stage();

        // block input events or useer interactions with other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(300);
        window.setHeight(250);

        Label label = new Label();
        label.setText(message);
        label.setWrapText(true);
        Button closeButton = new Button(buttonString);
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(30);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait(); // often in conjunction with 'Modality.APPLICATION_MODAL'
    }
}

public class BMICalculator extends Application {

    private double weight;
    private double height;
    private Gender gender;
    private double bmi;


    public void setWeight(double weight) {
        if (weight <= 0) throw new IllegalArgumentException("Weight must be greater than 0!");
        else this.weight = weight;
    }

    public void setHeight(double height) {
        if (height <= 0) throw new IllegalArgumentException("Height must be greater than 0!");
        else this.height = height;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getBmi() {
        if (this.bmi == 0) {
            this.bmi = this.weight / (this.height * this.height);
        }

        return bmi;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Label genderLabel = new Label("Gender: ");
        ChoiceBox<Gender> genderChoiceBox = new ChoiceBox <> ();
        genderChoiceBox.getItems().addAll(Gender.FEMALE, Gender.MALE);
        genderChoiceBox.setValue(Gender.FEMALE);

        HBox genderBox = new HBox(10);
        genderBox.setPadding(new Insets(10, 10, 10, 10));
        genderBox.setAlignment(Pos.CENTER);
        genderBox.getChildren().addAll(genderLabel, genderChoiceBox);


        Label weightLabel = new Label("Weight: ");
        TextField weightField = new TextField("50");
        weightField.setPrefWidth(50);
        Label weightUnitLabel = new Label("kg");
        HBox weightBox = new HBox(10);
        weightBox.setPadding(new Insets(10, 10, 10, 10));
        weightBox.setAlignment(Pos.CENTER);
        weightBox.getChildren().addAll(weightLabel, weightField, weightUnitLabel);


        Label heightLabel = new Label("Height: ");
        TextField heightField = new TextField("165");
        heightField.setPrefWidth(50);
        Label heightUnitLabel = new Label("cm");
        HBox heightBox = new HBox(10);
        heightBox.setPadding(new Insets(10, 10, 10, 10));
        heightBox.setAlignment(Pos.CENTER);
        heightBox.getChildren().addAll(heightLabel, heightField, heightUnitLabel);

        Button calculateBtn = new Button("Calculate Now!");
        calculateBtn.setPrefWidth(120);
        calculateBtn.setOnAction( event -> {

            this.gender = genderChoiceBox.getValue();

            try {
                this.height = Double.parseDouble(heightField.getText()) / 100;
            } catch (NumberFormatException e) {
                if ("".equals(heightField.getText()))
                    MessageBox.display("Input Error",
                                        "Height is missing.",
                                        "Close");
                else
                    MessageBox.display("Input Error",
                                        "The height you entered is not a valid number.",
                                        "Close");
                return;
            }

            try {
                this.weight = Double.parseDouble(weightField.getText());
            } catch (NumberFormatException e) {
                if ("".equals(weightField.getText()))
                    MessageBox.display("Input Error",
                                            "Weight is missing.",
                                            "Close");
                else
                    MessageBox.display("Input Error",
                                        "The weight you entered is not a valid number.",
                                        "Close");
                return;
            }


            StringBuilder message = new StringBuilder();

            message.append("Your BMI is ");
            message.append(String.format("%.2f", getBmi()));
            message.append(".\n\n");
            message.append("BMI Categories:\n\n");
            message.append("\tUnderweight =< 18.5\n");
            message.append("\tNormal weight = 18.5–24.9\n");
            message.append("\tOverweight = 25–29.9\n");
            message.append("\tObesity = BMI of 30 or greater\n");

            MessageBox.display("Your BMI",
                                message.toString(),
                                "Ok");


        });


        HBox buttonBox = new HBox(10);
        buttonBox.setPadding(new Insets(10, 10, 10, 10));
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(calculateBtn);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(genderBox, weightBox, heightBox, buttonBox);

        primaryStage.setTitle("BMI Calculator");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(layout, 300, 250));
        primaryStage.show();

    }
}


