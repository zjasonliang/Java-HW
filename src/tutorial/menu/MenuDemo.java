package tutorial.menu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Menu newProjectMenu = new Menu("New Project...");
        newProjectMenu.getItems().add(new Menu("From..."));

        Menu fileMenu = new Menu("File");

        fileMenu.getItems().add(newProjectMenu);
        fileMenu.getItems().add(new Menu("New Module..."));
        fileMenu.getItems().add(new Menu("New Project"));
        fileMenu.getItems().add(new Menu("Import Project..."));

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);

        primaryStage.setScene(new Scene(borderPane, 400, 300));
        primaryStage.show();

    }
}
