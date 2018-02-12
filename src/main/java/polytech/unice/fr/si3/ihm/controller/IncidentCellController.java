package polytech.unice.fr.si3.ihm.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import polytech.unice.fr.si3.ihm.model.Category;
import polytech.unice.fr.si3.ihm.model.Incident;
import polytech.unice.fr.si3.ihm.util.Constant;
import polytech.unice.fr.si3.ihm.util.ImageBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.STYLESHEET_MODENA;
import static javafx.application.Application.setUserAgentStylesheet;

public class IncidentCellController implements Initializable {
    private Incident incident;

    private Logger logger = LogManager.getLogger();

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
        if (item != null) {
            this.incident = item;
            this.title.setText(item.getTitle());
            this.icon.setImage(ImageBuilder.getImage(item.getCategory().getCategoryFilePath()));
        }
    }
}
