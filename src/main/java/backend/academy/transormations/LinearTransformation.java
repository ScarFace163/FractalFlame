package backend.academy.transormations;

import lombok.AllArgsConstructor;
import java.util.Random;

@AllArgsConstructor
public class LinearTransformation implements Transformation {
    private final double scaleX;
    private final double scaleY;
    private final Random random = new Random();
    private final int red = random.nextInt(256);
    private final int green = random.nextInt(256);
    private final int blue = random.nextInt(256);

    public LinearTransformation(){
        this.scaleX = 1.05;
        this.scaleY = 1.05;
    }

    @Override
    public double[] apply(double x, double y) {
        double[] result = new double[2];
        result[0] = scaleX * x;
        result[1] = scaleY * y;
        return result;
    }
}
