package backend.academy.service;

import backend.academy.enums.AffineCoefficientColor;
import backend.academy.enums.ImageFormat;
import backend.academy.model.FractalImage;
import backend.academy.model.Rect;
import backend.academy.model.WorldInfo;
import backend.academy.processors.GammaCorrectionProcessor;
import backend.academy.renderers.OneThreadRenderer;
import backend.academy.transormations.Transformation;
import backend.academy.utils.ImageUtils;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainService {
    Scanner sc;
    Random random;
    OutputService outputService;
    InputService inputService;

    public MainService() {
        sc = new Scanner(System.in);
        random = new Random();
        outputService = new OutputService();
        inputService = new InputService();
    }

    public void runProgram() {
        WorldInfo worldInfo = getWorldInfo();
        OutputService.println("wait, image generating, i will be saved by path src/main/resources/fractal2.png");
        FractalImage image = generateImage(worldInfo);
        Path filePath = Path.of("src/main/resources/fractal2.png");
        ImageUtils.saveImage(filePath, ImageFormat.PNG, image);
    }

    private WorldInfo getWorldInfo() {
        int width, height, iterations;
        List<Transformation> transformations;
        AffineCoefficientColor color;
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

        return WorldInfo.builder()
            .width(width)
            .height(height)
            .iterations(iterations)
            .transformations(transformations)
            .color(color)
            .build();
    }

    private FractalImage generateImage(WorldInfo worldInfo){
        FractalImage image = new OneThreadRenderer(
            4,
            8,
            worldInfo.iterations(),
            3,
            worldInfo.transformations(),
            worldInfo.color()
        ).render(worldInfo.width(), worldInfo.height(), new Rect(-4, -3, 8, 6));

        GammaCorrectionProcessor processor = new GammaCorrectionProcessor();
        processor.process(image);
        return image;
    }
}
