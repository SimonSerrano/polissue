package polytech.unice.fr.si3.ihm.util;

public class Constant {

    //FXML files
    public static final String MAIN_PAGE_FXML = "/fxml/main_view.fxml";
    public static final String ADD_INCIDENT_FXML = "/fxml/add_incident.fxml";
    public static final String INCIDENT_CELL_FXML = "/fxml/incident_cell.fxml";

    //Database for INCIDENTS
    public static final String INCIDENT_DATA_JSON = System.getProperty("user.dir") + "/src/main/resources/data/INCIDENTS.json";


    //Images
    public static final String HEALTH_CATEGORY = System.getProperty("user.dir")+"src/main/resources/img/polissue-health-category.png";
    public static final String BEHAVIOR_CATEGORY = System.getProperty("user.dir")+"src/main/resources/img/polissue-behavior-category.png";
    public static final String LOGISTIC_CATEGORY = System.getProperty("user.dir")+"src/main/resources/img/polissue-logistic-category.png";
    public static final String STUFF_CATEGORY = System.getProperty("user.dir")+"src/main/resources/img/polissue-stuff-category.png";
    public static final String METEO_CATEGORY = System.getProperty("user.dir")+"src/main/resources/img/polissue-five-category.png";
    public static final String OTHER_CATEGORY = System.getProperty("user.dir")+"src/main/resources/img/polissue-other-category.png";
    public static final String POLISSUE_BANNER = System.getProperty("user.dir")+"src/main/resources/img/polissue-banner.png";
    public static final String POLISSUE_LOGO = System.getProperty("user.dir")+"src/main/resources/img/polissue-logo.png";

    private Constant() {
    }
}
