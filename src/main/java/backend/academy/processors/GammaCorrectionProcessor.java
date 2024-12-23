package backend.academy.processors;

import backend.academy.model.FractalImage;
import backend.academy.model.Pixel;
import java.awt.Color;

public class GammaCorrectionProcessor {

    private static final double GAMMA = 1.8;

    public void process(FractalImage fractalImage) {
        double max = 0;

        for (int x = 0; x < fractalImage.width(); x++) {
            for (int y = 0; y < fractalImage.height(); y++) {
                if (fractalImage.pixels()[x][y].hitCount() != 0) {
                    fractalImage.pixels()[x][y].normal(Math.log10(fractalImage.pixels()[x][y].hitCount()));
                    if (fractalImage.pixels()[x][y].normal() > max) {
                        max = fractalImage.pixels()[x][y].normal();
                    }
                }
            }
        }

        for (int x = 0; x < fractalImage.width(); x++) {
            for (int y = 0; y < fractalImage.height(); y++) {
                Pixel pixel = fractalImage.pixels()[x][y];
                pixel.normal(fractalImage.pixels()[x][y].normal() / max);
                int red = (int) (pixel.color().getRed() * Math.pow(pixel.normal(), (1.0 / GAMMA)));
                int green = (int) (pixel.color().getGreen() * Math.pow(pixel.normal(), (1.0 / GAMMA)));
                int blue = (int) (pixel.color().getBlue() * Math.pow(pixel.normal(), (1.0 / GAMMA)));
                pixel.color(new Color(red, green, blue));
            }
        }
    }
}
