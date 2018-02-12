package polytech.unice.fr.si3.ihm.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import polytech.unice.fr.si3.ihm.controller.IncidentCellController;
import polytech.unice.fr.si3.ihm.model.Incident;

import java.io.IOException;
import java.util.logging.Logger;

import static polytech.unice.fr.si3.ihm.util.Constant.INCIDENT_CELL_FXML;

public class IncidentCell extends ListCell<polytech.unice.fr.si3.ihm.model.Incident> {

    private IncidentCellController controller = new IncidentCellController(getItem());

    public IncidentCell() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(INCIDENT_CELL_FXML));
            setGraphic((Node) loader.load());

            controller = loader.getController();
        } catch (IOException e) {
            Logger.getLogger("Thrower").warning(e.toString());
        }
    }

    @Override
    protected void updateItem(Incident item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) controller.setItem(item);
    }
}
