package tutorial.gui.swing;

import javax.swing.*;
import javax.swing.border.Border;

public class BorderDemo {
    public static void main(String[] args) {
        JCheckBox checkBox1 = new JCheckBox("Check Me!");
        JCheckBox checkBox2 = new JCheckBox("Check Me Again!");
        JCheckBox checkBox3 = new JCheckBox("One More Time!");

        Border border = BorderFactory.createTitledBorder("Check these out:");

        JPanel panel = new JPanel();
        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);
        panel.setBorder(border);

        JFrame window = new JFrame("Demo");
        window.add(panel);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
