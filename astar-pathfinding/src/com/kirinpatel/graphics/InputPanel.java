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
 * @version 1.0
 * @see javax.swing.JPanel
 * @see com.kirinpatel.graphics.DrawPanel
 * @see com.kirinpatel.util.Point
 */
public class InputPanel extends JPanel {
    
    private final String[] COORDINATE_EDIT_BOX_OPTIONS = { "Edit point", "Remove point", "Set as start", "Set as end" };
    
    /**
     * Main constructor that will create the InputPanel.
     */
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
                            return;
                        }      
                    } else { 
                        JOptionPane.showMessageDialog(null, "Please enter a x and y coordinate.");
                        return;
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
                if (pointBox.getItemCount() == 0) {
                    JOptionPane.showMessageDialog(null, "No points to select.");
                    return;
                }
                
                switch(coordinateEditBox.getSelectedIndex()) {
                    case 0:
                        Main.window.drawPanel.editPoint(pointBox.getSelectedIndex(), new Point(Double.parseDouble(JOptionPane.showInputDialog("X coordinate:")), Double.parseDouble(JOptionPane.showInputDialog("Y coordinate:"))));
                        break;
                    case 1:
                        Main.window.drawPanel.removePoint(pointBox.getSelectedIndex());
                        break;
                    case 2:
                        Main.window.drawPanel.setStart(pointBox.getSelectedIndex());
                        break;
                    case 3:
                        Main.window.drawPanel.setEnd(pointBox.getSelectedIndex());
                        break;
                    default:
                }
                        
                pointBox.setModel(new DefaultComboBoxModel<Point>(Main.window.drawPanel.getPoints()));
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
