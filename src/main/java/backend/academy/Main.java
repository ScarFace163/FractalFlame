package backend.academy;

import backend.academy.enums.AffineCoefficientColor;
import backend.academy.enums.ImageFormat;
import backend.academy.enums.TransformationType;
import backend.academy.model.FractalImage;
import backend.academy.model.Rect;
import backend.academy.processors.GammaCorrectionProcessor;
import backend.academy.renderers.OneThreadRenderer;
import backend.academy.transormations.DiscTransformation;
import backend.academy.transormations.ExponentialTransformation;
import backend.academy.transormations.HeartTransformation;
import backend.academy.transormations.LinearTransformation;
import backend.academy.transormations.PolarTransformation;
import backend.academy.transormations.SinusTransformation;
import backend.academy.transormations.SphericalTransformation;
import backend.academy.transormations.Transformation;
import backend.academy.utils.ImageUtils;
import lombok.experimental.UtilityClass;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ServiceLoader;
import java.util.Set;

@UtilityClass
public class Main {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    public static void main(String[] args) {
        AffineCoefficientColor color;
        int width, height, iterations;
        System.out.println("Enter width of image in pixels");
        String widthRaw = sc.nextLine();
        if (widthRaw.isEmpty()) {
            width = 1920;
        } else {
            width = Integer.parseInt(widthRaw);
        }
        System.out.println("Enter height of image in pixels");
        String heightRaw = sc.nextLine();
        if (heightRaw.isEmpty()) {
            height = 1080;
        } else {
            height = Integer.parseInt(heightRaw);
        }
        System.out.println("Enter the number of iterations");
        String iterationsRaw = sc.nextLine();
        if (iterationsRaw.isEmpty()) {
            iterations = 10000000;
        } else {
            iterations = Integer.parseInt(iterationsRaw);
        }
        List<Transformation> transformations = new ArrayList<>();
        System.out.println("Choose transformations, type enter if stop");
        for (int i = 0; i < TransformationType.values().length; i++) {
            System.out.println(i + " " + TransformationType.values()[i]);
        }
        String choose;
        do {
            choose = sc.nextLine();
            if (choose.isEmpty())
                break;
            int chooseNumber = Integer.parseInt(choose);
            switch (TransformationType.values()[chooseNumber]) {
                case DISC -> {
                    transformations.add(new DiscTransformation());
                }
                case EXPONENTIAL -> {
                    transformations.add(new ExponentialTransformation());
                }
                case HEART -> {
                    transformations.add(new HeartTransformation());
                }
                case LINEAR -> {
                    transformations.add(new LinearTransformation());
                }
                case POLAR -> {
                    transformations.add(new PolarTransformation());
                }
                case SINUS -> {
                    transformations.add(new SinusTransformation());
                }
                case SPHERICAL -> {
                    transformations.add(new SphericalTransformation());
                }
            }
            System.out.println(transformations.toString());
        } while (true);
        System.out.println("Choose color");
        for (int index = 0; index < AffineCoefficientColor.values().length; index++) {
            System.out.println(index + " " + AffineCoefficientColor.values()[index]);
        }
        choose = sc.nextLine();
        if (choose.isEmpty()) {
            color = AffineCoefficientColor.values()[random.nextInt(AffineCoefficientColor.values().length)];
        } else {
            color = AffineCoefficientColor.values()[Integer.parseInt(choose)];
        }
        System.out.println("wait, image generating");
        FractalImage image = new OneThreadRenderer(
            4,
            6,
            iterations,
            3,
            transformations,
            color
        ).render(width, height, new Rect(-4, -3, 8, 6));

        GammaCorrectionProcessor processor = new GammaCorrectionProcessor();
        processor.process(image);

        Path filePath = Path.of("src/main/resources/fractal.png");

        ImageUtils.saveImage(filePath, ImageFormat.PNG, image);

    }
}
