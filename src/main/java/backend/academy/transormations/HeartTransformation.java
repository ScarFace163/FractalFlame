package backend.academy.transormations;

import backend.academy.model.Point;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HeartTransformation implements Transformation {

    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double[] result = new double[2];
        double sqrt = Math.sqrt((x * x) + (y * y));
        result[0] = sqrt * Math.sin(sqrt * Math.atan(y / x));
        result[1] = -sqrt * Math.cos(sqrt + Math.atan(y / x));
        return new Point(result[0], result[1]);
    }

    @Override public String toString() {
        return "HeartTransformation";
    }
}
