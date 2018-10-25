package tutorial.gui.swing;

import javax.swing.*;

public class JPanelDemo extends JPanel {
    public JPanelDemo() {
        JLabel label = new JLabel("Tell me something.");

        // Prompt (The text displays when the cursor lingers over the component.)
        label.setToolTipText("Doesn't do anything.");
        this.add(label);

        JButton button = new JButton("Click Me!");
        button.setToolTipText("It's a button.");
        this.add(button);

        JTextField textField = new JTextField("Type something here...");
        textField.setColumns(10);
        // Get focused with the mouse when the window are created.
        textField.requestFocus();
        this.add(textField);

        JTextArea textArea = new JTextArea(15, 20);
        textArea.setText("Just a whole bunch of text that is important.");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        this.add(textArea);
    }

    public static void main(String[] args) {
        JPanel panel = new JPanelDemo();

        JFrame window = new JFrame("JPanel Demo");
        window.add(panel);
        window.setSize(340, 400);
        window.setLocationRelativeTo(null);  // In the center of the screen
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
