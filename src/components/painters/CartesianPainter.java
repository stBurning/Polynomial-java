package components.painters;

import util.ConvertData;
import util.Converter;

import java.awt.*;

public class CartesianPainter implements Painter {
    ConvertData convertData;

    public CartesianPainter(ConvertData convertData) {
        this.convertData = convertData;
    }

    @Override
    public void draw(Graphics g, int width, int height) {
        if (g != null) {
            g.setColor(Color.BLACK);
            drawAxes(g); // Рисуем оси
            drawTicks(g); // Рисуем черточки
            drawLabels(g); // Рисуем нумерацию и подписи
        }
    }


    private void drawAxes(Graphics g) {
        /* Отрисовываем оси X и Y
         * (x0, y0) - координаты точки (0, 0) на экране */
        var x0 = Converter.xCrt2Scr(0.0, convertData);
        var y0 = Converter.yCrt2Scr(0.0, convertData);
        if (g != null) {
            g.setColor(Color.BLACK);
            g.drawLine(0, y0, convertData.getWidth(), y0);
            g.drawLine(x0, 0, x0, convertData.getHeight());
        }
    }

    private void drawTicks(Graphics g) {
        var dt = 2; // Половина длины черточки
        g.setColor(Color.DARK_GRAY); // Цвет черточек
        var x0 = Converter.xCrt2Scr(0.0, convertData);
        var y0 = Converter.yCrt2Scr(0.0, convertData);
        for (long i = (int)(convertData.getXMin() * 10); i < (int)(convertData.getXMax() * 10); i++) {
            var gap = (i % 10 == 0) ? 2 : (i % 5 == 0) ? 1 : 0;
            var x = Converter.xCrt2Scr((i / 10.0), convertData);
            g.drawLine(x, y0 - dt - gap, x, y0 + dt + gap);
        }
        for (long i = (int)(convertData.getYMin() * 10); i < (int)(convertData.getYMax() * 10); i++) {
            var gap = (i % 10 == 0) ? 2 : (i % 5 == 0) ? 1 : 0;
            var y = Converter.yCrt2Scr((i / 10.0), convertData);
            g.drawLine(x0 - dt - gap, y, x0 + dt + gap, y);
        }
    }

    private void drawLabels(Graphics g) {//числа
        var x0 = Converter.xCrt2Scr(0.0, convertData);
        var y0 = Converter.yCrt2Scr(0.0, convertData);
        g.setColor(Color.BLUE);
        for (long i = (int)(convertData.getXMin() * 10); i < (int)(convertData.getXMax() * 10); i++) {
            if (i % 5 != 0 || i == 0) continue;
            var x = Converter.xCrt2Scr(i / 10.0, convertData);
            var d = (i > 0) ? 20 : -10;
            g.drawString(String.valueOf(i / 10.0), x - 8, y0 + d);
        }
        for (long i = (int)(convertData.getYMin() * 10); i < (int)(convertData.getYMax() * 10); i++) {
            if (i % 5 != 0 || i == 0) continue;
            var y = Converter.yCrt2Scr(i / 10.0, convertData);
            var d = (i > 0) ? 5 : -30;
            g.drawString(String.valueOf(i / 10.0), x0 + d, y + 5);
        }
    }

    public void update(int width, int height, double xMin, double xMax, double yMin, double yMax) {
        convertData = new ConvertData(width, height, xMin, xMax, yMin, yMax);
    }


    public void update(int width, int height) {
        convertData = new ConvertData(width, height, convertData.getXMin(), convertData.getXMax(), convertData.getYMin(), convertData.getYMax());
    }
}
