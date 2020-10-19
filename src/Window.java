
import components.ControlPanel;
import components.DrawingPanel;
import components.painters.CartesianPainter;
import util.ConvertData;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Window extends JFrame {
    static final Dimension MIN_FRAME_SIZE = new Dimension(720, 480);
    private ConvertData convertData;

    public Window() {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(MIN_FRAME_SIZE);
        ControlPanel controlPanel = new ControlPanel();
        DrawingPanel mainPanel = new DrawingPanel();


        mainPanel.setBackground(Color.WHITE);
        //mainPanel.setBorder(new EtchedBorder());
        GroupLayout gl = new GroupLayout(getContentPane());

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(4)
                .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                .addGap(4)
                .addComponent(controlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(4)
        );
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(4)
                .addGroup(
                        gl.createParallelGroup()
                                .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                                .addComponent(controlPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                )
                .addGap(4)
        );
        this.setLayout(gl);
        this.pack();

        convertData = new ConvertData(
                mainPanel.getWidth(),
                mainPanel.getHeight(),
                controlPanel.getXMin(), controlPanel.getXMax(),
                controlPanel.getYMin(), controlPanel.getYmax()
        );

        CartesianPainter cartesianPainter = new CartesianPainter(convertData);
        mainPanel.addPainter(cartesianPainter);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                convertData = new ConvertData(
                        mainPanel.getWidth(),
                        mainPanel.getHeight(),
                        controlPanel.getXMin(),
                        controlPanel.getXMax(),
                        controlPanel.getYMin(),
                        controlPanel.getYmax());
                mainPanel.updatePainters();
            }
        });

    }
}