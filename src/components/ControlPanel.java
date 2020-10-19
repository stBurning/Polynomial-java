package components;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ControlPanel extends JPanel {
    private static final Dimension MIN_COMPONENT_SIZE = new Dimension(40, 20);

    SpinnerNumberModel xMinSpinnerModel = new SpinnerNumberModel(-0.1, -100, 9.9, 0.1);
    SpinnerNumberModel xMaxSpinnerModel = new SpinnerNumberModel(10, 0.1, 100, 0.1);
    SpinnerNumberModel yMinSpinnerModel = new SpinnerNumberModel(-0.1, -100, 9.9, 0.1);
    SpinnerNumberModel yMaxSpinnerModel = new SpinnerNumberModel(10, 0.1, 100, 0.1);

    JSpinner xMinSpinner = new JSpinner(xMinSpinnerModel);
    JSpinner xMaxSpinner = new JSpinner(xMaxSpinnerModel);
    JSpinner yMinSpinner = new JSpinner(yMinSpinnerModel);
    JSpinner yMaxSpinner = new JSpinner(yMaxSpinnerModel);

    JLabel xMinLabel = new JLabel("xMin");
    JLabel xMaxLabel = new JLabel("xMax");
    JLabel yMinLabel = new JLabel("yMin");
    JLabel yMaxLabel = new JLabel("yMax");

    public ControlPanel() {
        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);
        setBackground(Color.GRAY);

        xMinSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                xMaxSpinnerModel.setMinimum((double) xMinSpinner.getValue() + 0.1);
            }
        });

        xMaxSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                xMinSpinnerModel.setMaximum((double) xMaxSpinner.getValue() - 0.1);
            }
        });

        yMinSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                yMaxSpinnerModel.setMinimum((double) yMinSpinner.getValue() + 0.1);
            }
        });

        yMaxSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                yMinSpinnerModel.setMaximum((double) yMaxSpinner.getValue() - 0.1);
            }
        });

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(10)
                .addGroup(gl.createParallelGroup()
                        .addComponent(xMinLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(xMinSpinner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                        .addComponent(xMaxLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(xMaxSpinner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)

                ).addGap(10)
                .addGroup(gl.createParallelGroup()
                        .addComponent(yMinLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(yMinSpinner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                        .addComponent(yMaxLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(yMaxSpinner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                ).addGap(10)
        );

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(20)
                .addGroup(gl.createParallelGroup()
                        .addComponent(xMinLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(yMinLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(10)
                .addGroup(gl.createParallelGroup()
                        .addComponent(xMinSpinner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                        .addComponent(yMinSpinner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)

                ).addGap(100)
                .addGroup(gl.createParallelGroup()
                        .addComponent(xMaxLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(yMaxLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(10)
                .addGroup(gl.createParallelGroup()
                        .addComponent(xMaxSpinner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                        .addComponent(yMaxSpinner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                ).addGap(20)
        );
    }

    public double getXMin() {
        return (double) xMinSpinnerModel.getValue();
    }

    public double getXMax() {
        return (double) xMaxSpinnerModel.getValue();
    }

    public double getYMin() {
        return (double) yMinSpinnerModel.getValue();
    }

    public double getYmax() {
        return (double) yMaxSpinnerModel.getValue();
    }
}
