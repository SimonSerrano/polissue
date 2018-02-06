package polytech.unice.fr.si3.ihm.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import polytech.unice.fr.si3.ihm.model.Incident;

import java.net.URL;
import java.util.ResourceBundle;

public class IncidentCellController implements Initializable {
    private Incident incident;

    @FXML
    private BorderPane cellParent;

    @FXML
    private Label likes;

    @FXML
    private JFXButton upButton;

    @FXML
    private JFXButton downButton;

    @FXML
    private Label title;
    @FXML
    private ImageView icon;

    public IncidentCellController() {
        this(new Incident("", "", ""));
    }

    public IncidentCellController(Incident incident) {
        this.incident = incident;
    }

    @FXML
    void downed(ActionEvent event) {
        //downvote this issue
    }

    @FXML
    void toDetails(MouseEvent event) {
        //open details page
    }

    @FXML
    void upped(ActionEvent event) {
        //upvote this issue
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setItem(incident);
    }

    public void setItem(Incident item) {
        this.incident = item;
        this.title.setText(item.getTitle());
    }
}
