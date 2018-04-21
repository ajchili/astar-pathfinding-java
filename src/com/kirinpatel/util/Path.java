/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.util;

/**
 *
 * @author Kirin Patel
 * @version 0.1
 */
public class Path {
    
    public static Line[] getPath(final Node START, final Node END) {
        Line[] path = null;
        boolean hasReachedEnd = false;
        
        Point[] traveledPoints = {START.getPoint()};
        
        Node[] nodePath = {START, START.determineNextStep(END, traveledPoints)};
        
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
                        nodePath[i] = nodePath[i - 1].determineNextStep(END, traveledPoints);
                        if (nodePath[i].isEnd()) {
                            hasReachedEnd = true;
                        }
                    }
                }
            }
            
            if (nodePath.length > 10) {
                hasReachedEnd = true;
            }
        } while(!hasReachedEnd);
        
        for (Node n : nodePath) {
            System.out.println(n);
        }
        
        return path;
    }
}
