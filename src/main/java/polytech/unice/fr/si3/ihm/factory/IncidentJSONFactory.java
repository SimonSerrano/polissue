package polytech.unice.fr.si3.ihm.factory;

import org.json.JSONObject;
import polytech.unice.fr.si3.ihm.model.Incident;

/**
 * Class that allows to convert an incident to a JSON format
 */
public class IncidentJSONFactory {

    /**
     * Default constructor
     */
    public IncidentJSONFactory() {
        //Default constructor for the incident to Json factory
    }

    /**
     * Method that allows to build a json object from a incident
     * @param incident the incident to build the json object from
     * @return the json object of the incident
     */
    public JSONObject produce(Incident incident){
        return new JSONObject(incident);
    }
}
