package tutorial.gui.swing;

import javax.swing.*;

public class ButtonGroupDemo {
    public static void main(String[] args) {
        JCheckBox checkBox1 = new JCheckBox("Check Me!");
        JCheckBox checkBox2 = new JCheckBox("Check Me Again!");
        JCheckBox checkBox3 = new JCheckBox("One More Time!");

        /*
        ButtonGroup: Whenever one of the buttons in the group
        is selected, the other ones will be deselected.
         */
        ButtonGroup buttonGroup = new ButtonGroup();

        buttonGroup.add(checkBox1);
        buttonGroup.add(checkBox2);
        buttonGroup.add(checkBox3);

        JPanel panel = new JPanel();
        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);

        JFrame window = new JFrame("Demo");
        window.add(panel);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
