/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.graphics;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Kirin Patel
 * @version 0.2
 * @see javax.swing.JFrame;
 */
public class Window extends JFrame {
    
    public DrawPanel drawPanel;
    
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
