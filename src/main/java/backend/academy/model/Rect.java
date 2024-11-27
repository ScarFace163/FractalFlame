package backend.academy.model;

public record Rect(
    double x,
    double y,
    double width,
    double height
) {
    public boolean contains(double x, double y) {
        return x >= this.x && x < this.x + width && y >= this.y && y < this.y + height;
    }
}
