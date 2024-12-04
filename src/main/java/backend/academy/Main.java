package backend.academy;

import backend.academy.enums.AffineCoefficientColor;
import backend.academy.enums.ImageFormat;
import backend.academy.model.FractalImage;
import backend.academy.model.Rect;
import backend.academy.processors.GammaCorrectionProcessor;
import backend.academy.renderers.OneThreadRenderer;
import backend.academy.service.InputService;
import backend.academy.service.OutputService;
import backend.academy.transormations.Transformation;
import backend.academy.utils.ImageUtils;
import lombok.experimental.UtilityClass;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

@UtilityClass
public class Main {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    OutputService outputService = new OutputService();
    InputService inputService = new InputService();

    public static void main(String[] args) {
        AffineCoefficientColor color;
        int width, height, iterations;
        List<Transformation> transformations;
        OutputService.println("Enter width of image in pixels, default value - 1920");
        width = inputService.inputWidth();
        OutputService.println("Enter height of image in pixels, default value - 1080");
        height = inputService.inputHeight();
        OutputService.println("Enter the number of iterations, default value - 10000000");
        iterations = inputService.inputIterationsCount();
        outputService.printTanformationChoose();
        transformations = inputService.inputTransformations();
        OutputService.printColorChoose();
        color = inputService.inputColor();
        OutputService.println("wait, image generating");
        FractalImage image = new OneThreadRenderer(
            4,
            8,
            iterations,
            3,
            transformations,
            color
        ).render(width, height, new Rect(-4, -3, 8, 6));

        GammaCorrectionProcessor processor = new GammaCorrectionProcessor();
        processor.process(image);

        Path filePath = Path.of("src/main/resources/fractal2.png");

        ImageUtils.saveImage(filePath, ImageFormat.PNG, image);

    }
}
