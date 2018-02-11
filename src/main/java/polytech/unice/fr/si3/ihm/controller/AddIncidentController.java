package polytech.unice.fr.si3.ihm.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import polytech.unice.fr.si3.ihm.factory.IncidentJSONFactory;
import polytech.unice.fr.si3.ihm.model.Incident;
import polytech.unice.fr.si3.ihm.util.Constant;
import polytech.unice.fr.si3.ihm.util.JsonWriter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.STYLESHEET_MODENA;
import static javafx.application.Application.setUserAgentStylesheet;

public class AddIncidentController implements Initializable{


    private Stage stage;
    private Scene scene;


    private Logger logger = LogManager.getLogger();



    @FXML
    private JFXTextField incidentTitle;

    @FXML
    private JFXTextField incidentDeclarer;

    @FXML
    private JFXTextArea incidentDescription;


    @FXML
    private JFXButton incidentCategoryOne;

    @FXML
    private JFXButton incidentCategoryTwo;

    @FXML
    private JFXButton incidentCategoryThree;

    @FXML
    private JFXButton incidentCategoryFour;

    @FXML
    private JFXButton incidentCategoryFive;

    @FXML
    private JFXButton incidentCategorySix;


    @FXML
    private Label incidentTitleError;

    @FXML
    private Label incidentDeclarerError;

    @FXML
    private Label incidentDescriptionError;

    @FXML
    private Label incidentCategoryError;


    /**
     * Manages the click on the back button
     * @param event mouse click event
     */
    @FXML
    void backToIncidentList(MouseEvent event) {
        logger.debug("Back button clicked");
        goBackToIncidentList();
    }

    /**
     * Manages the click on the validate button
     * @param event mouse click event
     */
    @FXML
    void validateIncident(MouseEvent event) {
        //TODO write the new incident in the data base
        logger.debug("Validate incident button clicked");
        resetErrors();
        if (!incidentTitle.getText().isEmpty() && !incidentDeclarer.getText().isEmpty() && !incidentDescription.getText().isEmpty()) {

            Incident incident=new Incident(incidentTitle.getText(),incidentDescription.getText(),incidentDeclarer.getText());
            JsonWriter jsonWriter=new JsonWriter();
            IncidentJSONFactory incidentJSONFactory=new IncidentJSONFactory();
            jsonWriter.write(incidentJSONFactory.produce(incident),"src/test/resources/data/incidents.json");

            goBackToIncidentList();
        }else {
            showErrors();
        }

    }

    /**
     * Resets the visibility of the error labels
     */
    private void resetErrors() {
        incidentTitleError.setVisible(false);
        incidentDeclarerError.setVisible(false);
        incidentDescriptionError.setVisible(false);
        incidentCategoryError.setVisible(false);
    }

    /**
     * Shows the proper erros if the fields are empty
     */
    private void showErrors() {
        if (incidentTitle.getText().isEmpty()){
            incidentTitleError.setVisible(true);
        }
        if (incidentDeclarer.getText().isEmpty()){
            incidentDeclarerError.setVisible(true);
        }
        if (incidentDescription.getText().isEmpty()){
            incidentDescriptionError.setVisible(true);
        }
    }

    /**
     * Changes the view to the main view
     */
    private void goBackToIncidentList(){
        logger.debug("Loading FXML for main view from: {}", Constant.MAIN_PAGE_FXML);
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(getClass().getResourceAsStream(Constant.MAIN_PAGE_FXML));
            stage.setMinHeight(400);
            stage.setMinWidth(700);
            logger.debug("Showing JFX scene");
            scene = new Scene(rootNode, 1280, 720);
            scene.getStylesheets().add("/styles/main.css");
            stage.setTitle("Polissue - Ajouter un incident");
            stage.setScene(scene);
            setUserAgentStylesheet(STYLESHEET_MODENA);

            MainViewController controller = loader.getController();
            controller.setStage(stage);
            controller.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    void categoryOneClicked(MouseEvent event) {
        logger.debug("category one clicked");
        incidentCategoryOne.getStyleClass().removeAll("category-selected");
        incidentCategoryOne.getStyleClass().add("category-selected");
        resetCategories(incidentCategoryOne);
    }


    @FXML
    void categoryTwoClicked(MouseEvent event) {
        logger.debug("category two clicked");
        incidentCategoryTwo.getStyleClass().removeAll("category-selected");
        incidentCategoryTwo.getStyleClass().add("category-selected");
        resetCategories(incidentCategoryTwo);
    }

    @FXML
    void categoryThreeClicked(MouseEvent event) {
        logger.debug("category three clicked");
        incidentCategoryThree.getStyleClass().removeAll("category-selected");
        incidentCategoryThree.getStyleClass().add("category-selected");
        resetCategories(incidentCategoryThree);
    }

    @FXML
    void categoryFourClicked(MouseEvent event) {
        logger.debug("category four clicked");
        incidentCategoryFour.getStyleClass().removeAll("category-selected");
        incidentCategoryFour.getStyleClass().add("category-selected");
        resetCategories(incidentCategoryFour);
    }

    @FXML
    void categoryFiveClicked(MouseEvent event) {
        logger.debug("category five clicked");
        incidentCategoryFive.getStyleClass().removeAll("category-selected");
        incidentCategoryFive.getStyleClass().add("category-selected");
        resetCategories(incidentCategoryFive);
    }

    @FXML
    void categorySixClicked(MouseEvent event) {
        logger.debug("category six clicked");
        incidentCategorySix.getStyleClass().removeAll("category-selected");
        incidentCategorySix.getStyleClass().add("category-selected");
        resetCategories(incidentCategorySix);
    }

    /**
     * Resets the selection of the categories
     * @param button the button that has been selected by the user
     */
    private void resetCategories(JFXButton button){
        if (!incidentCategoryOne.equals(button)){
            incidentCategoryOne.getStyleClass().removeAll("category-selected");
        }
        if (!incidentCategoryTwo.equals(button)){
            incidentCategoryTwo.getStyleClass().removeAll("category-selected");
        }
        if (!incidentCategoryThree.equals(button)){
            incidentCategoryThree.getStyleClass().removeAll("category-selected");
        }
        if (!incidentCategoryFour.equals(button)){
            incidentCategoryFour.getStyleClass().removeAll("category-selected");
        }
        if (!incidentCategoryFive.equals(button)){
            incidentCategoryFive.getStyleClass().removeAll("category-selected");
        }
        if (!incidentCategorySix.equals(button)){
            incidentCategorySix.getStyleClass().removeAll("category-selected");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}

