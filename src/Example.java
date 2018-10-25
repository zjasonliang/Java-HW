import javafx.scene.web.HTMLEditor;

import java.net.URL;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.html.HTMLEditorKit;

import java.nio.charset.*;


public class Example {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet <>((a, b) -> {
            if (a.equals(b)) return -1;
            return a - b;
        });

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        set.add(3);
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(6);
        set.add(4);
        System.out.println(set);
        set.remove(3);
        System.out.println(set);
        System.out.println(set.first());
        for (Integer i : set)
            System.out.println(i);
    }
}