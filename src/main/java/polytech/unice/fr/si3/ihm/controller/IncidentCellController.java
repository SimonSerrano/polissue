package polytech.unice.fr.si3.ihm.controller;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import polytech.unice.fr.si3.ihm.model.Incident;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import static polytech.unice.fr.si3.ihm.util.Constant.INCIDENT_CELL_FXML;

public class IncidentCellController {
    private Incident incident;
    private Node view;

    private Logger logger = LogManager.getLogger();

    private boolean downvoted = false;
    private boolean upvoted = false;

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
    private Label category;
    @FXML
    private Label date;



    public IncidentCellController(Incident incident) {
        this.incident = incident;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(INCIDENT_CELL_FXML));
        try {
            loader.setControllerFactory(type -> {
                if (type == IncidentCellController.class) {
                    return this;
                } else {
                    try {
                        return type.newInstance();
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception e){
                        throw new RuntimeException();
                    }

                }
            });
            view = loader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void downed(ActionEvent event) {
        //downvote this issue
        if (!downvoted) {
            incident.downvote();
            setItem(incident);
            downvoted = true;
            upvoted = false;
            resetVote();
            downButton.getStyleClass().add("downvoted");
        }
    }

    private void resetVote(){
        upButton.getStyleClass().removeAll("upvoted");
        downButton.getStyleClass().removeAll("downvoted");
    }


    @FXML
    void upped(ActionEvent event) {
        //upvote this issue
        if(!upvoted) {
            incident.upvote();
            setItem(incident);
            upvoted = true;
            downvoted = false;
            resetVote();
            upButton.getStyleClass().add("upvoted");
        }
    }



    public void setItem(Incident item) {
        incident = item;
        title.textProperty().bind(new SimpleStringProperty(item.getTitle()));
        category.textProperty().bind(new SimpleStringProperty(item.getCategory().getFrenchString()));
        date.textProperty().bind(new SimpleStringProperty("déclaré le " + item.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        likes.textProperty().bind(new SimpleStringProperty(String.valueOf(item.getLikes())));
    }

    public Node getView() {
        return view;
    }
}
