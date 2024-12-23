package backend.academy.transormations;

import backend.academy.model.Point;

public class DiscTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double newX = 1 / Math.PI * Math.atan(y / x) * Math.sin(Math.PI * Math.sqrt(x * x + y * y));
        double newY = 1 / Math.PI * Math.atan(y / x) * Math.cos(Math.PI * Math.sqrt(x * x + y * y));
        return new Point(newX, newY);
    }

    @Override public String toString() {
        return "DiscTransformation";
    }
}
