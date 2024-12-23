package backend.academy.transormations;

import backend.academy.model.Point;

public class SinusTransformation implements Transformation {

    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double[] result = new double[2];
        result[0] = Math.sin(x);
        result[1] = Math.sin(y);
        return new Point(result[0], result[1]);
    }

    @Override public String toString() {
        return "SinusTransformation";
    }
}
