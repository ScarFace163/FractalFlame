package backend.academy;

import backend.academy.model.Point;
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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformationsTest {

    @Test
    public void givenCorrectInputReturnCorrectResultForApplyDisc() {
        DiscTransformation discTransformation = new DiscTransformation();
        Point point = discTransformation.apply(new Point(100,100));
        assertEquals(point.x(), -0.24240849259154232);
        assertEquals(point.y(), -0.06114018906984319);
    }

    @Test
    public void givenCorrectInputReturnCorrectResultForApplyExp() {
        ExponentialTransformation exponentialTransformation = new ExponentialTransformation();
        Point point = exponentialTransformation.apply(new Point(100,100));
        assertEquals(point.x(), 9.889030319346946E42);
        assertEquals(point.y(), 1.9425879869873473E28);
    }

    @Test
    public void givenCorrectInputReturnCorrectResultForApplyHeart() {
        HeartTransformation heartTransformation = new HeartTransformation();
        Point point = heartTransformation.apply(new Point(100,100));
        assertEquals(point.x(), -127.06647811756834);
        assertEquals(point.y(), 94.90994796249471);
    }

    @Test
    public void givenCorrectInputReturnCorrectResultForApplyHorse() {
        HorseshoeTransformation horseshoeTransformation = new HorseshoeTransformation();
        Point point = horseshoeTransformation.apply(new Point(100,100));
        assertEquals(point.x(), 0.0);
        assertEquals(point.y(), 20000.0);
    }

    @Test
    public void givenCorrectInputReturnCorrectResultForApplyLinear() {
        LinearTransformation linearTransformation = new LinearTransformation();
        Point point = linearTransformation.apply(new Point(100,100));
        assertEquals(point.x(), 105);
        assertEquals(point.y(), 105);
    }

    @Test
    public void givenCorrectInputReturnCorrectResultForApplyPolar() {
        PolarTransformation polarTransformation = new PolarTransformation();
        Point point = polarTransformation.apply(new Point(100,100));
        assertEquals(point.x(), 0.25);
        assertEquals(point.y(), 140.4213562373095);
    }

    @Test
    public void givenCorrectInputReturnCorrectResultForApplyPopcorn() {
        PopcornTransformation popcornTransformation = new PopcornTransformation();
        Point point = popcornTransformation.apply(new Point(100,100));
        assertEquals(point.x(), 100.95283519326958);
        assertEquals(point.y(), 100.95283519326958);
    }

    @Test
    public void givenCorrectInputReturnCorrectResultForApplySinus() {
        SinusTransformation sinusTransformation = new SinusTransformation();
        Point point = sinusTransformation.apply(new Point(100,100));
        assertEquals(point.x(), -0.5063656411097588);
        assertEquals(point.y(), -0.5063656411097588);
    }

    @Test
    public void givenCorrectInputReturnCorrectResultForApplySpherical() {
        SphericalTransformation sphericalTransformation = new SphericalTransformation();
        Point point = sphericalTransformation.apply(new Point(100,100));
        assertEquals(point.x(), 0.005);
        assertEquals(point.y(), 0.005);
    }

    @Test
    public void givenCorrectInputReturnCorrectResultForApplySwirl() {
        SwirlTransformation swirlTransformation = new SwirlTransformation();
        Point point = swirlTransformation.apply(new Point(100,100));
        assertEquals(point.x(), -23.121492861462542);
        assertEquals(point.y(), 139.51844526032153);
    }
}
