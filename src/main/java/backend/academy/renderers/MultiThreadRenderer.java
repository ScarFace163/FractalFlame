package backend.academy.renderers;

import backend.academy.enums.AffineCoefficientColor;
import backend.academy.model.FractalImage;
import backend.academy.model.Rect;
import backend.academy.transormations.AffineTransformation;
import backend.academy.transormations.Transformation;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.SneakyThrows;

public class MultiThreadRenderer extends RendererAbstract {
    private final ExecutorService executor;
    public MultiThreadRenderer(
        int affineCount,
        int samples,
        int iterations,
        int symmetry,
        List<Transformation> transformations,
        AffineCoefficientColor color,
        int threadCount
    ) {
        super(affineCount, samples, iterations, symmetry, transformations, color, threadCount);
        this.executor = Executors.newFixedThreadPool(threadCount);
    }

    @SneakyThrows
    @Override
    public void renderFullFractalImage(
        FractalImage fractalImage,
        List<AffineTransformation> affineTransformations,
        Rect rect
    ) {
        for (int i = 0; i < samples; i++) {
            executor.execute(
                () -> renderOneSample(fractalImage, rect, affineTransformations)
            );
        }
        executor.shutdown();
        executor.close();
    }
}
