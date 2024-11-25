package backend.academy.generators;

import backend.academy.model.FractalImage;
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
                int red = (int) (128 * (1 + Math.sin(i * 0.1)));
                int green = (int) (128 * (1 + Math.sin(i * 0.1 + 2 * Math.PI / 3)));
                int blue = (int) (128 * (1 + Math.sin(i * 0.1 + 4 * Math.PI / 3)));
                fractalImage.pixels()[px][py].color(new Color(red, 120, 120));
            }
        }

        return fractalImage;
    }
}
