package tutorial.gui.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class GridPaneDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(8);

        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");

        TextField username = new TextField();
        TextField password = new TextField();
        password.setPromptText("password");

        Button login = new Button("Log in");


        /*
         Sets the column,row indexes for the child when contained in a GridPane.
         Note: setConstraints() is a static method.
         */
        GridPane.setConstraints(usernameLabel, 0, 0);
        GridPane.setConstraints(passwordLabel, 0 ,1);
        GridPane.setConstraints(username, 1, 0);
        GridPane.setConstraints(password, 1, 1);
        GridPane.setConstraints(login, 0, 2);

        grid.getChildren().addAll(usernameLabel, passwordLabel, username, password, login);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
