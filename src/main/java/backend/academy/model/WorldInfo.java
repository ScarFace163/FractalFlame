package backend.academy.model;

import backend.academy.enums.AffineCoefficientColor;
import backend.academy.transormations.Transformation;
import java.util.List;
import lombok.Builder;

@Builder(toBuilder = true)
public record WorldInfo(
    AffineCoefficientColor color,
    int width,
    int height,
    int iterations,
    List<Transformation> transformations,
    int threadCount
) {
}
