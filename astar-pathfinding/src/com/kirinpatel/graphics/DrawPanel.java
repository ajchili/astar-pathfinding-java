/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.graphics;

import java.awt.*;
import javax.swing.*;
import com.kirinpatel.util.Point;

/**
 *
 * @author Kirin Patel
 * @version 0.1
 * @see javax.swing.JPanel
 * @see com.kirinpatel.util.Point
 */
public class DrawPanel extends JPanel {
    
    private Point[] points;
    
    public DrawPanel() {
        super();
        points = new Point[0];
    }
    
    /**
     * Displays given graphics to the screen.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
    
    public void addPoint(Point p) {
        int size = points.length + 1;
        
        Point[] oldPoints = points;
        points = new Point[size];
        for (int i = 0; i < size; i++) {
            if (i != oldPoints.length) {
                points[i] = oldPoints[i];
            } else {
                points[i] = p;
            }
        }
    }
}
