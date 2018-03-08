package polytech.unice.fr.si3.ihm.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import polytech.unice.fr.si3.ihm.model.Incident;



public class IncidentDetailsController {

    @FXML
    private Label incidentTitle;

    @FXML
    private Label incidentDescription;

    @FXML
    private Label incidentDeclarer;



    public void initContent(Incident selectedItem) {
        incidentTitle.textProperty().bind(selectedItem.getTitle());
        incidentDescription.textProperty().bind(selectedItem.getDescription());
        incidentDeclarer.textProperty().bind(selectedItem.getDeclarer().getName());
    }
}
