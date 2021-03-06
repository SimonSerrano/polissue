package polytech.unice.fr.si3.ihm.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.property.SimpleListProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import polytech.unice.fr.si3.ihm.Main;
import polytech.unice.fr.si3.ihm.model.Category;
import polytech.unice.fr.si3.ihm.model.Filters;
import polytech.unice.fr.si3.ihm.model.Incident;
import polytech.unice.fr.si3.ihm.model.TypeOfSort;
import polytech.unice.fr.si3.ihm.util.Constant;
import polytech.unice.fr.si3.ihm.view.IncidentCell;

import java.io.IOException;


public class MainViewController {

    private Stage stage;
    private Scene scene;
    private Logger logger = LogManager.getLogger();
    private Filters filter;
    private TypeOfSort plusOrMinus;


    //Style Class used
    private static final String FILTER_SELECTED_STYLE_CLASS = "filter-button-selected";

    public void setStage(Stage stage) {
        this.stage = stage;
        scene = stage.getScene();
    }

    @FXML
    private JFXTextField searchTextField;

    @FXML
    private JFXButton searchButton;

    @FXML
    private JFXComboBox<String> categoryButton;

    @FXML
    private JFXButton likesButton;

    @FXML
    private JFXButton emergencyButton;

    @FXML
    private JFXButton dateButton;

    @FXML
    private JFXButton plusButton;

    @FXML
    private JFXButton minusButton;

    @FXML
    private JFXButton addIncidentButton;

    @FXML
    private JFXListView<Incident> incidentsView;

    @FXML
    void addIncident(MouseEvent event) {

        logger.debug("Loading FXML for main view from: {}", Constant.ADD_INCIDENT_FXML);
        FXMLLoader loader = new FXMLLoader();
        try {
            Parent rootNode = loader.load(getClass().getResourceAsStream(Constant.ADD_INCIDENT_FXML));
            stage.setMinHeight(400);
            stage.setMinWidth(700);
            logger.debug("Showing JFX scene");
            scene = new Scene(rootNode, 1280, 720);
            scene.getStylesheets().add("/styles/main.css");
            scene.getStylesheets().add("/styles/button.css");
            stage.setTitle("Polissue - Ajouter un incident");
            stage.setScene(scene);

            AddIncidentController controller = loader.getController();
            controller.setStage(stage);
            controller.setScene(scene);
            controller.initContent();

        } catch (IOException e) {
            logger.warn(e.toString());
        }

    }

    @FXML
    void searchIncident(MouseEvent event) {
        String recherche=searchTextField.getText();
        if (!recherche.isEmpty()){
            for(Incident incid: Main.INCIDENTS){
                if(incid.getTitle().equals(recherche) || incid.getDeclarer().getName().equals(recherche))
                    sortText(recherche);
            }
        }
    }

    @FXML
    void likesButtonClicked(MouseEvent event) {
        logger.debug("likes button clicked");
        filter = Filters.LIKES;
        if(!Filters.LIKES.isClicked()){
            resetFilters();
            likesButton.getStyleClass().add(FILTER_SELECTED_STYLE_CLASS);
            Filters.LIKES.setClicked(true);
            resetTypeOfSort();
            plusOrMinus=TypeOfSort.PLUS;
            plusButton.getStyleClass().add(FILTER_SELECTED_STYLE_CLASS);
            sortByFilter(plusOrMinus,filter);

        }
        else if(Filters.LIKES.isClicked()){
            resetFilters();
            Filters.LIKES.setClicked(false);
            resetTypeOfSort();
            plusOrMinus=TypeOfSort.NOTHING;
        }
    }

    @FXML
    void emergencyButtonClicked(MouseEvent event) {
        logger.debug("emergency button clicked");
        filter = Filters.EMERGENCY;
        if(!Filters.EMERGENCY.isClicked()){
            resetFilters();
            emergencyButton.getStyleClass().add(FILTER_SELECTED_STYLE_CLASS);
            Filters.EMERGENCY.setClicked(true);
            resetTypeOfSort();
            plusOrMinus=TypeOfSort.PLUS;
            plusButton.getStyleClass().add(FILTER_SELECTED_STYLE_CLASS);
            sortByFilter(plusOrMinus,filter);

        }
        else if(Filters.EMERGENCY.isClicked()){
            resetFilters();
            Filters.EMERGENCY.setClicked(false);
            resetTypeOfSort();
            plusOrMinus=TypeOfSort.NOTHING;
        }

    }

    @FXML
    void dateButtonClicked(MouseEvent event) {
        logger.debug("date button clicked");
        filter = Filters.DATE;
        if(!Filters.DATE.isClicked()){
            resetFilters();
            dateButton.getStyleClass().add(FILTER_SELECTED_STYLE_CLASS);
            Filters.DATE.setClicked(true);
            resetTypeOfSort();
            plusOrMinus=TypeOfSort.PLUS;
            plusButton.getStyleClass().add(FILTER_SELECTED_STYLE_CLASS);
            sortByFilter(plusOrMinus,filter);
        }
        else if(Filters.DATE.isClicked()){
            resetFilters();
            Filters.DATE.setClicked(false);
            resetTypeOfSort();
            plusOrMinus=TypeOfSort.NOTHING;
        }
    }

