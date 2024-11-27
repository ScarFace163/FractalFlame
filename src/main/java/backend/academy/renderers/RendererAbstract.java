package backend.academy.renderers;

import backend.academy.model.AffineCoefficient;
import backend.academy.model.FractalImage;
import backend.academy.model.Pixel;
import backend.academy.model.Rect;
import backend.academy.transormations.AffineTransformation;
import backend.academy.transormations.Transformation;
import backend.academy.utils.FractalImageUtils;
import backend.academy.utils.RectUtils;
import lombok.RequiredArgsConstructor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public abstract class RendererAbstract implements Renderer {

    private static final int NORMALIZATION_STEPS_COUNT = 20;
    private static final Random random = new Random();

    protected final int affineCount;
    protected final int samples;
    protected final int iterations;
    protected final int symmetry;
    protected final List<Transformation> transformations;

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
            affineTransformations.add(new AffineTransformation(AffineCoefficient.createRandomAffineCoefficient()));
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
        double[] cords = new double[] {random.nextDouble() * rect.width(), Math.random() * rect.height()};
        for (int i = -NORMALIZATION_STEPS_COUNT; i < iterations; i++) {
            AffineTransformation affineTransformation = affineTransformations.get(
                random.nextInt(affineTransformations.size())
            );
            Transformation transformation = transformations.get(
                random.nextInt(transformations.size())
            );

            cords = affineTransformation.apply(cords[0], cords[1]);
            cords = transformation.apply(cords[0], cords[1]);

            if (i > 0) {
                double theta = 0;
                for (int chunk = 0; chunk < symmetry; theta += Math.PI * 2 / symmetry, chunk++) {
                    double[] newCords = RectUtils.rotatePoint(rect, cords[0], cords[1], theta);
                    processPoint(rect, fractalImage, newCords, affineTransformation);
                }
            }
        }
    }
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
