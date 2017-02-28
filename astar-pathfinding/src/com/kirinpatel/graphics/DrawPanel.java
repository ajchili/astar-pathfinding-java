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
 * @version 0.5
 * @see javax.swing.JPanel
 * @see com.kirinpatel.util.Point
 * @see com.kirinpatel.util.Line
 */
public class DrawPanel extends JPanel {
    
    private int width, height;
    private Point[] points;
    private Line[] lines, path;
    
    /**
     * Main constructor that will setup the DrawPanel class.
     */
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
        
        createLines();
        getPath();
        
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
    
    public Point getStart() {
        for (Point p : points) {
            if (p.isStart())
                return p;
        }
        
        return null;
    }
    
    public Point getEnd() {
        for (Point p : points) {
            if (p.isEnd())
                return p;
        }
        
        return null;
    }
    
    public Line[] getLines() {
        return lines;
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
        if (points.length == 0)
            return;
        
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
    
    public void removeLine(int index) {
        if (lines.length == 0)
            return;
        
        int size = lines.length - 1;
        
        if (size == 0) {
            lines = new Line[0];
        } else {
            Line[] oldLines = lines;
            lines = new Line[size];
            
            for (int i = 0; i < index; i++) {
                lines[i] = oldLines[i];
            }
            
            for (int i = (index + 1); i < oldLines.length; i++) {
                lines[i - 1] = oldLines[i];
            }
        }
    }
    
    public boolean doesLineExist(Line l) {
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals(l)) {
                return true;
            }
        }
        
        return false;
    }
    
    public void createLines() {
        lines = new Line[0];
        
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if (!doesLineExist(new Line(points[i], points[j]))) {
                        if (!(points[i].isStart() || points[i].isEnd())) {
                            addLine(new Line(points[i], points[j]));
                        }
                    }
                }
            }
        }
    }
    
    public Line[] getConnectedLines(Point p) {
        Line[] connectedLines = new Line[0];
        
        for (int i = 0; i < lines.length; i++) {
            if (p.equals(new Point(lines[i].getX1(), lines[i].getY1())) || p.equals(new Point(lines[i].getX2(), lines[i].getY2()))) {
                int size = connectedLines.length + 1;
        
                Line[] oldLines = connectedLines;
                connectedLines = new Line[size];
                for (int j = 0; j < size; j++) {
                    if (j != oldLines.length) {
                        connectedLines[j] = oldLines[j];
                    } else {
                        connectedLines[i] = lines[i];
                    }
                }
            }
        }
        
        return connectedLines;
    }
    
    public Line[] getPath() {
        if (lines.length == 0 || getStart() == null || getEnd() == null)
            return null;
        
        boolean hasReachedEnd = false;
        Point currentLocation = getStart();
        double distanceToEnd = getStart().getDistance(getEnd());
        path = new Line[0];
        
        do {
            double newShortestDistance = 0;
            Point newLocation;
            
            if (currentLocation.equals(getEnd())) {
                hasReachedEnd = true;
            }
            
            Point[] possiblePoints = new Point[0];
            
            for (Point p : points) {
                if (p.getDistance(getEnd()) < distanceToEnd) {
                    int size = possiblePoints.length + 1;
                    Point[] oldPossiblePoints = possiblePoints;
                    possiblePoints = new Point[size];
                    for (int j = 0; j < size; j++) {
                        if (j != oldPossiblePoints.length) {
                            possiblePoints[j] = oldPossiblePoints[j];
                        } else {
                            possiblePoints[j] = p;
                        }
                    }
                } else if (p.getDistance(getEnd()) == 0) {
                    hasReachedEnd = true;
                }
            }
            
            System.out.println(possiblePoints.length);
            for (Point p : possiblePoints) {
                System.out.println(p.toString());
            }
            hasReachedEnd = true;
        } while(!hasReachedEnd);
        
        return path;
    }
}
