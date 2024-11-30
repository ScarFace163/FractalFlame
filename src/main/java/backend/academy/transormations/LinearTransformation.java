package backend.academy.transormations;

import lombok.AllArgsConstructor;
import java.util.Random;

@AllArgsConstructor
public class LinearTransformation implements Transformation {
    private final double scaleX;
    private final double scaleY;

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

    @Override public String toString() {
        return "LinearTransformation";
    }
}
