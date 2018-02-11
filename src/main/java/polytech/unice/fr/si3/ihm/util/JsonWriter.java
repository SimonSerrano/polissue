package polytech.unice.fr.si3.ihm.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
     * Method that writes in the incidents file
     * @param jsonObject the json object to write in the file
     */
    public void write(JSONObject jsonObject, String dataFilePath){
        try{
            String content = new String(Files.readAllBytes(Paths.get(dataFilePath)));
            JSONArray jsonIncidents = new JSONArray(content);
            jsonIncidents.put(jsonObject);
            FileWriter writer = new FileWriter(dataFilePath);
            writer.append(jsonIncidents.toString());
            writer.flush();
        } catch (IOException e) {
            Logger.getLogger("Thrower").warning(e.toString());
        }
    }
}
