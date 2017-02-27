/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.graphics;

import com.kirinpatel.util.Point;
import com.kirinpatel.util.Line;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Kirin Patel
 * @version 0.3
 * @see javax.swing.JPanel
 * @see com.kirinpatel.util.Point
 */
public class DrawPanel extends JPanel {
    
    private int width, height;
    private Point[] points;
    private Line[] lines;
    
    public DrawPanel() {
        super();
        points = new Point[0];
        lines = new Line[0];
    }
    
    /**
     * Displays given graphics to the screen.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        width = getWidth();
        height = getHeight();
        
        getLines();
        
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        g.setColor(Color.ORANGE);
        for (int i= 0; i < lines.length; i++) {
            g.drawLine((int) lines[i].getX1() + 5, (int) lines[i].getY1() + 5, (int) lines[i].getX2() + 5, (int) lines[i].getY2() + 5);
        }
        
        for (int i = 0; i < points.length; i++) {
            if (points[i].isStart()) {
                g.setColor(Color.GREEN);
                g.fillRoundRect((int) points[i].getX(), (int) points[i].getY(), 10, 10, 5, 5);
            } else if (points[i].isEnd()) {
                g.setColor(Color.BLUE);
                g.fillRoundRect((int) points[i].getX(), (int) points[i].getY(), 10, 10, 5, 5);
            } else {
                g.setColor(Color.YELLOW);
                g.fillOval((int) points[i].getX(), (int) points[i].getY(), 10, 10);
            }
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
    
    public void setStart(int index) {
        for (int i = 0; i < points.length; i++) {
            if (i != index) {
                points[i].setIsStart(false);
            } else {
                points[i].setIsStart(true);
            }
        }
        
        repaint();
    }
    
    public void setEnd(int index) {
        for (int i= 0; i < points.length; i++) {
            if (i != index) {
                points[i].setIsEnd(false);
            } else {
                points[i].setIsEnd(true);
            }
        }
        
        repaint();
    }
    
    public void addLine(Line l) {
        int size = lines.length + 1;
        
        Line[] oldLines = lines;
        lines = new Line[size];
        for (int i = 0; i < size; i++) {
            if (i != oldLines.length) {
                lines[i] = oldLines[i];
            } else {
                lines[i] = l;
            }
        }
    }
    
    public void getLines() {
        lines = new Line[0];
        
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    addLine(new Line(points[i], points[j]));
                }
            }
        }
    }
}
