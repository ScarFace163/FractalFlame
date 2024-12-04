package backend.academy;

import backend.academy.transormations.ExponentialTransformation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExponentialTransformationTest {

    @Test
    public void given_correct_input_return_correct_result_for_apply() {
        ExponentialTransformation exponentialTransformation = new ExponentialTransformation();
        double[] cords = new double[] {100, 100};
        double[] newCords = exponentialTransformation.apply(cords[0], cords[1]);
        assertEquals(newCords[0], 9.889030319346946E42);
        assertEquals(newCords[1], 1.9425879869873473E28);
    }
}
