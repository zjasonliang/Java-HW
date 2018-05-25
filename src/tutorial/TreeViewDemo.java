package tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeViewDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        TreeItem<String> apple = new TreeItem <>("Apple");
        TreeItem<String> banana = new TreeItem <>("Banana");
        TreeItem<String> kiwi = new TreeItem <>("Kiwi");
        TreeItem<String> passionFruit = new TreeItem <>("Passion Fruit");
        TreeItem<String> fruits = new TreeItem <>("Fruits");
        // Set expanded as default
        fruits.setExpanded(true);
        // TODO: Unchecked generics array creation for varargs parameter?
        fruits.getChildren().addAll(apple, banana, kiwi, passionFruit);


        TreeItem<String> cola = new TreeItem <>("Cola");
        TreeItem<String> sprite = new TreeItem <>("Sprite");
        TreeItem<String> sevenup = new TreeItem <>("7-Up");
        TreeItem<String> mtndew = new TreeItem <>("Mountain Dew");
        TreeItem<String> drinks = new TreeItem <>("Drinks");
        drinks.getChildren().addAll(cola, sprite, sevenup, mtndew);


        TreeItem<String> root = new TreeItem <>();
        root.getChildren().addAll(fruits, drinks);

        TreeView<String> treeView = new TreeView <>(root);
        // Hide the root node
        treeView.setShowRoot(false);

        // Add a listener to capture selection events
        treeView.getSelectionModel()
                .selectedItemProperty()
                .addListener( (observable, oldValue, newValue) -> {
                    if (newValue != null)
                        System.out.println(newValue.getValue());
                });

        StackPane layout = new StackPane();
        layout.getChildren().add(treeView);

        primaryStage.setScene(new Scene(layout, 300, 250));
        primaryStage.show();

    }
}
