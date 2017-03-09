/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.graphics;

import com.kirinpatel.util.Line;
import com.kirinpatel.util.Node;
import com.kirinpatel.util.Point;

import javax.swing.*;
import java.awt.*;

/**
 * @author Kirin Patel
 * @version 0.6
 * @see javax.swing.JPanel
 * @see com.kirinpatel.util.Point
 * @see com.kirinpatel.util.Line
 * @see com.kirinpatel.util.Node
 */
public class DrawPanel extends JPanel {

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

        int width = getWidth();
        int height = getHeight();

        createLines();
        getPath();

        g.setColor(Color.darkGray);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (Line l : lines) {
            l.draw(g);
        }

        for (Point p : points) {
            p.draw(g);
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

    public Point getEnd() {
        for (Point p : points) {
            if (p.isEnd())
                return p;
        }

        return null;
    }

    public void setEnd(int index) {
        for (int i = 0; i < points.length; i++) {
            if (i != index) {
                points[i].setIsEnd(false);
            } else {
                points[i].setIsEnd(true);
            }
        }

        repaint();
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

            System.arraycopy(oldPoints, 0, points, 0, index);

            System.arraycopy(oldPoints, index + 1, points, index + 1 - 1, oldPoints.length - (index + 1));
        }

        repaint();
    }

    public void editPoint(int index, Point p) {
        points[index] = p;

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

            System.arraycopy(oldLines, 0, lines, 0, index);

            System.arraycopy(oldLines, index + 1, lines, index + 1 - 1, oldLines.length - (index + 1));
        }
    }

    public boolean doesLineExist(Line l) {
        for (int i = 0; i < lines.length; i++) { // foreach (?)
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
        if (lines.length < 2 || getStart() == null || getEnd() == null)
            return null;

        Node start = new Node(getStart(), points, lines);
        Node end = new Node(getEnd(), points, lines);
        boolean hasReachedEnd = false;

        Node[] nodePath = new Node[2];
        nodePath[0] = start;
        nodePath[1] = start.determineNextStep(getEnd());

        do {
            if (nodePath[nodePath.length - 1].getPoint().isEnd()) {
                hasReachedEnd = true;
            } else {
                Node[] oldNodePath = nodePath;
                nodePath = new Node[oldNodePath.length + 1];

                for (int i = 0; i < nodePath.length; i++) {
                    if (i < oldNodePath.length) {
                        nodePath[i] = oldNodePath[i];
                    } else {
                        nodePath[i] = nodePath[i - 1].determineNextStep(getEnd());
                        if (nodePath[i].getPoint().isEnd()) {
                            hasReachedEnd = true;
                        }
                    }
                }
            }
        } while (!hasReachedEnd);

        for (Node n : nodePath) {
            System.out.println(n);
        }

        return path; // never used (?)
    }
}
