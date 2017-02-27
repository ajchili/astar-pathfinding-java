/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.graphics;

import com.kirinpatel.Main;
import com.kirinpatel.util.Point;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Kirin Patel
 * @version 0.2
 * @see javax.swing.JPanel
 */
public class InputPanel extends JPanel {
    
    private final String[] COORDINATE_EDIT_BOX_OPTIONS = { "Edit point", "Remove point", "Set as start", "Set as end" };
    
    public InputPanel() {
        super();
        
        setLayout(new GridLayout(1, 2));
        
        JPanel addCoordinatePanel = new JPanel();
        addCoordinatePanel.setLayout(new GridLayout(1, 3));
        add(addCoordinatePanel);
        JPanel coordinateEditPanel = new JPanel();
        addCoordinatePanel.setLayout(new GridLayout(1, 3));
        add(coordinateEditPanel);
        
        JTextField xCoordinate = new JTextField();
        JTextField yCoordinate = new JTextField();
        JButton addPoint = new JButton("Add point");    
        
        JButton coordinateEditButton = new JButton("Edit point");
        JComboBox pointBox = new JComboBox();
        JComboBox coordinateEditBox = new JComboBox(COORDINATE_EDIT_BOX_OPTIONS);
        
        xCoordinate.setToolTipText("X coordinate");
        yCoordinate.setToolTipText("Y coordinate");
        addPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] inputs = new String[2];
                inputs[0] = xCoordinate.getText();
                inputs[1] = yCoordinate.getText();

                double[] chords = new double[2];
                
                for (int i = 0; i < 2; i++) {
                    if (inputs[i].length() > 0) {
                        try {
                            chords[i] = Double.parseDouble(inputs[i]);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid coordinate.");
                            break;
                        }      
                    } else { 
                        JOptionPane.showMessageDialog(null, "Please enter a x and y coordinate.");
                        break;
                    }
                }
                
                Main.window.drawPanel.addPoint(new Point(chords[0], chords[1]));
                JOptionPane.showMessageDialog(null, "Coordinate added at point (" + chords[0] +"," + chords[1] + ").");
                xCoordinate.setText("");
                yCoordinate.setText("");
                
                int length = Main.window.drawPanel.getPoints().length;
                String[] stringPoints = new String[length];
                Point[] points = Main.window.drawPanel.getPoints();
                for (int i = 0; i < length; i++) {
                    stringPoints[i] = points[i].toString();
                }
                
                pointBox.setModel(new DefaultComboBoxModel<Point>(points));
            }
        });
        
        coordinateEditBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coordinateEditButton.setText(COORDINATE_EDIT_BOX_OPTIONS[coordinateEditBox.getSelectedIndex()]);
            }
        });
        
        coordinateEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(coordinateEditBox.getSelectedIndex()) {
                    case 0:
                        break;
                    case 1:
                        Main.window.drawPanel.removePoint(pointBox.getSelectedIndex());
                        pointBox.setModel(new DefaultComboBoxModel<Point>(Main.window.drawPanel.getPoints()));
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                }
            }
        });
        
        addCoordinatePanel.add(xCoordinate);
        addCoordinatePanel.add(yCoordinate);
        addCoordinatePanel.add(addPoint);
        
        coordinateEditPanel.add(pointBox);
        coordinateEditPanel.add(coordinateEditBox);
        coordinateEditPanel.add(coordinateEditButton);
    }
}
