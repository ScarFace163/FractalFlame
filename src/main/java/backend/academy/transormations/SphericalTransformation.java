package backend.academy.transormations;

import java.util.Random;

public class SphericalTransformation implements Transformation {

    Random random = new Random();
    private final int red = random.nextInt(256);
    private final int green = random.nextInt(256);
    private final int blue = random.nextInt(256);

    @Override
    public double[] apply(double x, double y) {
        double r2 = x * x + y * y;
        double[] result = new double[2];
        result[0] = x / r2;
        result[1] = y / r2;
        return result;
    }
}
