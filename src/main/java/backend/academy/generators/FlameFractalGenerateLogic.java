package backend.academy.generators;

import backend.academy.model.FractalImage;
import backend.academy.model.Pixel;
import backend.academy.transormations.Transformation;
import lombok.AllArgsConstructor;
import java.awt.Color;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class FlameFractalGenerateLogic {
    private final int width;
    private final int height;
    private final int iterations;
    private final List<Transformation> transformations;

    private final Random random = new Random();

    public FractalImage generate() {
        FractalImage fractalImage = FractalImage.createFractalImage(width, height);
        double x = 0, y = 0;
        int lastRed = random.nextInt(256), lastGreen = random.nextInt(256), lastBlue = random.nextInt(256);
        for (int i = 0; i < iterations; i++) {
            Transformation transformation = transformations.get(random.nextInt(transformations.size()));
            double[] result = transformation.apply(x, y);
            x = result[0];
            y = result[1];

            int px = (int) ((x + 1) * width / 2);
            int py = (int) ((y + 1) * height / 2);

            if (px >= 0 && px < width && py >= 0 && py < height) {
                Pixel pixel = fractalImage.pixels()[px][py];
                if (pixel.hitCount() == 0){
                    pixel.color(new Color(transformation.getDefaultRed(), transformation.getDefaultGreen(), transformation.getDefaultBlue()));
                }
                else {
                    int red = (int) (255 * Math.min(1.0, pixel.hitCount() / 100.0));
                    int green = (int) (255 * Math.min(1.0, pixel.hitCount() / 200.0));
                    int blue = (int) (255 * Math.min(1.0, pixel.hitCount() / 300.0));
                    pixel.color(new Color(red, green, blue));
                }
                pixel.hitCount(pixel.hitCount() + 1);
            }
        }

        return fractalImage;
    }
}
