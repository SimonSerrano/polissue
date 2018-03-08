package polytech.unice.fr.si3.ihm.util;

import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;
import polytech.unice.fr.si3.ihm.model.Incident;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Class that allows to write a json object in the file where all the data is stored
 */
public class JsonWriter {

    /**
     * Constructor for the JsonWriter
     */
    public JsonWriter() {
        //Default constructor for the JsonWriter
    }


    /**
     * Method that writes in the INCIDENTS file
     * @param incidents the list of the INCIDENTS to write in the files
     */
    public void write(ObservableList<Incident> incidents, String dataFilePath){
        try(FileWriter writer = new FileWriter(dataFilePath)){
            JSONArray jsonIncidents = new JSONArray();
            for (Incident in : incidents) {
                JSONObject jsonObject = in.toJson();
                jsonIncidents.put(jsonObject);
            }
            writer.append(jsonIncidents.toString());
            writer.flush();
        } catch (IOException e) {
            Logger.getLogger("Thrower").warning(e.toString());
        }
    }
}
