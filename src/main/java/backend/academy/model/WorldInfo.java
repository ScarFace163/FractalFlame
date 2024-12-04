package backend.academy.model;

import java.util.List;

import backend.academy.enums.AffineCoefficientColor;
import backend.academy.transormations.Transformation;
import lombok.Builder;

@Builder(toBuilder = true)
public record WorldInfo(
    AffineCoefficientColor color,
    int width,
    int height,
    int iterations,
    List<Transformation> transformations
) {
}
