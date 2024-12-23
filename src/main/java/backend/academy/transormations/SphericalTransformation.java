package backend.academy.transormations;

import backend.academy.model.Point;

public class SphericalTransformation implements Transformation {

    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double r2 = x * x + y * y;
        double[] result = new double[2];
        result[0] = x / r2;
        result[1] = y / r2;
        return new Point(result[0], result[1]);
    }

    @Override public String toString() {
        return "SphericalTransformation";
    }
}
