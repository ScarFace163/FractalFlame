package backend.academy.transormations;

import backend.academy.model.Point;

public class PopcornTransformation implements Transformation {

    @Override
    @SuppressWarnings("checkstyle:MagicNumber")
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double newX = x + Math.sin(Math.tan(3 * y));
        double newY = y + Math.sin(Math.tan(3 * x));
        return new Point(newX, newY);
    }

    @Override public String toString() {
        return "PopcornTransformation";
    }
}
