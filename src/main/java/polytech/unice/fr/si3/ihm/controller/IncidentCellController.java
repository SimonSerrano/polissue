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

    /**
     * reduce the likes count by one
     *
     * @param event
     */
    @FXML
    void downed(ActionEvent event) {
        incident.changeLikes(-1);
        updateLike();
    }

    @FXML
    void toDetails(MouseEvent event) {
        //open details page
    }

    @FXML
    void upped(ActionEvent event) {
        incident.changeLikes(1);
        updateLike();
    }

    private void updateLike() {
        String likesString = String.valueOf(incident.getLikes()) + " likes";
        this.likes.setText(likesString);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setItem(incident);
    }

    public void setItem(Incident item) {
        updateLike();
        this.incident = item;
        this.title.setText(item.getTitle());
    }

    public Label getLikes() {
        return likes;
    }
}
