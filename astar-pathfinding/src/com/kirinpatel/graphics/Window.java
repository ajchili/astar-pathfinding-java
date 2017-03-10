/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.graphics;

import javax.swing.*;
import java.awt.*;

/**
 * This class will create the display in which the application is run.
 *
 * @author Kirin Patel
 * @version 1.1
 * @see javax.swing.JFrame;
 * @see com.kirinpatel.graphics.DrawPanel
 * @see com.kirinpatel.graphics.InputPanel
 */
public class Window extends JFrame {

    public DrawPanel drawPanel; // public final (?)

    /**
     * Main constructor that will create the Window.
     * @param s
     */
    public Window(String s) {
        // title is always "A* Pathfinding"
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
