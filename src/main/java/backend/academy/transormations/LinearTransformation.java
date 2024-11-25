package backend.academy.transormations;

import org.checkerframework.checker.units.qual.C;
import java.awt.Color;

public class LinearTransformation implements Transformation {
    private final double scaleX;
    private final double scaleY;
    private final double rotation;
    private final double translateX;
    private final double translateY;
    private static final int red = 168;
    private static final int green = 94;
    private static final int blue = 32;

    public LinearTransformation(double scaleX, double scaleY, double rotation, double translateX, double translateY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.rotation = rotation;
        this.translateX = translateX;
        this.translateY = translateY;
    }

    @Override
    public double[] apply(double x, double y) {
        // Apply scaling
        x *= scaleX;
        y *= scaleY;

        // Apply rotation
        double tempX = x * Math.cos(rotation) - y * Math.sin(rotation);
        double tempY = x * Math.sin(rotation) + y * Math.cos(rotation);
        x = tempX;
        y = tempY;

        // Apply translation
        x += translateX;
        y += translateY;

        return new double[]{x, y};
    }

    @Override
    public int getDefaultRed() {
        return red;
    }

    @Override
    public int getDefaultGreen() {
        return green;
    }

    @Override
    public int getDefaultBlue() {
        return blue;
    }
}
