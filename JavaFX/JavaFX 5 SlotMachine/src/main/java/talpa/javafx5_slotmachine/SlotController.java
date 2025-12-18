package talpa.javafx5_slotmachine;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.List;

public class SlotController {

    private static final String BASE = "/talpa/javafx5_slotmachine/img/";

    private final List<String> files = List.of(
            "arancio.jpg",
            "banane.jpg",
            "ciliegie.jpg",
            "cocomero.jpg",
            "limone.jpg",
            "prugna.jpg",
            "sette.jpg"
    );

    @FXML
    private ImageView iv1;

    @FXML
    private ImageView iv2;

    @FXML
    private ImageView iv3;

    @FXML
    private Slider sldSpin;

    @FXML
    public void onSpinSliderReleased() {
        iv1.setImage(loadRandomImage());
        iv2.setImage(loadRandomImage());
        iv3.setImage(loadRandomImage());
        sldSpin.setValue(sldSpin.getMax());
    }

    private Image loadRandomImage() {
        int index = (int) (Math.random() * files.size());
        String path = BASE + files.get(index);
        InputStream is = getClass().getResourceAsStream(path);
        if (is == null) {
            throw new IllegalArgumentException("Risorsa non trovata: " + path);
        }
        return new Image(is);
    }
}
