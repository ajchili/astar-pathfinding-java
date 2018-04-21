/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.util;

import java.awt.*;

/**
 * This class contains all information pertaining to the Line class.
 *
 * @author Kirin Patel
 * @version 0.2
 * @see java.awt.Color
 * @see java.awt.Graphics
 */
public class Wall extends Line {

    private int x1, y1, x2, y2;

    /**
     * Main constructor that will create a wall with provided start and end
     * coordinates.
     *
     * @param x1 Starting x coordinate
     * @param y1 Starting y coordinate
     * @param x2 Ending x coordinate
     * @param y2 Ending y coordinate
     */
    public Wall(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    /**
     * Secondary constructor that will create a wall based upon the coordinates
     * of two points.
     *
     * @param p1 Point 1
     * @param p2 Point 2
     */
    public Wall(Point p1, Point p2) {
        super(p1, p2);
    }

    /**
     * Provides a printable version of the Line class.
     *
     * @return String version of Line
     */
    @Override
    public String toString() {
        return "This wall starts at ( " + x1 + " , " + y1 + " ) and runs to ( " + x2 + " , " + y2 + " ). Its length is " + getLength() + ".";
    }

    public boolean doesLineIntersect(Line l) {
        return false;
    }

    /**
     * Draws wall with given graphics object.
     *
     * @param g Graphics
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        g.drawLine(x1, y1, x2 + 10, y2 + 10);
    }
}
