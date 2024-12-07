package backend.academy.transormations;

public class HorseshoeTransformation implements Transformation {
    @Override
    public double[] apply(double x, double y) {
        double newX = (1 / (Math.sqrt(x * x + y * y))) * (x - y) * (x + y);
        double nexY = 2 * x * y;
        return new double[] {newX, nexY};
    }

    @Override public String toString() {
        return "HorseshoeTransformation";
    }
}
