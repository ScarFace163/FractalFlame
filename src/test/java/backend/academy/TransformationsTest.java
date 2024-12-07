package backend.academy;

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
    public void given_correct_input_return_correct_result_for_apply_disc() {
        DiscTransformation discTransformation = new DiscTransformation();
        double[] cords = new double[] {100, 100};
        double[] newCords = discTransformation.apply(cords[0], cords[1]);
        assertEquals(newCords[0], -0.24240849259154232);
        assertEquals(newCords[1], -0.06114018906984319);
    }

    @Test
    public void given_correct_input_return_correct_result_for_apply_exp() {
        ExponentialTransformation exponentialTransformation = new ExponentialTransformation();
        double[] cords = new double[] {100, 100};
        double[] newCords = exponentialTransformation.apply(cords[0], cords[1]);
        assertEquals(newCords[0], 9.889030319346946E42);
        assertEquals(newCords[1], 1.9425879869873473E28);
    }

    @Test
    public void given_correct_input_return_correct_result_for_apply_heart() {
        HeartTransformation heartTransformation = new HeartTransformation();
        double[] cords = new double[] {100, 100};
        double[] newCords = heartTransformation.apply(cords[0], cords[1]);
        assertEquals(newCords[0], -127.06647811756834);
        assertEquals(newCords[1], 94.90994796249471);
    }

    @Test
    public void given_correct_input_return_correct_result_for_apply_horse() {
        HorseshoeTransformation horseshoeTransformation = new HorseshoeTransformation();
        double[] cords = new double[] {100, 100};
        double[] newCords = horseshoeTransformation.apply(cords[0], cords[1]);
        assertEquals(newCords[0], 0.0);
        assertEquals(newCords[1], 20000.0);
    }

    @Test
    public void given_correct_input_return_correct_result_for_apply_linear() {
        LinearTransformation linearTransformation = new LinearTransformation();
        double[] cords = new double[] {100, 100};
        double[] newCords = linearTransformation.apply(cords[0], cords[1]);
        assertEquals(newCords[0], 105);
        assertEquals(newCords[1], 105);
    }

    @Test
    public void given_correct_input_return_correct_result_for_apply_polar() {
        PolarTransformation polarTransformation = new PolarTransformation();
        double[] cords = new double[] {100, 100};
        double[] newCords = polarTransformation.apply(cords[0], cords[1]);
        assertEquals(newCords[0], 0.25);
        assertEquals(newCords[1], 140.4213562373095);
    }

    @Test
    public void given_correct_input_return_correct_result_for_apply_popcorn() {
        PopcornTransformation popcornTransformation = new PopcornTransformation();
        double[] cords = new double[] {100, 100};
        double[] newCords = popcornTransformation.apply(cords[0], cords[1]);
        assertEquals(newCords[0], 100.95283519326958);
        assertEquals(newCords[1], 100.95283519326958);
    }

    @Test
    public void given_correct_input_return_correct_result_for_apply_sinus() {
        SinusTransformation sinusTransformation = new SinusTransformation();
        double[] cords = new double[] {100, 100};
        double[] newCords = sinusTransformation.apply(cords[0], cords[1]);
        assertEquals(newCords[0], -0.5063656411097588);
        assertEquals(newCords[1], -0.5063656411097588);
    }

    @Test
    public void given_correct_input_return_correct_result_for_apply_spherical() {
        SphericalTransformation sphericalTransformation = new SphericalTransformation();
        double[] cords = new double[] {100, 100};
        double[] newCords = sphericalTransformation.apply(cords[0], cords[1]);
        assertEquals(newCords[0], 0.005);
        assertEquals(newCords[1], 0.005);
    }

    @Test
    public void given_correct_input_return_correct_result_for_apply_swirl() {
        SwirlTransformation swirlTransformation = new SwirlTransformation();
        double[] cords = new double[] {100, 100};
        double[] newCords = swirlTransformation.apply(cords[0], cords[1]);
        assertEquals(newCords[0], -23.121492861462542);
        assertEquals(newCords[1], 139.51844526032153);
    }
}
