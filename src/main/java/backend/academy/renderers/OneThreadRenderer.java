package backend.academy.renderers;

import backend.academy.model.FractalImage;
import backend.academy.model.Rect;
import backend.academy.transormations.AffineTransformation;
import backend.academy.transormations.Transformation;
import java.util.List;

public class OneThreadRenderer extends RendererAbstract implements Renderer{

    public OneThreadRenderer(
        int affineCount,
        int samples,
        int iterations,
        int symmetry,
        List<Transformation> transformations
    ) {
        super(affineCount, samples, iterations, symmetry, transformations);
    }

    @Override
    public void renderFullFractalImage(
        FractalImage fractalImage,
        List<AffineTransformation> affineTransformations,
        Rect rect
    ) {
        for (int i = 0; i < samples; i++)
            renderOneSample(fractalImage, rect, affineTransformations);
    }
}
