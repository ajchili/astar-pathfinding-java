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
 * @version 0.4
 * @see com.kirinpatel.util.Line
 * @see com.kirinpatel.util.Point
 */
public class Node extends Point {
    
    private Point point;
    private Point[] points;
    private Line[] lines, connectedLines;
    
    public Node(Point point, Point[] points, Line[] lines) {
        super(point.getX(), point.getY());
        
        setPoint(point);
        setPoints(points);
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
    
    public Line[] getLines() {
        return lines;
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
    public Node determineNextStep(Point point, Point[] traveledPoints) {
        determineConnectedLines();
        
        /**
         * Checks to see if this Node is the end
         */
        if (this.point.isEnd() || this.point.equals(point))
            return this;
        
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
            
            /**
             * Determine location of point
             */
            if (this.point.equals(startOfLine)) {
                possiblePoint = endOfLine;
            } else {
                possiblePoint = startOfLine;
            }
            
            /**
             * Get real point
             */
            for (Point p : points) {
                Point tempPoint = new Point(p.getX(), p.getY());
                if (tempPoint.equals(possiblePoint)) {
                    possiblePoint = p;
                    break;
                }
            }
            
            /**
             * Add point to array
             */
            for (int i = 0; i < size; i++) {
                if (i != oldPossiblePointsToBeNextNode.length) {
                    possiblePointsToBeNextNode[i] = oldPossiblePointsToBeNextNode[i];
                } else {
                    possiblePointsToBeNextNode[i] = possiblePoint;
                }
            }
        }
        
        for (int i = 0; i < possiblePointsToBeNextNode.length; i++) {
            if (i == 0) {
                nextDestination = possiblePointsToBeNextNode[i];
            } else {
                if (possiblePointsToBeNextNode[i].isEnd()) {
                    nextDestination = possiblePointsToBeNextNode[i];
                    break;
                } else if (!possiblePointsToBeNextNode[i].isStart() && this.point.getDistance(possiblePointsToBeNextNode[i]) < this.point.getDistance(nextDestination)) {
                    if (possiblePointsToBeNextNode[i].getDistance(point) < nextDestination.getDistance(point)) {
                        boolean canBeNextPoint = true;
                        for (Point p : traveledPoints) {
                            if (possiblePointsToBeNextNode[i].equals(p))
                                canBeNextPoint = false;
                        }
                        
                        if (canBeNextPoint)
                            nextDestination = possiblePointsToBeNextNode[i];
                    }
                }
            }
        }
        
        /**
         * 
         */
        Point[] oldTraveledPoints = traveledPoints;
        traveledPoints = new Node[oldTraveledPoints.length];
        for (int i = 0; i < oldTraveledPoints.length; i++) {
            traveledPoints[i] = oldTraveledPoints[i];
        }
        traveledPoints[traveledPoints.length - 1] = nextDestination;
        
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
