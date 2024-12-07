package backend.academy.renderers;

import backend.academy.enums.AffineCoefficientColor;
import backend.academy.model.FractalImage;
import backend.academy.model.Rect;
import backend.academy.transormations.AffineTransformation;
import backend.academy.transormations.Transformation;
import java.util.List;

public class SingleThreadRenderer extends RendererAbstract implements Renderer {

    public SingleThreadRenderer(
        int affineCount,
        int samples,
        int iterations,
        int symmetry,
        List<Transformation> transformations,
        AffineCoefficientColor color
    ) {
        super(affineCount, samples, iterations, symmetry, transformations, color, 1);
    }

    @Override
    public void renderFullFractalImage(
        FractalImage fractalImage,
        List<AffineTransformation> affineTransformations,
        Rect rect
    ) {
        for (int i = 0; i < samples; i++) {
            renderOneSample(fractalImage, rect, affineTransformations);
        }
    }
}
