package backend.academy.transormations;

public class PopcornTransformation implements Transformation {

    @Override
    @SuppressWarnings("checkstyle:MagicNumber")
    public double[] apply(double x, double y) {
        double newX = x + Math.sin(Math.tan(3 * y));
        double newY = y + Math.sin(Math.tan(3 * x));
        return new double[] {newX, newY};
    }

    @Override public String toString() {
        return "PopcornTransformation";
    }
}
