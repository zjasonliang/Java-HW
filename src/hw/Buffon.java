package hw;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import java.lang.Math;
import java.text.Format;


public class Buffon extends Application {
    public static final int NEEDLE_LEN = 10;
    public static final int INTERVAL = NEEDLE_LEN * 2;
    public static final int WINDOW_HEIGHT = 400;
    public static final int WINDOW_WIDTH = 800;
    public static final int NUM_TRIALS = 4000;

    @Override
    public void start(Stage stage) {
        // Creating a group
        Group group = new Group();

        for (int i = 0; i < WINDOW_HEIGHT / INTERVAL; i ++) {
            Line line = new Line(0, i * INTERVAL, WINDOW_WIDTH, i * INTERVAL);
            group.getChildren().add(line);
        }

        // Simulate
        int count = 0;
        for (long i = 0; i < NUM_TRIALS; i++) {
            double centerX = random() * WINDOW_WIDTH;
            double centerY = random() * WINDOW_HEIGHT;
            double angle = randomAngle();
            double startX = centerX - Math.cos(angle) * NEEDLE_LEN / 2;
            double startY = centerY - Math.sin(angle) * NEEDLE_LEN / 2;
            double endX = centerX + Math.cos(angle) * NEEDLE_LEN / 2;
            double endY = centerY + Math.sin(angle) * NEEDLE_LEN / 2;
            Line line = new Line(startX, startY, endX, endY);
            line.setStroke(Color.RED);
            group.getChildren().add(line);

            double centerYAbs = Math.abs(centerY);
            if (fraction(centerYAbs) > 0.75) {
                double slack = sinAbs(angle) * 0.25 + fraction(centerYAbs);
                if (slack > 1) count++;
            } else if (fraction(centerYAbs) < 0.25) {
                double slack = sinAbs(angle) * 0.25;
                if (slack > fraction(centerYAbs)) count++;
            }
        }

        // print the value of pi on the canvas
        double pi = NUM_TRIALS / (double) count;
        Rectangle box = new Rectangle(WINDOW_WIDTH / 10, WINDOW_HEIGHT / 10, Color.WHITE);
        box.setX(0);
        box.setY(0);
        Text text = new Text(10, 20, String.format("Pi = %.3f", pi));
        text.setFill(Color.BLUE);
        group.getChildren().addAll(box, text);
        System.out.println(pi);

        Scene scene = new Scene(group, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Buffon Simulation");
        stage.setScene(scene);
        stage.show();
    }

    private double fraction(double num) {return num - Math.floor(num); }
    private double random() {return Math.random(); }
    private double randomAngle() {return Math.random() * 100000;}
    private double sinAbs(double angle) {return Math.abs(Math.sin(angle));}

    public static void main(String args[]){
        launch(args);
    }
}
