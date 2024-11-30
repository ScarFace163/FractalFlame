package backend.academy.transormations;

public class ExponentialTransformation implements Transformation {

    @Override
    public double[] apply(double x, double y) {
        double newX = Math.exp(x - 1) * Math.cos(Math.PI * y);
        double newY = Math.exp(x - 1) * Math.sin(Math.PI * y);
        return new double[] {newX, newY};
    }

    @Override public String toString() {
        return "ExponentialTransformation";
    }
}
