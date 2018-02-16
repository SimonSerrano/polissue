package polytech.unice.fr.si3.ihm.util;

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
    public static Image getImage(String url) {
        File file = new File(url);
        return new Image(file.toURI().toString());
    }
}
