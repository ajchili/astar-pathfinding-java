/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.util;

/**
 * This class contains all information pertaining to the Point class.
 * 
 * @author Kirin Patel
 * @version 1.3
 */
public class Point {
    
    private double x, y;
    private boolean isStart, isEnd;
    
    /**
     * Main constructor that will set the x and y coordinate for a point.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Point(double x, double y) {
        setX(x);
        setY(y);
    }
    
    /**
     * Secondary constructor that will set the x and y coordinate for a point
     * and will also set if a point is the start or end of a path.
     * 
     * @param x X coordinate
     * @param y Y coordinate
     * @param isStart Is start
     * @param isEnd Is end
     */
    public Point(double x, double y, boolean isStart, boolean isEnd) {
        setX(x);
        setY(y);
        setIsStart(isStart);
        setIsEnd(isEnd);
    }
    
    /**
     * Provides a printable version of the Point class.
     * 
     * @return String version of Point
     */
    @Override
    public String toString() {
        return "( " + x + " , " + y + " )";
    }
    
    /**
     * Provides if given object is equal to this Point.
     * 
     * @param o Object
     * @return Returns if object is equal to point
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) {
            return false;
        } else {
            Point objP = (Point) o;
            return ((getX() == objP.getX()) && (getY() == objP.getY()) && (isStart == objP.isStart()) && (isEnd == objP.isEnd()));
        }
    }
    
    /**
     * Provides x coordinate.
     * 
     * @return X coordinate
     */
    public double getX() {
        return x;
    }
    
    /**
     * Provides y coordinate.
     * 
     * @return Y coordinate
     */
    public double getY() {
        return y;
    }
    
    /**
     * Provides if this point is the start.
     * 
     * @return If is start
     */
    public boolean isStart() {
        return isStart;
    }
    
    /**
     * Provides if this point is the end.
     * 
     * @return If is end
     */
    public boolean isEnd() {
        return isEnd;
    }
    
    /**
     * Provides the distance between this point and given coordinates.
     * 
     * @param x X coordinate of point
     * @param y Y coordinate of point
     * @return Distance between points
     */
    public double getDistanceToPoint(double x, double y) {
        return Math.sqrt((Math.pow(Math.abs(x) - Math.abs(this.x),2) + Math.pow(Math.abs(y) - Math.abs(this.y), 2)));
    }
    
    /**
     * Provides the distance between this point and a given point.
     * 
     * @param p Point
     * @return Distance between points
     */
    public double getDistance(Point p) {
        return getDistanceToPoint(p.getX(), p.getY());
    }
    
    /**
     * Sets the x coordinate.
     * 
     * @param x X coordinate
     */
    public void setX(double x) {
        this.x = x;
    }
    
    /**
     * Sets the y coordinate.
     * 
     * @param y Y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }
    
    /**
     * Sets if this point is the start.
     * 
     * @param isStart Is start
     */
    public void setIsStart(boolean isStart) {
        this.isStart = isStart;
        if (isStart) {
            this.isEnd = false;
        }
    }
    
    /**
     * Sets if this point is the end.
     * 
     * @param isEnd Is end 
     */
    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
        if (isEnd) {
            this.isStart = false;
        }
    }
}
