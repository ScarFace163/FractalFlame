package backend.academy.transormations;

public class PolarTransformation implements Transformation {
    @Override
    public double[] apply(double x, double y) {
        double newX = (Math.atan(y / x)) / Math.PI;
        double newY = Math.sqrt(x * x + y * y) - 1;
        return new double[] {newX, newY};
    }

    @Override public String toString() {
        return "PolarTransformation";
    }
}
