/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.util;

/**
 * This class contains all information pertaining to the Line class.
 * 
 * @author Kirin Patel
 * @version 1.0
 */
public class Line {
    
    private double x1, y1, x2, y2;
    
    /**
     * Main constructor that will create a line with provided start and end
     * coordinates.
     * 
     * @param x1 Starting x coordinate
     * @param y1 Starting y coordinate
     * @param x2 Ending x coordinate
     * @param y2 Ending y coordinate
     */
    public Line(double x1, double y1, double x2, double y2) {
        setStart(x1, y1);
        setEnd(x2, y2);
    }
    
    /**
     * Secondary constructor that will create a line based upon the coordinates
     * of two points.
     * 
     * @param p1 Point 1
     * @param p2 Point 2
     */
    public Line(Point p1, Point p2) {
        setStart(p1.getX(), p1.getY());
        setEnd(p2.getX(), p2.getY());
    }
    
    /**
     * Provides the starting x coordinate.
     * 
     * @return Returns starting x coordinate
     */
    public double getX1() {
        return x1;
    }
    
    /**
     * Provides the starting y coordinate.
     * 
     * @return Returns starting y coordinate
     */
    public double getY1() {
        return y1;
    }
    
    /**
     * Provides the ending x coordinate.
     * 
     * @return Returns ending x coordinate
     */
    public double getX2() {
        return x2;
    }
    
    /**
     * Provides the ending y coordinate.
     * 
     * @return Returns ending y coordinate
     */
    public double getY2() {
        return y2;
    }
    
    /**
     * Provides the length of the line.
     * 
     * @return Length of line
     */
    public double getLength() {
        return Math.sqrt((Math.pow(Math.abs(x2) - Math.abs(x1),2) + Math.pow(Math.abs(y2) - Math.abs(y1), 2)));
    }
    
    /**
     * Sets the starting x coordinate.
     * 
     * @param x Starting x coordinate
     */
    public void setStartingX(double x) {
        this.x1 = x;
    }
    
    /**
     * Sets the starting y coordinate.
     * 
     * @param y Starting y coordinate
     */
    public void setStartingY(double y) {
        this.y1 = y;
    }
    
    /**
     * Sets the starting point.
     * 
     * @param x Starting x coordinate
     * @param y Starting y coordinate
     */
    public void setStart(double x, double y) {
        setStartingX(x);
        setStartingY(y);
    }
    
    /**
     * Sets the ending x coordinate.
     * 
     * @param x Ending x coordinate
     */
    public void setEndingX(double x) {
        this.x2 = x;
    }
    
    /**
     * Sets the ending y coordinate.
     * 
     * @param y Ending y coordinate
     */
    public void setEndingY(double y) {
        this.y2 = y;
    }
    
    /**
     * Sets the ending point.
     * 
     * @param x Ending x coordinate
     * @param y Ending y coordinate
     */
    public void setEnd(double x, double y) {
        setEndingX(x);
        setEndingY(y);
    }
}
