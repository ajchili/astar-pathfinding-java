/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kirinpatel.graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Kirin Patel
 * @version 0.1
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
        xCoordinate.setToolTipText("X coordinate");
        JTextField yCoordinate = new JTextField();
        yCoordinate.setToolTipText("Y coordinate");
        JButton addPoint = new JButton("Add point");
        addPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (xCoordinate.getText().length() > 0 && yCoordinate.getText().length() > 0) {
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a x and y coordinate.");
                }
            }
        });
        
        addCoordinatePanel.add(xCoordinate);
        addCoordinatePanel.add(yCoordinate);
        addCoordinatePanel.add(addPoint);
        
        JButton coordinateEditButton = new JButton("Remove point");
        JComboBox pointBox = new JComboBox();
        JComboBox coordinateEditBox = new JComboBox(COORDINATE_EDIT_BOX_OPTIONS);
        
        coordinateEditPanel.add(pointBox);
        coordinateEditPanel.add(coordinateEditBox);
        coordinateEditPanel.add(coordinateEditButton);
    }
}
