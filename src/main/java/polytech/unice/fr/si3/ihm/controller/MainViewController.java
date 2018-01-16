package polytech.unice.fr.si3.ihm.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Button addIncident;

    @FXML
    void addIncident(MouseEvent event) {
        if (event.equals(MouseEvent.MOUSE_RELEASED)){

        }
    }




}

