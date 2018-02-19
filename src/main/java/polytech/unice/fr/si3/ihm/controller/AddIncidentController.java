package polytech.unice.fr.si3.ihm.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import polytech.unice.fr.si3.ihm.Main;
import polytech.unice.fr.si3.ihm.model.Category;
import polytech.unice.fr.si3.ihm.model.Emergency;
import polytech.unice.fr.si3.ihm.model.Incident;
import polytech.unice.fr.si3.ihm.model.User;
import polytech.unice.fr.si3.ihm.util.Constant;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static javafx.application.Application.STYLESHEET_MODENA;
import static javafx.application.Application.setUserAgentStylesheet;
//TODO ADD AN EMERGENCY ATTRIBUTE TO THE INCIDENTS (USE EMERGENCY's ENUM)
public class AddIncidentController{


    private Stage stage;
    private Scene scene;
    private Incident incident;
    private Emergency emergency;


    private Logger logger = LogManager.getLogger();

    private Category selectedCategory;

    @FXML
    private JFXSlider incidentEmergencySlider;

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
        if (!incidentTitle.getText().isEmpty() && !incidentDeclarer.getText().isEmpty() && !incidentDescription.getText().isEmpty() && selectedCategory != null) {
            LocalDate date = LocalDate.now();
            incident=new Incident(incidentTitle.getText(),incidentDescription.getText(),new User(incidentDeclarer.getText()), 1, selectedCategory, date,convertSlideResult((int)incidentEmergencySlider.getValue()));
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
        if (selectedCategory == null){
            incidentCategoryError.setVisible(true);
        }
    }

    public Emergency convertSlideResult(int result){
        switch (result){
            case 0:
                return Emergency.LOW;
            case 1:
                return Emergency.MEDIUM;
            case 2:
                return Emergency.HIGH;
            case 3:
                return Emergency.CRITICAL;
            default:
                return Emergency.MEDIUM;
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
            if(incident!=null){
                Main.INCIDENTS.add(incident);
            }
            controller.setStage(stage);
            controller.setScene(scene);
            controller.initContent();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    void categoryOneClicked(MouseEvent event) {
        logger.debug("category one clicked");
        resetCategories();
        incidentCategoryOne.getStyleClass().add("category-selected");
        selectedCategory = Category.HEALTH;
    }


    @FXML
    void categoryTwoClicked(MouseEvent event) {
        logger.debug("category two clicked");
        resetCategories();
        incidentCategoryTwo.getStyleClass().add("category-selected");
        selectedCategory = Category.BEHAVIOR;
    }

    @FXML
    void categoryThreeClicked(MouseEvent event) {
        logger.debug("category three clicked");
        resetCategories();
        incidentCategoryThree.getStyleClass().add("category-selected");
        selectedCategory = Category.LOGISTIC;
    }

    @FXML
    void categoryFourClicked(MouseEvent event) {
        logger.debug("category four clicked");
        resetCategories();
        incidentCategoryFour.getStyleClass().add("category-selected");
        selectedCategory = Category.STUFF;
    }

    @FXML
    void categoryFiveClicked(MouseEvent event) {
        logger.debug("category five clicked");
        resetCategories();
        incidentCategoryFive.getStyleClass().add("category-selected");
        selectedCategory = Category.FIVE;
    }

    @FXML
    void categorySixClicked(MouseEvent event) {
        logger.debug("category six clicked");
        resetCategories();
        incidentCategorySix.getStyleClass().add("category-selected");
        selectedCategory = Category.OTHER;
    }

    @FXML
    public void exitApplication(ActionEvent event) {
        Platform.exit();
    }

    /**
     * Resets the selection of the categories
     */
    private void resetCategories(){
        incidentCategoryOne.getStyleClass().removeAll("category-selected");
        incidentCategoryTwo.getStyleClass().removeAll("category-selected");
        incidentCategoryThree.getStyleClass().removeAll("category-selected");
        incidentCategoryFour.getStyleClass().removeAll("category-selected");
        incidentCategoryFive.getStyleClass().removeAll("category-selected");
        incidentCategorySix.getStyleClass().removeAll("category-selected");
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void initContent(){
        incidentEmergencySlider.setValue(1);
        incidentEmergencySlider.setMinorTickCount(0);
        incidentEmergencySlider.setMajorTickUnit(1);
        incidentEmergencySlider.setSnapToTicks(true);
        incidentEmergencySlider.setShowTickMarks(true);
        incidentEmergencySlider.setShowTickLabels(true);

        incidentEmergencySlider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double n) {
                if (n < 0.5){
                    return Emergency.LOW.toString();
                }
                if (n < 1.5) {
                    return Emergency.MEDIUM.toString();
                }
                if (n < 2.5) {
                    return Emergency.HIGH.toString();
                }
                return Emergency.CRITICAL.toString();
            }

            @Override
            public Double fromString(String s) {
                switch (s) {
                    case "Novice":
                        return 0d;
                    case "Intermediate":
                        return 1d;
                    case "Advanced":
                        return 2d;
                    case "Expert":
                        return 3d;

                    default:
                        return 3d;
                }
            }
        });
    }

}

