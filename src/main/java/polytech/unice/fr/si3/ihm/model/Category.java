package polytech.unice.fr.si3.ihm.model;

import polytech.unice.fr.si3.ihm.util.Constant;

public enum Category {

    BEHAVIOR(Constant.BEHAVIOR_CATEGORY),
    HEALTH(Constant.HEALTH_CATEGORY),
    LOGISTIC(Constant.LOGISTIC_CATEGORY),
    STUFF(Constant.STUFF_CATEGORY),
    FIVE(Constant.FIVE_CATEGORY),
    OTHER(Constant.OTHER_CATEGORY);

    private String categoryFilePath;

    Category(String categoryFilePath) {
        this.categoryFilePath = categoryFilePath;
    }

    public String getCategoryFilePath() {
        return categoryFilePath;
    }
}
