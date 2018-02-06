package polytech.unice.fr.si3.ihm.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import polytech.unice.fr.si3.ihm.model.Incident;
import polytech.unice.fr.si3.ihm.view.IncidentCell;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    private Stage stage;
    private Scene scene;


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
        if (event.equals(MouseEvent.MOUSE_RELEASED)) {
            //open the new incident stage
            //Stage incidentStage = new Stage();
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


}

