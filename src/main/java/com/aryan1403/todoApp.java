package com.aryan1403;

import java.awt.Font;
import java.util.Iterator;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.aryan1403.DB.Service;

import org.bson.Document;

public class todoApp {
    static JFrame frame;
    JTextField textField;
    JButton button = new JButton("OK");

    private final int x = 50;
    private int y = 200;
    private int index = 1;
    public todoApp() {
        textField = new JTextField();
        textField.setFont(new Font("Aerial", Font.PLAIN, 20));
        textField.setBounds(100, 100, 400, 40);
        textField.setBackground(new Color(23, 23, 23));
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.white));
        textField.setForeground(Color.white);
        textField.setLayout(null);

        button.setBounds(550, 100, 100, 50);
        button.setFocusable(false);
        button.setForeground(Color.white);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.white));
        button.setFont(new Font("Comic Sans", Font.BOLD + Font.ITALIC, 25));
        button.setLayout(null);
        button.addActionListener(e -> {
            frame.add(new todo(index, x, y, textField.getText()));
            frame.repaint();
            new Service().addTodo(index, textField.getText());
            y += 50;
            index++;
        });

        frame = new JFrame();
        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(23, 23, 23));
        frame.add(textField);
        frame.add(button);
        Iterator<Document> it = new Service().getAllTodo().iterator();

        while(it.hasNext()) {
            Document doc = it.next();
            frame.add(new todo(Integer.parseInt(doc.get("id").toString()), x, y, doc.get("todo").toString()));
            y += 50;
        }
        frame.setVisible(true);
    }
}