package tutorial.gui.swing;

import javax.swing.*;

public class CheckBoxDemo {
    public static void main(String[] args) {
        JCheckBox checkBox = new JCheckBox("Check Me!");

        JFrame window = new JFrame("Demo");
        window.add(checkBox);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
