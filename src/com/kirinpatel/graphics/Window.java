package com.kirinpatel.graphics;

import javax.swing.*;
import java.awt.*;
public class Window extends JFrame {

    public DrawPanel drawPanel;

    public Window() {
        super("A* Pathfinding");

        setSize(1280, 720);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(640, 480));
        setMaximumSize(new Dimension(1280, 720));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);
        add(new InputPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }
}
