/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel;

import com.kirinpatel.graphics.Window;

/**
 * This class serves as a center for the application.
 * 
 * @author Kirin Patel
 * @version 0.2
 * @see com.kirinpatel.graphics.Window
 */
public class Main {
    
    public static Window window;
    
    /**
     * Main method.
     * 
     * @param args Main arguments
     */
    public static void main(String[] args) {
        window = new Window("A* Pathfinding");
    }
}
