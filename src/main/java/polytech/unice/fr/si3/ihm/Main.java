package polytech.unice.fr.si3.ihm;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import polytech.unice.fr.si3.ihm.controller.MainViewController;
import polytech.unice.fr.si3.ihm.factory.ModelBuilder;
import polytech.unice.fr.si3.ihm.model.Incident;
import polytech.unice.fr.si3.ihm.util.Constant;
import polytech.unice.fr.si3.ihm.util.JsonWriter;

public class Main extends Application {

    private Logger logger = LogManager.getLogger();
    public static ObservableList<Incident> INCIDENTS;

    public static void main(String[] args) {
        launch(args);
    }


    private void buildContent(){
        ModelBuilder mb= new ModelBuilder();
        INCIDENTS =FXCollections.observableArrayList(mb.readIncidents(Constant.INCIDENT_DATA_JSON));
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        logger.info("Started Polissue");

        buildContent();

        logger.debug("Loading FXML for main view from: {}", Constant.MAIN_PAGE_FXML);
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = loader.load(getClass().getResourceAsStream(Constant.MAIN_PAGE_FXML));
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(700);

        logger.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode, 1280, 720);
        scene.getStylesheets().add("/styles/main.css");
        scene.getStylesheets().add("/styles/button.css");
        primaryStage.setTitle("Polissue");
        primaryStage.setScene(scene);
        Image logo = new Image(Constant.POLISSUE_LOGO);
        primaryStage.getIcons().add(logo);

        MainViewController controller = loader.getController();
        controller.setStage(primaryStage);
        controller.setScene(scene);
        controller.initContent();

        primaryStage.show();
    }

    @Override
    public void stop(){
        JsonWriter jsonWriter=new JsonWriter();
        jsonWriter.write(INCIDENTS,"src/main/resources/data/INCIDENTS.json");
        logger.info("Stage is closing");
    }
}