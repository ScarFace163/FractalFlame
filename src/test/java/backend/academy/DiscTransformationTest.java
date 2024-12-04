package backend.academy;

import backend.academy.transormations.DiscTransformation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscTransformationTest {
    @Test
    public void given_correct_input_return_correct_result_for_apply(){
        DiscTransformation discTransformation = new DiscTransformation();
        double[] cords = new double[]{100,100};
        double[] newCords = discTransformation.apply(cords[0], cords[1]);
        assertEquals(newCords[0], -0.24240849259154232);
        assertEquals(newCords[1], -0.06114018906984319);
    }
}
