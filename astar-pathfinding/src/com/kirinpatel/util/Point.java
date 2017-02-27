/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.util;

/**
 *
 * @author Kirin Patel
 * @version 1.0
 */
public class Point {
    
    private double x, y;
    
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
}
