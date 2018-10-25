package tutorial.gui.javafx.fxml_demos.primary;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class Controller {
    public Button submitBtn;
    public void pressButton(ActionEvent event) {
        System.out.println("Hello World!");
        submitBtn.setText("Stop Touching Me!");
    }
}
