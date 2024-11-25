package backend.academy.generators;

import backend.academy.enums.ImageFormat;
import backend.academy.model.FractalImage;
import backend.academy.transormations.Transformation;
import backend.academy.utils.ImageUtils;
import java.nio.file.Path;
import java.util.List;

public class FlameFractalGenerator {
    public static void generateSingleThreaded(
        Path filePath,
        int width,
        int height,
        int iterations,
        List<Transformation> transformations,
        ImageFormat imageFormat
    ) {
        FlameFractalGenerateLogic fractal = new FlameFractalGenerateLogic(width, height, iterations, transformations);
        FractalImage fractalImage = fractal.generate();
        ImageUtils.saveImage(filePath, imageFormat, fractalImage);
    }

//    public static void generateMultiThreaded(
//        Path filePath,
//        int width,
//        int height,
//        int iterations,
//        List<Transformation> transformations,
//        int threadCount,
//        ImageFormat imageFormat
//    ) {
//        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
//        FlameFractal fractal = new FlameFractal(width, height, iterations / threadCount, transformations);
//
//        for (int i = 0; i < threadCount; i++) {
//            executor.submit(() -> {
//                FractalImage fractalImage = fractal.generate();
//                synchronized (FlameFractalGenerator.class) {
//                    ImageUtils.saveImage(filePath, fractalImage.toBufferedImage());
//                }
//            });
//        }
//
//        executor.shutdown();
//        try {
//            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
}
