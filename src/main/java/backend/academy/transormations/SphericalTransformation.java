package backend.academy.transormations;

public class SphericalTransformation implements Transformation {

    @Override
    public double[] apply(double x, double y) {
        double r2 = x * x + y * y;
        double[] result = new double[2];
        result[0] = x / r2;
        result[1] = y / r2;
        return result;
    }

    @Override public String toString() {
        return "SphericalTransformation";
    }
}
