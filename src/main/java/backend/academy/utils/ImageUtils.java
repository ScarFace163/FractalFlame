package backend.academy.utils;

import backend.academy.enums.ImageFormat;
import backend.academy.model.FractalImage;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import javax.imageio.ImageIO;

public final class ImageUtils {
    private ImageUtils() {
    }

    public static void saveImage(Path filePath, ImageFormat format, FractalImage fractalImage) {
        BufferedImage image = new BufferedImage(
            fractalImage.width(),
            fractalImage.height(),
            BufferedImage.TYPE_INT_RGB
        );
        for (int i = 0; i < fractalImage.width(); i++) {
            for (int j = 0; j < fractalImage.height(); j++) {
                image.setRGB(i, j, fractalImage.pixels()[i][j].color().getRGB());
            }
        }
        try {
            var outputStream = Files.newOutputStream(
                filePath,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
            );
            ImageIO.write(image, format.name(), outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
