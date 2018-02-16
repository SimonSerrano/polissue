package polytech.unice.fr.si3.ihm.model;

import polytech.unice.fr.si3.ihm.util.Constant;

public enum Category {

    BEHAVIOR(Constant.BEHAVIOR_CATEGORY, "COMPORTEMENT"),
    HEALTH(Constant.HEALTH_CATEGORY, "SANTÉ"),
    LOGISTIC(Constant.LOGISTIC_CATEGORY, "LOGISTIQUE"),
    STUFF(Constant.STUFF_CATEGORY, "MATÉRIEL"),
    FIVE(Constant.FIVE_CATEGORY, "CINQ"),
    OTHER(Constant.OTHER_CATEGORY, "AUTRE");

    private String categoryFilePath;
    private String frenchString;

    Category(String categoryFilePath, String frenchString) {
        this.categoryFilePath = categoryFilePath;
        this.frenchString = frenchString;
    }

    public String getCategoryFilePath() {
        return categoryFilePath;
    }

    public String getFrenchString() {
        return frenchString;
    }
}
