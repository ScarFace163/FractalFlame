package backend.academy;

import backend.academy.enums.ImageFormat;
import backend.academy.utils.ImageUtils;
import lombok.experimental.UtilityClass;
import java.nio.file.Path;

@UtilityClass
public class Main {
    public static void main(String[] args) {
        ImageUtils.saveImage(Path.of("src/main/resources/pic.jpg"), ImageFormat.PNG);
    }
}
