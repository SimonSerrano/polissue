package polytech.unice.fr.si3.ihm.util;

import org.json.JSONObject;

import java.io.*;

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

        try(FileWriter writer = new FileWriter(dataFilePath)){
            writer.append(jsonObject.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}