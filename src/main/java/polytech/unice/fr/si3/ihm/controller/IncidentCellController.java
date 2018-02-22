package polytech.unice.fr.si3.ihm.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import polytech.unice.fr.si3.ihm.model.Emergency;
import polytech.unice.fr.si3.ihm.model.Incident;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

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
    private Rectangle emergency;

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

    @FXML
    private VBox bottomCell;

    @FXML
    private Label description;

    @FXML
    private Label declarer;


    @FXML
    private VBox cell;


    private boolean cellClicked = false;


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
    void cellClick(MouseEvent event) {
        if (!cellClicked) {
            cell.getChildren().add(bottomCell);
            TranslateTransition tt = new TranslateTransition(Duration.millis(500), description);
            TranslateTransition ttt = new TranslateTransition(Duration.millis(750), declarer);
            tt.setFromX(800);
            tt.setToX(0);
            ttt.setFromX(800);
            ttt.setToX(0);
            tt.play();
            ttt.play();
            cellClicked = true;
        }else {
            cell.getChildren().remove(bottomCell);
            cellClicked = false;
        }
    }



    @FXML
    void downed(ActionEvent event) {
        //downvote this issue
        if (!downvoted) {
            scaleTransitionOnVote();
            incident.downvote();
            setItem(incident);
            downvoted = true;
            upvoted = false;
        }
    }



    @FXML
    void upped(ActionEvent event) {
        //upvote this issue
        if(!upvoted) {
            scaleTransitionOnVote();
            incident.upvote();
            setItem(incident);
            upvoted = true;
            downvoted = false;
        }
    }

    private void scaleTransitionOnVote(){
        final ScaleTransition[] st = {new ScaleTransition(Duration.millis(200), likes)};
        st[0].setByY(3);
        st[0].setByX(3);
        st[0].setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                st[0] = new ScaleTransition(Duration.millis(200), likes);
                st[0].setByY(-3);
                st[0].setByX(-3);
                st[0].play();
            }
        });
        st[0].play();
    }

    public Color getColorFromEmergency(Emergency em){
        switch (em){
            case LOW:
                return Color.GREY;
            case MEDIUM:
                return Color.YELLOW;
            case HIGH:
                return Color.ORANGE;
            case CRITICAL:
                return Color.RED;
            default:
                return Color.BLACK;
        }
    }


    public void setItem(Incident item) {
        cell.getChildren().remove(bottomCell);
        incident = item;
        title.textProperty().bind(new SimpleStringProperty(item.getTitle()));
        category.textProperty().bind(new SimpleStringProperty(item.getCategory().getFrenchString()));
        date.textProperty().bind(new SimpleStringProperty("déclaré le " + item.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        likes.textProperty().bind(new SimpleStringProperty(String.valueOf(item.getLikes())));
        emergency.setFill(getColorFromEmergency(item.getEmergency()));
        description.textProperty().bind(new SimpleStringProperty(item.getDescription()));
        declarer.textProperty().bind(new SimpleStringProperty(item.getDeclarer().getName()));
    }

    public Node getView() {
        return view;
    }
}
