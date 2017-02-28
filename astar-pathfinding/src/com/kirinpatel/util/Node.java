/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.util;

import java.awt.Graphics;

/**
 *
 * @author Kirin Patel
 * @version 0.2
 * @see com.kirinpatel.util.Line
 * @see com.kirinpatel.util.Point
 */
public class Node {
    
    private Point point;
    private Point[] points;
    private Line[] lines, connectedLines;
    
    public Node(Point point, Point[] points, Line[] lines) {
        setPoint(point);
        setLines(lines);
        
        determineConnectedLines();
    }
    
    @Override
    public String toString() {
        determineConnectedLines();
        return "This node is located at " + point.toString() + " with " + connectedLines.length + " connected lines.";
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node)) {
            return false;
        } else {
            Node objN = (Node) o;
            return (point.equals(objN.getPoint()) && points.equals(objN.getPoints()) && connectedLines.equals(objN.getConnectedLines()));
        }
    }
    
    /**
     * Draws node with given graphics object.
     * 
     * @param g Graphics
     */
    public void draw(Graphics g) {
        point.draw(g);
        for (Line l : connectedLines) {
            l.draw(g);
        }
    }
    
    public Point getPoint() {
        return point;
    }
    
    public Point[] getPoints() {
        return points;
    }
    
    public Line[] getConnectedLines() {
        return connectedLines;
    }
    
    public int getX() {
        return point.getX();
    }
    
    public int getY() {
        return point.getY();
    }
    
    public boolean isConnected(Node node) {
        for (Line lineCheck : node.getConnectedLines()) {
            for (Line lineNode : connectedLines) {
                if (lineCheck.equals(lineNode))
                    return true;
            }
        }
        
        return false;
    }
    
    /**
     * Provides a node that is closer to the next point. This node will be
     * determined through the a* algorithm.
     * 
     * @param point Ending point
     * @return Returns next closes node to point
     */
    public Node determineNextStep(Point point) {
        determineConnectedLines();
        
        if (this.point.isEnd())
            return null;
        
        Point nextDestination = null;
        int size = 0;
        Point[] possiblePointsToBeNextNode = new Point[size];
        
        for (Line l : connectedLines) {
            Point startOfLine = new Point(l.getX1(), l.getY1(), this.point.isStart(), this.point.isEnd());
            Point endOfLine = new Point(l.getX2(), l.getY2(), this.point.isStart(), this.point.isEnd());
            
            size++;
            Point[] oldPossiblePointsToBeNextNode = possiblePointsToBeNextNode;
            possiblePointsToBeNextNode = new Point[size];
            Point possiblePoint = null;
            
            if (this.point.equals(startOfLine)) {
                possiblePoint = new Point(l.getX2(), l.getY2());
            } else {
                possiblePoint = new Point(l.getX1(), l.getY1());
            }
            
            for (Point p : points) {
                Point tempPoint = new Point(p.getX(), p.getY());
                if (tempPoint.equals(possiblePoint)) {
                    possiblePoint = p;
                    break;
                }
            }
            
            for (int i = 0; i < size; i++) {
                if (i != oldPossiblePointsToBeNextNode.length) {
                    possiblePointsToBeNextNode[i] = oldPossiblePointsToBeNextNode[i];
                } else {
                    possiblePointsToBeNextNode[i] = possiblePoint;
                }
            }
        }
        
        for (int i = 0; i < possiblePointsToBeNextNode.length; i++) {
            if (i != 0) {
                nextDestination = possiblePointsToBeNextNode[i];
            } else {
                // TODO: Finish this
            }
        }
        
        return new Node(nextDestination, points, lines);
    }
    
    public void setPoint(Point point) {
        this.point = point;
    }
    
    public void setPoints(Point[] points) {
        this.points = points;
    }
    
    public void setLines(Line[] lines) {
        this.lines = lines;
    }
    
    public void setConnectedLines(Line[] connectedLines) {
        this.connectedLines = connectedLines;
    }
    
    public void determineConnectedLines() {
        if (lines.length == 0)
            return;
        
        int size = 0;
        connectedLines = new Line[size];
        
        for (Line l : lines) {
            Point startOfLine = new Point(l.getX1(), l.getY1(), point.isStart(), point.isEnd());
            Point endOfLine = new Point(l.getX2(), l.getY2(), point.isStart(), point.isEnd());
            if (startOfLine.equals(point) || endOfLine.equals(point)) {
                size++;
            
                Line[] oldConnectedLines = connectedLines;
                connectedLines = new Line[size];
                for (int i = 0; i < size; i++) {
                    if (i != oldConnectedLines.length) {
                        connectedLines[i] = oldConnectedLines[i];
                    } else {
                        connectedLines[i] = l;
                    }
                }
            }
        }
    }
}
