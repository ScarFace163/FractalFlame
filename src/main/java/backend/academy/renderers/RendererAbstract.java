package backend.academy.renderers;

import backend.academy.enums.AffineCoefficientColor;
import backend.academy.model.AffineCoefficient;
import backend.academy.model.FractalImage;
import backend.academy.model.Pixel;
import backend.academy.model.Point;
import backend.academy.model.Rect;
import backend.academy.transormations.AffineTransformation;
import backend.academy.transormations.Transformation;
import backend.academy.utils.FractalImageUtils;
import backend.academy.utils.RectUtils;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class RendererAbstract implements Renderer {

    private static final int NORMALIZATION_STEPS_COUNT = 20;

    protected final int affineCount;
    protected final int samples;
    protected final int iterations;
    protected final int symmetry;
    protected final List<Transformation> transformations;
    protected final AffineCoefficientColor color;
    protected final int threadCount;

    @Override
    public FractalImage render(int width, int height, Rect rect) {
        FractalImage fractalImage = FractalImage.createFractalImage(width, height);
        List<AffineTransformation> affineTransformations = generateAffineTransformations();
        renderFullFractalImage(fractalImage, affineTransformations, rect);
        return fractalImage;
    }

    private List<AffineTransformation> generateAffineTransformations() {
        List<AffineTransformation> affineTransformations = new ArrayList<>();
        for (int i = 0; i < affineCount; i++) {
            affineTransformations.add(new AffineTransformation(AffineCoefficient.createRandomAffineCoefficient(color)));
        }
        return affineTransformations;
    }

    public abstract void renderFullFractalImage(
        FractalImage fractalImage,
        List<AffineTransformation> affineTransformations,
        Rect rect
    );

    protected void renderOneSample(
        FractalImage fractalImage,
        Rect rect,
        List<AffineTransformation> affineTransformations
    ) {
        Point cords =
            new Point(ThreadLocalRandom.current().nextDouble() * rect.width(), Math.random() * rect.height());
        for (int i = -NORMALIZATION_STEPS_COUNT; i < iterations; i++) {
            AffineTransformation affineTransformation = affineTransformations.get(
                ThreadLocalRandom.current().nextInt(affineTransformations.size())
            );
            Transformation transformation = transformations.get(
                ThreadLocalRandom.current().nextInt(transformations.size())
            );

            cords = affineTransformation.apply(cords);
            cords = transformation.apply(cords);

            if (i > 0) {
                double theta = 0;
                for (int chunk = 0; chunk < symmetry; theta += Math.PI * 2 / symmetry, chunk++) {
                    double[] newCords = RectUtils.rotatePoint(rect, cords, theta);
                    processPoint(rect, fractalImage, newCords, affineTransformation);
                }
            }
        }
    }

    @SuppressWarnings("checkstyle:HiddenField")
    private void processPoint(
        Rect rect,
        FractalImage fractalImage,
        double[] cords,
        AffineTransformation affineTransformation
    ) {
        if (!rect.contains(cords[0], cords[1])) {
            return;
        }
        Pixel pixel = FractalImageUtils.resolvePixel(rect, cords[0], cords[1], fractalImage);
        if (pixel != null) {
            synchronized (pixel) {
                Color color = affineTransformation.affineCoefficient().color();
                pixel.resolvePixelColorByHitCount(color);
            }
        }
    }
}
