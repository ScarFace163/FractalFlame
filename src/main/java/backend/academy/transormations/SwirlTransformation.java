package backend.academy.transormations;

import backend.academy.model.Point;

public class SwirlTransformation implements Transformation {

    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double radius = Math.sqrt(x * x + y * y);
        double newX = x * Math.sin(radius * radius) - y * Math.cos(radius * radius);
        double newY = x * Math.cos(radius * radius) + y * Math.sin(radius * radius);
        return new Point(newX, newY);
    }

    @Override public String toString() {
        return "SwirlTransformation";
    }
}
