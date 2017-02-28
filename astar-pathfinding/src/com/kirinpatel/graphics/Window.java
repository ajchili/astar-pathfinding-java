/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.graphics;

import java.awt.*;
import javax.swing.*;

/**
 * This class will create the display in which the application is run.
 * 
 * @author Kirin Patel
 * @version 1.0
 * @see javax.swing.JFrame;
 * @see com.krinpatel.graphics.DrawPanel
 * @see com.kirinpatel.graphics.InputPanel
 */
public class Window extends JFrame {
    
    public DrawPanel drawPanel;
    
    /**
     * Main constructor that will create the Window.
     * 
     * @param title Title
     */
    public Window(String title) {
        super(title);
        
        setSize(1280, 720);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(640, 480));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);
        add(new InputPanel(), BorderLayout.SOUTH);
        
        setVisible(true);
    }
}
