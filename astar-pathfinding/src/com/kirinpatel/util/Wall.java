/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.util;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Kirin Patel
 * @version 0.1
 * @see java.awt.Color
 * @see java.awt.Graphics
 */
public class Wall {
    
    private Point[] verticies;
    
    public Wall(Point[] verticies) {
        setVerticies(verticies);
    }
    
    @Override
    public String toString() {
        return "";
    }
    
    @Override
    public boolean equals(Object o) {
        return false;
    }
    
    public void draw(Graphics g) {
        
    }
    
    public Point[] getVerticies() {
        return verticies;
    }
    
    public Point getVertexAt(int index) {
        return verticies[index];
    }
    
    public void addVertex(Point verticie) {
        
    }
    
    public void removeVertex(int intex) {
        
    }
    
    public void setVerticies(Point[] verticies) {
        this.verticies = verticies;
    }
}
