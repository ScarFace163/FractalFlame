package backend.academy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.awt.Color;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pixel {
    private Color color = new Color(0, 0, 0);
    private int hitCount = 0;
    private double normal;

    public void resolvePixelColorByHitCount(Color color) {
        if (hitCount == 0) {
            this.color = color;
        } else {
            int red = (this.color.getRed() + color.getRed()) / 2;
            int green = (this.color.getGreen() + color.getGreen()) / 2;
            int blue = (this.color.getBlue() + color.getBlue()) / 2;
            this.color = new Color(red, green, blue);
        }
        hitCount++;
    }
}
