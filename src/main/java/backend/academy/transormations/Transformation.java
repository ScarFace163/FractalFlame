package backend.academy.transormations;

public interface Transformation {
    double[] apply(double x, double y);
    int getDefaultRed();
    int getDefaultGreen();
    int getDefaultBlue();
}
