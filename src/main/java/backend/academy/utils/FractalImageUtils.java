package backend.academy.utils;

import backend.academy.model.FractalImage;
import backend.academy.model.Pixel;
import backend.academy.model.Rect;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FractalImageUtils {

    public static Pixel resolvePixel(Rect rect, double x, double y, FractalImage fractalImage) {
        if (!rect.contains(x, y)) {
            return null;
        }
        return fractalImage.getPixelByCords(
            (int) ((x - rect.x()) / rect.width() * fractalImage.width()),
            (int) ((y - rect.y()) / rect.height() * fractalImage.height())
        );
    }
}
