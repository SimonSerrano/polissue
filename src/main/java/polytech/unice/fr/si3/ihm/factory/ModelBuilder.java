package polytech.unice.fr.si3.ihm.factory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import polytech.unice.fr.si3.ihm.model.Incident;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ModelBuilder {
    /**
     * Constructor for the ModelBuilder
     */
    private List<Incident> incidentList;
    public ModelBuilder() {
        //Default constructor for the ModelBuilder
        this.incidentList=new ArrayList<>();
    }


    /**
     * Method that reads the file containing all the incidents registered
     *
     */
    public void read(String dataFilePath){

        JSONParser parser = new JSONParser();

        try {
            JSONArray JsonIncidents = (JSONArray) parser.parse(new FileReader(dataFilePath));
            for (Object incident : JsonIncidents) {
                JSONObject in = (JSONObject) incident;
                String title = (String) in.get("title");
                String description = (String) in.get("description");
                String declarer = (String) in.get("declarer");
                Incident incidentCreated=new Incident(title,description,declarer);
                this.incidentList.add(incidentCreated);

            }
        } catch (IOException | ParseException e) {
            Logger.getLogger("Thrower").warning(e.toString());
        }
    }
}
