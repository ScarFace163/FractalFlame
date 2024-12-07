package backend.academy.service;

import backend.academy.enums.AffineCoefficientColor;
import backend.academy.enums.TransformationType;
import backend.academy.transormations.DiscTransformation;
import backend.academy.transormations.ExponentialTransformation;
import backend.academy.transormations.HeartTransformation;
import backend.academy.transormations.HorseshoeTransformation;
import backend.academy.transormations.LinearTransformation;
import backend.academy.transormations.PolarTransformation;
import backend.academy.transormations.PopcornTransformation;
import backend.academy.transormations.SinusTransformation;
import backend.academy.transormations.SphericalTransformation;
import backend.academy.transormations.SwirlTransformation;
import backend.academy.transormations.Transformation;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("checkstyle:MagicNumber")
public class InputService {
    Scanner sc;

    public int inputWidth() {
        int width;
        String widthRaw = sc.nextLine();
        try {
            width = Integer.parseInt(widthRaw);
        } catch (Exception ex) {
            width = 1920;
        }
        return width;
    }

    public int inputHeight() {
        int height;
        String heightRaw = sc.nextLine();
        try {
            height = Integer.parseInt(heightRaw);
        } catch (Exception ex) {
            height = 1080;
        }
        return height;
    }

    public int inputIterationsCount() {
        int iterations;
        String iterationsRaw = sc.nextLine();
        try {
            iterations = Integer.parseInt(iterationsRaw);
        } catch (Exception ex) {
            iterations = 10000000;
        }
        return iterations;
    }

    public List<Transformation> inputTransformations() {
        String choose;
        List<Transformation> transformations = new ArrayList<>();
        do {
            int chooseNumber;
            choose = sc.nextLine();
            if (choose.isEmpty() && !transformations.isEmpty()) {
                break;
            }
            try {
                chooseNumber = Integer.parseInt(choose);
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
                    case POPCORN -> {
                        transformations.add(new PopcornTransformation());
                    }
                    case SWIRL -> {
                        transformations.add(new SwirlTransformation());
                    }
                    case HORSESHOE -> {
                        transformations.add(new HorseshoeTransformation());
                    }
                    default -> {

                    }
                }
            } catch (Exception e) {
                continue;
            }
            OutputService.println(transformations.toString());
        } while (true);
        return transformations;
    }

    public InputService() {
        this.sc = new Scanner(System.in);
    }

    public AffineCoefficientColor inputColor() {
        Random random = new Random();
        AffineCoefficientColor color;
        String choose = sc.nextLine();
        try {
            color = AffineCoefficientColor.values()[Integer.parseInt(choose)];
        } catch (Exception ex) {
            color = AffineCoefficientColor.values()[random.nextInt(AffineCoefficientColor.values().length)];
        }
        return color;
    }

    public int inputThreadCount() {
        int threadCount;
        String threadCountRaw = sc.nextLine();
        try {
            threadCount = Integer.parseInt(threadCountRaw);
        } catch (Exception ex) {
            threadCount = 10;
        }
        return threadCount;
    }
}
