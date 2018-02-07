package polytech.unice.fr.si3.ihm.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import polytech.unice.fr.si3.ihm.model.Incident;
import polytech.unice.fr.si3.ihm.util.Constant;
import polytech.unice.fr.si3.ihm.view.IncidentCell;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.STYLESHEET_MODENA;
import static javafx.application.Application.setUserAgentStylesheet;

public class MainViewController implements Initializable {

    private Stage stage;
    private Scene scene;

    private Logger logger = LogManager.getLogger();

    public void setStage(Stage stage) {
        this.stage = stage;
        scene = stage.getScene();
    }

    @FXML
    private JFXButton searchButton;

    @FXML
    private JFXButton addIncidentButton;

    @FXML
    private JFXListView<Incident> incidentsView;

    @FXML
    void addIncident(MouseEvent event) {

        logger.debug("Loading FXML for main view from: {}", Constant.ADD_INCIDENT_FXML);
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(getClass().getResourceAsStream(Constant.ADD_INCIDENT_FXML));
            stage.setMinHeight(400);
            stage.setMinWidth(700);
            logger.debug("Showing JFX scene");
            scene = new Scene(rootNode, 1280, 720);
            scene.getStylesheets().add("/styles/main.css");
            stage.setTitle("Polissue - Ajouter un incident");
            stage.setScene(scene);
            setUserAgentStylesheet(STYLESHEET_MODENA);

            AddIncidentController controller = loader.getController();
            controller.setStage(stage);
            controller.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void searchIncident(MouseEvent event) {
        throw new UnsupportedOperationException();
    }


    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Incident> incidents = FXCollections.observableArrayList();
        incidents.add(new Incident("Lampe Cassé", "ampoule qui a claqué", "Mosser"));
        incidents.add(new Incident("Wifi Lent", "je peux pas dl GOT", "Collet"));


        incidentsView.setCellFactory(
                new Callback<ListView<Incident>, ListCell<Incident>>() {
                    @Override
                    public ListCell<Incident> call(ListView<Incident> param) {
                        return new IncidentCell();
                    }
                }
        );
        incidentsView.setItems(incidents);


    }


    public void setScene(Scene scene) {
        this.scene = scene;
    }
}

