package tutorial.gui.swing;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo extends JFrame {
    public JFrameDemo(String title) {
        super(title);
        this.setSize(400, 400);
        // Sets the location of the window relative to the specified component. (Here it's null)
        // this.setLocationRelativeTo(null);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        int xPosition = (dimension.width / 2) - (this.getWidth() / 2);
        int yPosition = (dimension.height / 2) - (this.getHeight() / 2);

        this.setLocation(xPosition, yPosition);

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame window = new JFrameDemo("Demo");
    }
}
