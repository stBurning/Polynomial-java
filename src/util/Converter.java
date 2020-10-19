package util;


public class Converter {
    public static int xCrt2Scr(double x, ConvertData data) {
        var kw = data.getWidth() / (data.getXMax() - data.getXMin());
        return (int)(x * kw + (-data.getXMin()) * kw);
    }

    public static double xScr2Crt(double x, ConvertData data) {
        var kw = data.getWidth() / (data.getXMax() - data.getXMin());
        return x * (1.0 / kw) + data.getXMin();
    }

    public static int yCrt2Scr(double y, ConvertData data) {
        var kh = data.getHeight() / (data.getYMax() - data.getYMin());
        return (int)(kh * (data.getYMax() - y));
    }

    public static double yScr2Crt(double y, ConvertData data) {
        var kh = data.getHeight() / (data.getYMax() - data.getYMin());
        return (-y) * (1.0 / kh) + data.getYMax();
    }


}
