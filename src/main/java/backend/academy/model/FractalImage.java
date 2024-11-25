package backend.academy.model;

public record FractalImage(Pixel[][] pixels, int width, int height) {

    public static FractalImage createFractalImage(int width, int height) {
        Pixel[][] data = new Pixel[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                data[i][j] = new Pixel();
            }
        }
        return new FractalImage(data, width, height);
    }

    public boolean isPixelInCanvas(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public Pixel getPixelByCords(int x, int y) {
        return pixels[x][y];
    }
}
