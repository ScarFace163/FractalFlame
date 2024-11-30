package backend.academy.transormations;

import java.util.Random;

public class SinusTransformation implements Transformation{

    @Override
    public double[] apply(double x, double y) {
        double[] result = new double[2];
        result[0] = Math.sin(x);
        result[1] = Math.sin(y);
        return result;
    }

    @Override public String toString() {
        return "SinusTransformation";
    }
}
