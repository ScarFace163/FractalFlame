package backend.academy.transormations;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HeartTransformation implements Transformation {

    @Override
    public double[] apply(double x, double y) {
        double[] result = new double[2];
        double sqrt = Math.sqrt((x * x) + (y * y));
        result[0] = sqrt * Math.sin(sqrt * Math.atan(y / x));
        result[1] = -sqrt * Math.cos(sqrt + Math.atan(y / x));
        return result;
    }
}
