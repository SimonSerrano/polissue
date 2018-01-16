package polytech.unice.fr.si3.ihm;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import polytech.unice.fr.si3.ihm.controller.MainViewController;

public class Main extends Application {

    private Logger logger = LogManager.getLogger();


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
    //TODO
        logger.info("Started Polissue");

        String fxmlFile = "/fxml/main_view.fxml";
        logger.debug("Loading FXML for main view from: {}", fxmlFile);
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(700);

        logger.debug("Showing JFX scene");
        Scene scene = new Scene(rootNode, 1280, 720);
        scene.getStylesheets().add("/styles/main.css");
        primaryStage.setTitle("Polissue");
        primaryStage.setScene(scene);
        setUserAgentStylesheet(STYLESHEET_MODENA);

        MainViewController controller = loader.getController();
        controller.setStage(primaryStage);

        primaryStage.show();

    }
}