package backend.academy.transormations;

import backend.academy.model.Point;

public interface Transformation {
    Point apply(Point point);

}
