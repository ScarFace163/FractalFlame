package backend.academy;

import backend.academy.enums.ImageFormat;
import backend.academy.generators.FlameFractalGenerator;
import backend.academy.transormations.LinearTransformation;
import backend.academy.transormations.Transformation;
import lombok.experimental.UtilityClass;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        int width = 1920;
        int height = 1920;
        int iterations = 10000000;
        List<Transformation> transformations = Arrays.asList(
            new LinearTransformation(0.5, 0.5, Math.PI / 6, 0.0, 0.0),
            new LinearTransformation(0.5, 0.5, -Math.PI / 6, 0.5, 0.5),
            new LinearTransformation(0.5, 0.5, Math.PI / 3, -0.5, -0.5),
            new LinearTransformation(0.5, 0.5, Math.PI / 2, 0.5, 0.5)
        );

        Path filePath = Path.of("src/main/resources/fractal.png");

        // Однопоточная генерация
        FlameFractalGenerator.generateSingleThreaded(filePath, width, height, iterations, transformations, ImageFormat.PNG);

        // Многопоточная генерация
       // FlameFractalGenerator.generateMultiThreaded(filePath, width, height, iterations, transformations, 4);
    }
}
