package util;

public class ConvertData {
    private final int realWidth;

    public int getWidth() {
        return realWidth - 1;
    }

    private final int realHeight;

    public int getHeight() {
        return realHeight - 1;
    }

    private final double xMin;
    private final double xMax;
    private final double yMin;
    private final double yMax;

    public double getXMin() {
        return xMin;
    }

    public double getXMax() {
        return xMax;
    }

    public double getYMin() {
        return yMin;
    }

    public double getYMax() {
        return yMax;
    }

    public double getXDen() {
        return getWidth() / (xMax - xMin);
    }

    public double getYDen() {
        return getHeight() / (yMax - yMin);
    }

    public ConvertData(int realWidth, int realHeight, double xMin, double xMax,
                       double yMin, double yMax) {
        this.realWidth = realWidth;
        this.realHeight = realHeight;
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }
}
