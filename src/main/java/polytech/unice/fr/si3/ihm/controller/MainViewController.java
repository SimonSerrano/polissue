package polytech.unice.fr.si3.ihm.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainViewController{

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
    void addIncident(MouseEvent event) {
        if (event.equals(MouseEvent.MOUSE_RELEASED)){
            Stage stage = new Stage();
        }
    }

    @FXML
    void searchIncident(MouseEvent event) {

    }


    public void initContent(){
        searchButton.getStyleClass().add("button-raised");
        addIncidentButton.getStyleClass().add("button-raised");
    }




}
