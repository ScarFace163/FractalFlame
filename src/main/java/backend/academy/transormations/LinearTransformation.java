package backend.academy.transormations;

import backend.academy.model.Point;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LinearTransformation implements Transformation {
    private final double scaleX;
    private final double scaleY;

    @SuppressWarnings("checkstyle:MagicNumber")
    public LinearTransformation() {
        this.scaleX = 1.05;
        this.scaleY = 1.05;
    }

    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double[] result = new double[2];
        result[0] = scaleX * x;
        result[1] = scaleY * y;
        return new Point(result[0], result[1]);
    }

    @Override public String toString() {
        return "LinearTransformation";
    }
}
