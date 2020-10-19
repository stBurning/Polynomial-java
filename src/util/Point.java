package util;

public class Point<T> {

    private final T x;
    private final T y;

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point<?>){
            return this.x == ((Point<?>) obj).x && this.y == ((Point<?>) obj).y;
        } return false;
    }
}
