package tutorial.gui.swing;

import com.sun.media.sound.SoftTuning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventHandlingDemo {
    public static void main(String[] args) {
        JButton button = new JButton("Click Me!");
        button.addActionListener(e -> {
            System.out.println(e.getSource().toString());
            System.out.println("I am a button...");
        });

        JTextArea textArea = new JTextArea("", 5, 10);

        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Key typed: " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key pressed: " + e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Key released: " + e.getKeyChar());
            }
        });

        JScrollPane scrollPane = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(scrollPane);

        JFrame window = new JFrame("Event Handling Demo");
        window.add(panel);

        window.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Window opened: " + e.getWindow());
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window closing: " + e.getWindow());
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Window closed: " + e.getWindow());
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("Window iconified: " + e.getWindow());
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("Window deiconified: " + e.getWindow());
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("Window activated: " + e.getWindow());
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("Window deactivated: " + e.getWindow());
            }
        });

        window.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked: " + e.getPoint());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Mouse pressed: " + e.getPoint());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse released: " + e.getPoint());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse entered: " + e.getPoint());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse existed: " + e.getPoint());
            }
        });

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);  // In the center of the screen
        window.setSize(400, 400);
        window.setVisible(true);
    }
}
