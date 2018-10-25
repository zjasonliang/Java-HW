package tutorial.gui.swing;

import javax.swing.*;

public class RadioButtonDemo {
    public static void main(String[] args) {
        JRadioButton radioButton = new JRadioButton("Click Me!");

        JFrame window = new JFrame("Demo");
        window.add(radioButton);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
