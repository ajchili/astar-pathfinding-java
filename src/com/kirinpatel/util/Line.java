package com.kirinpatel.util;

import java.awt.*;

public class Line {

    private int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        setStart(x1, y1);
        setEnd(x2, y2);
    }

    public Line(Point p1, Point p2) {
        setStart(p1.getX(), p1.getY());
        setEnd(p2.getX(), p2.getY());
    }

    @Override
    public String toString() {
        return "This line starts at ( " + x1 + " , " + y1 + " ) and runs to ( " + x2 + " , " + y2 + " ). Its length is " + getLength() + ".";
    }

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

    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.drawLine(x1 + 5, y1 + 5, x2 + 5, y2 + 5);
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public double getLength() {
        return Math.sqrt((Math.pow(Math.abs(x2) - Math.abs(x1), 2) + Math.pow(Math.abs(y2) - Math.abs(y1), 2)));
    }

    public int getPointPosition(Point p) {
        if (p.getX() == x1 && p.getY() == y1)
            return 0;
        else if (p.getX() == x2 && p.getY() == y2)
            return 1;
        else
            return 2;
    }

    public void setStartingX(int x) {
        this.x1 = x;
    }

    public void setStartingY(int y) {
        this.y1 = y;
    }

    public void setStart(int x, int y) {
        setStartingX(x);
        setStartingY(y);
    }

    public void setEndingX(int x) {
        this.x2 = x;
    }

    public void setEndingY(int y) {
        this.y2 = y;
    }

    public void setEnd(int x, int y) {
        setEndingX(x);
        setEndingY(y);
    }
}
