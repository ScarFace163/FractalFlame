package backend.academy.transormations;

import backend.academy.model.AffineCoefficient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class AffineTransformation implements Transformation {

    AffineCoefficient affineCoefficient;

    @Override
    public double[] apply(double x, double y) {
        x = affineCoefficient.a() + x * affineCoefficient.b() + y * affineCoefficient.c();
        y = affineCoefficient.d() + x * affineCoefficient.e() + y * affineCoefficient.f();
        return new double[] {x, y};
    }
}