    @FXML
    void minusButtonClicked(MouseEvent event) {
        if(filter.isClicked()){
            resetTypeOfSort();
            minusButton.getStyleClass().add(FILTER_SELECTED_STYLE_CLASS);
            plusOrMinus=TypeOfSort.MINUS;
            sortByFilter(plusOrMinus,filter);

        }
    }

    @FXML
    void plusButtonClicked(MouseEvent event) {
        if(filter.isClicked()){
            resetTypeOfSort();
            plusButton.getStyleClass().add(FILTER_SELECTED_STYLE_CLASS);
            plusOrMinus=TypeOfSort.PLUS;
            sortByFilter(plusOrMinus,filter);
        }

    }

    private void sortByFilter(TypeOfSort sort, Filters filters){
        int first=0;
        int second=0;
        switch (sort){
            case MINUS:
                first=1;
                second-=1;
                break;
            case PLUS:
                first-=1;
                second=1;
                break;
        }
        switch (filters){
            case LIKES:
                int finalFirst = first;
                int finalSecond = second;
                Main.INCIDENTS.sort((p1, p2) -> {
                    if(p1.getLikes()>p2.getLikes())
                        return finalFirst;
                    else if(p1.getLikes()<p2.getLikes())
                        return finalSecond;
                    else
                        return 0;
                });
                break;
            case DATE:
                int finalFirst1 = first;
                int finalSecond1 = second;
                Main.INCIDENTS.sort((p1, p2) -> {
                    if(p1.getDate().isAfter(p2.getDate()))
                        return finalFirst1;
                    else if(p1.getDate().isBefore(p2.getDate()))
                        return finalSecond1;
                    else
                        return 0;
                });
                break;
            case EMERGENCY:
                int finalFirst2 = first;
                int finalSecond2 = second;
                Main.INCIDENTS.sort((p1, p2) -> {
                    if(p1.getEmergency().getIndex()>p2.getEmergency().getIndex())
                        return finalFirst2;
                    else if(p1.getEmergency().getIndex()<p2.getEmergency().getIndex())
                        return finalSecond2;
                    else
                        return 0;
                });
                break;

        }

    }

    private void sortCategories(String cat){
        Main.INCIDENTS.sort((p1, p2) -> {
            if(p1.getCategory().getFrenchString().equals(cat))
                return -1;
            else if(!p1.getCategory().getFrenchString().equals(cat))
                return 1;
            else
                return 0;
        });
        resetFilters();
        resetTypeOfSort();
    }

    private void sortText(String txt){
        //POUR LE MOMENT SEUL LE TITRE EXACT EST TRIE, ON PEUT TOUT CAST EN MINUSCULE POUR EVITER LES PB
        // OU ENCORE CHERCHER EN FONCTION DU NOM DU DECLARANT
        Main.INCIDENTS.sort((p1, p2) -> {
            if(p1.getTitle().equals(txt))
                return -1;
            else if(!p1.getTitle().equals(txt))
                return 1;
            else
                return 0;
        });

    }


    private void resetFilters(){
        likesButton.getStyleClass().removeAll(FILTER_SELECTED_STYLE_CLASS);
        Filters.LIKES.setClicked(false);
        emergencyButton.getStyleClass().removeAll(FILTER_SELECTED_STYLE_CLASS);
        Filters.EMERGENCY.setClicked(false);
        dateButton.getStyleClass().removeAll(FILTER_SELECTED_STYLE_CLASS);
        Filters.DATE.setClicked(false);
        categoryButton.setValue(Category.CATEGORY.getFrenchString().getValue());
    }

    private void resetTypeOfSort(){
        plusButton.getStyleClass().removeAll(FILTER_SELECTED_STYLE_CLASS);
        minusButton.getStyleClass().removeAll(FILTER_SELECTED_STYLE_CLASS);
    }


    /**
     * Initializes the content of the view
     */
    public void initContent(){
        incidentsView.setCellFactory(
                param -> new IncidentCell()
        );
        incidentsView.itemsProperty().bind(new SimpleListProperty<>(Main.INCIDENTS));
        for (Category cat : Category.values()){
            if(!cat.equals(Category.CATEGORY)){
                categoryButton.getItems().add(cat.getFrenchString().getValue());
            }
        }
        categoryButton.getSelectionModel().selectedItemProperty().addListener(observable -> sortCategories(categoryButton.getSelectionModel().getSelectedItem()));

    }



    public void setScene(Scene scene) {
        this.scene = scene;
    }
}

