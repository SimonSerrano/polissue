package polytech.unice.fr.si3.ihm.view;


import javafx.scene.Node;
import javafx.scene.control.ListCell;
import polytech.unice.fr.si3.ihm.controller.IncidentCellController;
import polytech.unice.fr.si3.ihm.model.Incident;




public class IncidentCell extends ListCell<Incident> {

    private final IncidentCellController controller = new IncidentCellController(null);
    private final Node view = controller.getView();


    @Override
    protected void updateItem(Incident item, boolean empty) {
        super.updateItem(item, empty);
        if(empty){
            setGraphic(null);
        }else {
            controller.setItem(item);
            setGraphic(view);
        }
    }
}
