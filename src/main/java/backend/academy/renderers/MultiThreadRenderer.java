package backend.academy.renderers;

import backend.academy.enums.AffineCoefficientColor;
import backend.academy.model.FractalImage;
import backend.academy.model.Rect;
import backend.academy.transormations.AffineTransformation;
import backend.academy.transormations.Transformation;
import lombok.SneakyThrows;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadRenderer extends RendererAbstract{
    public MultiThreadRenderer(
        int affineCount,
        int samples,
        int iterations,
        int symmetry,
        List<Transformation> transformations,
        AffineCoefficientColor color
    ) {
        super(affineCount, samples, iterations, symmetry, transformations, color);
    }

    @SneakyThrows
    @Override
    public void renderFullFractalImage(
        FractalImage fractalImage,
        List<AffineTransformation> affineTransformations,
        Rect rect
    ) {
        var executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < samples; i++) {
            executor.execute(
                () -> renderOneSample(fractalImage, rect, affineTransformations)
            );
        }
        executor.shutdown();
        executor.close();
    }
}