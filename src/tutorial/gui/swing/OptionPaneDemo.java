package tutorial.gui.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionPaneDemo {
    public static void main(String[] args) {
        JFrame window = new JFrame("Demo");

        JButton button1 = new JButton("Pop Message Dialog");
        button1.addActionListener(e -> {
            JOptionPane.showMessageDialog(window,
                    "Here is the message.",
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        JButton button2 = new JButton("Pop Option Pane");
        button2.addActionListener(e -> {
            JOptionPane.showConfirmDialog(window,
                    "Are you sure?",
                    "Confirm",
                    JOptionPane.YES_NO_CANCEL_OPTION);
        });

        JPanel panel = new JPanel();
        panel.add(button1);
        panel.add(button2);
        window.add(panel);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
