package backend.academy.transormations;

public class DiscTransformation implements Transformation{
    @Override
    public double[] apply(double x, double y) {
        double newX = 1/Math.PI * Math.atan(y/x) * Math.sin(Math.PI*Math.sqrt(x*x + y*y));
        double newY = 1/Math.PI * Math.atan(y/x) * Math.cos(Math.PI*Math.sqrt(x*x + y*y));
        return new double[]{newX, newY};
    }

    @Override public String toString() {
        return "DiscTransformation";
    }
}
