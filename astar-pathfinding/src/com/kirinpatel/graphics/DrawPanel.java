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
 * @version 0.2
 * @see javax.swing.JPanel
 * @see com.kirinpatel.util.Point
 */
public class DrawPanel extends JPanel {
    
    private int width, height;
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
        
        width = getWidth();
        height = getHeight();
        System.out.println(width + " " + height);
        
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        for (int i = 0; i < points.length; i++) {
            g.setColor(Color.YELLOW);
            g.fillOval((int) points[i].getX(), (int) points[i].getY(), 10, 10);
        }
    }
    
    public Point[] getPoints() {
        return points;
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
        
        repaint();
    }
    
    public void removePoint(int index) {
        int size = points.length - 1;
        
        if (size == 0) {
            points = new Point[0];
        } else {
            Point[] oldPoints = points;
            points = new Point[size];
            
            for (int i = 0; i < index; i++) {
                points[i] = oldPoints[i];
            }
            
            for (int i = (index + 1); i < oldPoints.length; i++) {
                points[i - 1] = oldPoints[i];
            }
        }

        repaint();
    }
    
    public void editPoint(int index, Point p) {
        points[index] = p;
        
        repaint();
    }
}
