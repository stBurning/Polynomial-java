package polynomials;

import util.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewtonPolynomial extends Polynomial {
    private ArrayList<Point<Double>> points;
    private Map<Point<Integer>, Double> divDifferences;

    public NewtonPolynomial() {
        this.points = new ArrayList<>();
        divDifferences = new HashMap<>();
    }

    public NewtonPolynomial(ArrayList<Point<Double>> points){
        points.forEach(point -> addNode(point.getX(), point.getY()));
    }

    private double divDifference(int first, int last){
        var key = new Point<>(first, last);
        if (divDifferences.containsKey(key)) return divDifferences.get(key);
        if (first == last) {
            divDifferences.put(key, points.get(last).getY());
            return points.get(last).getY();
        }else {
            var left = divDifference(first + 1, last);
            var right = divDifference(first, last - 1);
            var difference = (left - right) / (points.get(last).getX() - points.get(first).getX());
            divDifferences.put(key, difference);
            return difference;
        }
    }

    public void addNode(double x, double y){
        for (Point<Double> point : points) {
            if (point.getX() == x) {
                System.out.printf("Невозможно добавить узел (%f, %f), так как для x = $f уже задано значение y = %f.", x, y, x, point.getY());
                return;
            }
        }
        var base = new Polynomial();
        var p = new Polynomial(new double[]{1});
        points.add(new Point<>(x, y));
        for (int i = 0; i < points.size(); i++){
            if(i != 0) p = p.mul(new Polynomial(new double[]{-points.get(i - 1).getX(), 1.0}));}
        base = base.mul(p.times(divDifference(0, points.size() - 1)));
        this.a = base.a;

    }
}
