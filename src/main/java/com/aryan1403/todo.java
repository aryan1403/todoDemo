package com.aryan1403;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.aryan1403.DB.Service;
import java.awt.Color;
import java.awt.Font;

public class todo extends JPanel {
    public todo(int index, int x, int y, String t) {
        JLabel label = new JLabel(index + ". "+t);
        label.setBounds(10, -5, 400, 50);
        label.setFont(new Font("Comic Sans", Font.PLAIN, 22));
        label.setForeground(Color.white);
        label.setLayout(null);

        JButton button = new JButton("Delete");
        button.setBounds(450, -5, 150, 50);
        button.setFocusable(false);
        button.setForeground(Color.white);
        button.setBackground(Color.red);
        button.setFont(new Font("Comic Sans", Font.BOLD + Font.ITALIC, 22));
        button.setLayout(null);
        button.addActionListener(e -> {
            todoApp.frame.remove(this);
            new Service().delete(index);
            todoApp.frame.repaint();
        });

        this.setBounds(x, y, 600, 40);
        this.setBackground(new Color(23, 23, 23));
        //this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
        this.setLayout(null);
        this.add(label);
        this.add(button);
    }
}