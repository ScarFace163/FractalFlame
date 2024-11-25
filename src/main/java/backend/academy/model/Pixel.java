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
public class Pixel{
    Color color = new Color(0, 0, 0);

    int hitCount = 0;
}
