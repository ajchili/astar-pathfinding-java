package com.kirinpatel.graphics;

import com.kirinpatel.Main;
import com.kirinpatel.util.Point;

import javax.swing.*;
import java.awt.*;

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

        JSpinner xCoordinate = new JSpinner(new SpinnerNumberModel(0, 0, 1280, 1));
        JSpinner yCoordinate = new JSpinner(new SpinnerNumberModel(0, 0, 720, 1));
        JButton addPoint = new JButton("Add point");

        JButton coordinateEditButton = new JButton("Edit point");
        JComboBox<Point> pointBox = new JComboBox<>();
        JComboBox<String> coordinateEditBox = new JComboBox<>(COORDINATE_EDIT_BOX_OPTIONS);

        xCoordinate.setToolTipText("X coordinate");
        yCoordinate.setToolTipText("Y coordinate");
        addPoint.addActionListener(e -> {
            String[] inputs = new String[2];
            inputs[0] = "" + xCoordinate.getValue();
            inputs[1] = "" + yCoordinate.getValue();

            int[] chords = new int[2];

            for (int i = 0; i < 2; i++) {
                if (inputs[i].length() > 0) {
                    try {
                        chords[i] = Integer.parseInt(inputs[i]);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null,
                                "Please enter a valid coordinate.");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a x and y coordinate.");
                    return;
                }
            }

            Main.window.drawPanel.addPoint(new Point(chords[0], chords[1]));
            JOptionPane.showMessageDialog(null,
                    "Coordinate added at point (" + chords[0] + "," + chords[1] + ").");
            xCoordinate.setValue(0);
            yCoordinate.setValue(0);

            int length = Main.window.drawPanel.getPoints().length;
            String[] stringPoints = new String[length]; // written to, but never read
            Point[] points = Main.window.drawPanel.getPoints();
            for (int i = 0; i < length; i++) {
                stringPoints[i] = points[i].toString();
            }

            pointBox.setModel(new DefaultComboBoxModel<>(points));
        });

        coordinateEditBox.addActionListener(e -> coordinateEditButton.setText(
                COORDINATE_EDIT_BOX_OPTIONS[coordinateEditBox.getSelectedIndex()]));

        coordinateEditButton.addActionListener(e -> {
            if (pointBox.getItemCount() == 0) {
                JOptionPane.showMessageDialog(null, "No points to select.");
                return;
            }

            switch (coordinateEditBox.getSelectedIndex()) {
                case 0:
                    Main.window.drawPanel.editPoint(pointBox.getSelectedIndex(),
                            new Point(Integer.parseInt(
                                    JOptionPane.showInputDialog("X coordinate:")),
                                    Integer.parseInt(JOptionPane.showInputDialog("Y coordinate:"))));
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

            pointBox.setModel(new DefaultComboBoxModel<>(Main.window.drawPanel.getPoints()));
        });

        addCoordinatePanel.add(xCoordinate);
        addCoordinatePanel.add(yCoordinate);
        addCoordinatePanel.add(addPoint);

        coordinateEditPanel.add(pointBox);
        coordinateEditPanel.add(coordinateEditBox);
        coordinateEditPanel.add(coordinateEditButton);
    }
}
