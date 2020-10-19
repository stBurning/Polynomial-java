package components.painters;

import java.awt.*;

public interface Painter {
    void draw(Graphics g,int width, int height);

    void update(int width, int height);
}