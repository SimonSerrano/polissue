package polytech.unice.fr.si3.ihm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public enum Category {
    //CATEGORY permet d'afficher cet enum par défaut dans la combobox lorsqu'aucune autre catégprie n est selectionnée
    CATEGORY("Catégorie"),
    BEHAVIOR("COMPORTEMENT"),
    HEALTH("SANTÉ"),
    LOGISTIC("LOGISTIQUE"),
    STUFF("MATÉRIEL"),
    METEO("METEO"),
    OTHER("AUTRE");

    private StringProperty frenchString;

    Category(String frenchString) {
        this.frenchString = new SimpleStringProperty(frenchString);
    }


    public StringProperty getFrenchString() {
        return frenchString;
    }
}
