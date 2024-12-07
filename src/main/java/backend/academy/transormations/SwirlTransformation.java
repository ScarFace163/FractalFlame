package backend.academy.transormations;

public class SwirlTransformation implements Transformation {

    @Override
    public double[] apply(double x, double y) {
        double radius = Math.sqrt(x * x + y * y);
        double newX = x * Math.sin(radius * radius) - y * Math.cos(radius * radius);
        double newY = x * Math.cos(radius * radius) + y * Math.sin(radius * radius);
        return new double[] {newX, newY};
    }

    @Override public String toString() {
        return "SwirlTransformation";
    }
}
