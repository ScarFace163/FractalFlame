package backend.academy.renderers;

import backend.academy.model.FractalImage;
import backend.academy.model.Rect;

public interface Renderer {
    FractalImage render(int width, int height, Rect rect);
}
