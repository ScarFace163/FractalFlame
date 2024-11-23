package backend.academy.utils;

import backend.academy.enums.ImageFormat;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public final class ImageUtils {
    private ImageUtils() {
    }

    public static void saveImage(Path filePath, ImageFormat format) {
        BufferedImage image = new BufferedImage(
            1024,
            1024,
            BufferedImage.TYPE_INT_RGB
        );
        for (int i = 0; i < 1024; i++) {
            for (int j = 0; j < 1024; j++) {
                image.setRGB(i, j, new Color(i % 256, j % 256, (i * j) % 256).getRGB());
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
