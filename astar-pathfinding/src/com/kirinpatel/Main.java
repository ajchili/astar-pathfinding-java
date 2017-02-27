/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel;

import com.kirinpatel.graphics.Window;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class serves as a center for the application.
 * 
 * @author Kirin Patel
 * @version 0.1
 * @see java.lang.Runnable
 * @see java.lang.Thread
 * @see com.kirinpatel.graphics.Window
 */
public class Main implements Runnable {
 
    private boolean isRunning = false;
    
    private Thread thread;
    public Window window;
    
    /**
     * Main constructor for Main class.
     */
    public Main() {
        window = new Window("A* Pathfinding");
    }
    
    /**
     * Main method.
     * 
     * @param args Main arguments
     */
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
    
    @Override
    public void run() {
        while (isRunning) {
            
        }
        
        stop();
    }
    
    public synchronized void start() {
        thread = new Thread(this, "A* Pathfinding");
        thread.start();
        
        isRunning = true;
    }
    
    public synchronized void stop() {
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        isRunning = false;
    }
}
