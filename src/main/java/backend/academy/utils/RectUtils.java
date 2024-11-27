package backend.academy.utils;

import backend.academy.model.Rect;

public class RectUtils {

    public static double[] rotatePoint(Rect rect, double x, double y, double angle) {
        double centerX = rect.x() + rect.width() / 2;
        double centerY = rect.y() + rect.height() / 2;

        double newX = (x - centerX) * Math.cos(angle) - (y - centerY) * Math.sin(angle) + centerX;
        double newY = (x - centerX) * Math.sin(angle) + (y - centerY) * Math.cos(angle) + centerY;

        return new double[] {newX, newY};
    }
}
