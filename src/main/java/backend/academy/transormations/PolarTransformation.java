package backend.academy.transormations;

import backend.academy.model.Point;

public class PolarTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double newX = (Math.atan(y / x)) / Math.PI;
        double newY = Math.sqrt(x * x + y * y) - 1;
        return new Point(newX, newY);
    }

    @Override public String toString() {
        return "PolarTransformation";
    }
}
