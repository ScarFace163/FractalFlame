package backend.academy.transormations;

import backend.academy.model.Point;

public class HorseshoeTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double newX = (1 / (Math.sqrt(x * x + y * y))) * (x - y) * (x + y);
        double newY = 2 * x * y;
        return new Point(newX, newY);
    }

    @Override public String toString() {
        return "HorseshoeTransformation";
    }
}
