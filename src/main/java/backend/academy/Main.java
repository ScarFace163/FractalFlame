package backend.academy;

import backend.academy.enums.ImageFormat;
import backend.academy.model.FractalImage;
import backend.academy.model.Rect;
import backend.academy.processors.GammaCorrectionProcessor;
import backend.academy.renderers.OneThreadRenderer;
import backend.academy.transormations.LinearTransformation;
import backend.academy.transormations.SinusTransformation;
import backend.academy.transormations.SphericalTransformation;
import backend.academy.transormations.Transformation;
import backend.academy.utils.ImageUtils;
import lombok.experimental.UtilityClass;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        int width = 1920;
        int height = 1080;
        int iterations = 10000000;
        List<Transformation> transformations = Arrays.asList(
            new SinusTransformation(),
           // new LinearTransformation(),
            new SphericalTransformation(),
            new SphericalTransformation()
        );

        FractalImage image = new OneThreadRenderer(
            5,
            5,
            iterations,
            3,
            transformations
        ).render(width, height, new Rect(-4,3,7,5));

        GammaCorrectionProcessor processor = new GammaCorrectionProcessor();
        processor.process(image);

        Path filePath = Path.of("src/main/resources/fractal.png");

        ImageUtils.saveImage(filePath, ImageFormat.PNG, image);


    }
}
