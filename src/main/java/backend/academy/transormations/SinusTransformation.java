package backend.academy.transormations;

import java.util.Random;

public class SinusTransformation implements Transformation{
    Random random = new Random();
    private final int red = random.nextInt(256);
    private final int green = random.nextInt(256);
    private final int blue = random.nextInt(256);

    @Override
    public double[] apply(double x, double y) {
        double[] result = new double[2];
        result[0] = Math.sin(x);
        result[1] = Math.sin(y);
        return result;
    }
}
