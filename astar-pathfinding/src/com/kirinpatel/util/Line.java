/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.util;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class contains all information pertaining to the Line class.
 * 
 * @author Kirin Patel
 * @version 1.2
 * @see java.awt.Color
 * @see java.awt.Graphics
 */
public class Line {
    
    private int x1, y1, x2, y2;
    
    /**
     * Main constructor that will create a line with provided start and end
     * coordinates.
     * 
     * @param x1 Starting x coordinate
     * @param y1 Starting y coordinate
     * @param x2 Ending x coordinate
     * @param y2 Ending y coordinate
     */
    public Line(int x1, int y1, int x2, int y2) {
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
     * Provides a printable version of the Line class.
     * 
     * @return String version of Line
     */
    @Override
    public String toString() {
        return "This line starts at ( " + x1 + " , " + y1 + " ) and runs to ( " + x2 + " , " + y2 + " ). Its length is " + getLength() + ".";
    }
    
    /**
     * Provides if given object is equal to this Line.
     * 
     * @param o Object
     * @return Returns if object is equal to line
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Line)) {
            return false;
        } else {
            Line objL = (Line) o;
            boolean exactSame = ((x1 == objL.getX1()) && (y1 == objL.getY1()) && (x2 == objL.getX2()) && (y2 == objL.getY2()));
            boolean flipped = ((x1 == objL.getX2()) && (y1 == objL.getY2()) && (x2 == objL.getX1()) && (y2 == objL.getY1()));
            
            return exactSame || flipped;
        }
    }
    
    /**
     * Draws line with given graphics object.
     * 
     * @param g Graphics
     */
    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.drawLine(x1 + 5, y1 + 5, x2 + 5, y2 + 5);
    }
    
    /**
     * Provides the starting x coordinate.
     * 
     * @return Returns starting x coordinate
     */
    public int getX1() {
        return x1;
    }
    
    /**
     * Provides the starting y coordinate.
     * 
     * @return Returns starting y coordinate
     */
    public int getY1() {
        return y1;
    }
    
    /**
     * Provides the ending x coordinate.
     * 
     * @return Returns ending x coordinate
     */
    public int getX2() {
        return x2;
    }
    
    /**
     * Provides the ending y coordinate.
     * 
     * @return Returns ending y coordinate
     */
    public int getY2() {
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
    public void setStartingX(int x) {
        this.x1 = x;
    }
    
    /**
     * Sets the starting y coordinate.
     * 
     * @param y Starting y coordinate
     */
    public void setStartingY(int y) {
        this.y1 = y;
    }
    
    /**
     * Sets the starting point.
     * 
     * @param x Starting x coordinate
     * @param y Starting y coordinate
     */
    public void setStart(int x, int y) {
        setStartingX(x);
        setStartingY(y);
    }
    
    /**
     * Sets the ending x coordinate.
     * 
     * @param x Ending x coordinate
     */
    public void setEndingX(int x) {
        this.x2 = x;
    }
    
    /**
     * Sets the ending y coordinate.
     * 
     * @param y Ending y coordinate
     */
    public void setEndingY(int y) {
        this.y2 = y;
    }
    
    /**
     * Sets the ending point.
     * 
     * @param x Ending x coordinate
     * @param y Ending y coordinate
     */
    public void setEnd(int x, int y) {
        setEndingX(x);
        setEndingY(y);
    }
}
