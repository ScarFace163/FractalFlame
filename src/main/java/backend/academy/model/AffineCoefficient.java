package backend.academy.model;

import backend.academy.enums.AffineCoefficientColor;
import java.awt.Color;
import java.util.Random;

public record AffineCoefficient(
    double a,
    double b,
    double c,
    double d,
    double e,
    double f,
    Color color
) {
    private static final int MAX_COLOR = 256;
    private static final Random RANDOM = new Random();

    @SuppressWarnings({"checkstyle:ReturnCount", "checkstyle:MagicNumber"})
    public static AffineCoefficient createRandomAffineCoefficient(AffineCoefficientColor color) {
        double a = RANDOM.nextDouble(-1, 1);
        double b = RANDOM.nextDouble(-1, 1);
        double c = RANDOM.nextDouble(-1, 1);
        double d = RANDOM.nextDouble(-1, 1);
        double e = RANDOM.nextDouble(-1, 1);
        double f = RANDOM.nextDouble(-1, 1);

        while (!isAffineCoefficientValid(a, b, d, e)) {
            a = RANDOM.nextDouble(-1, 1);
            b = RANDOM.nextDouble(-1, 1);
            d = RANDOM.nextDouble(-1, 1);
            e = RANDOM.nextDouble(-1, 1);
        }
        switch (color) {
            case NEON -> {
                return new AffineCoefficient(
                    a, b, c, d, e, f,
                    new Color(
                        RANDOM.nextInt(131, 215),
                        RANDOM.nextInt(77, 239),
                        RANDOM.nextInt(226, 246)
                    )
                );
            }
            case PINK -> {
                return new AffineCoefficient(
                    a, b, c, d, e, f,
                    new Color(
                        RANDOM.nextInt(204, 255),
                        RANDOM.nextInt(102, 211),
                        RANDOM.nextInt(249, MAX_COLOR)
                    )
                );
            }
            case ORANGE -> {
                return new AffineCoefficient(
                    a, b, c, d, e, f,
                    new Color(
                        RANDOM.nextInt(200, MAX_COLOR),
                        RANDOM.nextInt(57, 86),
                        RANDOM.nextInt(0, 26)
                    )
                );
            }
            case BRIGHT -> {
                return new AffineCoefficient(
                    a, b, c, d, e, f,
                    new Color(
                        RANDOM.nextInt(220, MAX_COLOR),
                        RANDOM.nextInt(220, MAX_COLOR),
                        RANDOM.nextInt(220, MAX_COLOR)
                    )
                );
            }
            default -> {
                return new AffineCoefficient(
                    a, b, c, d, e, f,
                    new Color(
                        RANDOM.nextInt(MAX_COLOR),
                        RANDOM.nextInt(MAX_COLOR),
                        RANDOM.nextInt(MAX_COLOR)
                    )
                );
            }
        }
    }

    private static boolean isAffineCoefficientValid(double a, double b, double d, double e) {
        return ((a * a + d * d) < 1) && ((b * b - e * e) < 1)
            && ((a * a + b * b + d * d + e * e) < (1 + (a * e - b * d) * (a * e - b * d)));
    }
}
