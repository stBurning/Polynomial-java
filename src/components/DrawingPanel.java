package components;
import components.painters.Painter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {
    private ArrayList<Painter> painters = new ArrayList<>();

    public void addPainter(Painter painter){
        painters.add(painter);
        repaint();
    }
    public void removePainter(Painter painter) {
        painters.remove(painter);
        repaint();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        painters.forEach(painter -> {if (painter != null) painter.draw(g, getWidth(), getHeight());});

    }

    public void updatePainters(){
        painters.forEach(painter -> {
            painter.update(getWidth(), getHeight());
        });
    }
}