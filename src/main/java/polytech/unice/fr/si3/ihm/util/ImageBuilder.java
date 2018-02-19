package polytech.unice.fr.si3.ihm.util;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;

import java.io.File;

public class ImageBuilder {

    private ImageBuilder() {
    }


    /**
     * Create an image using an url
     * @param url path to the image
     * @return image object of the url
     */
    public static ObjectProperty<Image> getImage(String url) {
        File file = new File(url);
        Image image = new Image(file.toURI().toString());
        return new SimpleObjectProperty<>(image);
    }

    /**
     * Create an image using an url
     * @param url path to the image
     * @param width width of the image
     * @param height height of the image
     * @return image object of the url
     */
    public static ObjectProperty<Image> getImage(String url, double width, double height) {
        File file = new File(url);
        Image image = new Image(file.toURI().toString(), width, height, false, false);
        return new SimpleObjectProperty<>(image);
    }
}
