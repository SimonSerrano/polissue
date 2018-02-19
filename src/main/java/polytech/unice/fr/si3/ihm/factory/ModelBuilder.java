package polytech.unice.fr.si3.ihm.factory;


import org.json.JSONArray;
import org.json.JSONObject;
import polytech.unice.fr.si3.ihm.model.Category;
import polytech.unice.fr.si3.ihm.model.Emergency;
import polytech.unice.fr.si3.ihm.model.Incident;
import polytech.unice.fr.si3.ihm.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ModelBuilder {
    /**
     * Constructor for the ModelBuilder
     */
    public ModelBuilder() {
        //Default constructor for the ModelBuilder
    }

    /**
     * Method that reads the file containing all the INCIDENTS registered
     *
     */
    public List<Incident> readIncidents(String dataFilePath){
        List<Incident>incidentList=new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(dataFilePath)));
            JSONArray jsonIncidents;
            if (content.isEmpty()){
                jsonIncidents = new JSONArray();
            }else{
                jsonIncidents = new JSONArray(content);
            }

            for (int i = 0; i < jsonIncidents.length(); i++) {
                JSONObject jsonobject = jsonIncidents.getJSONObject(i);
                String title = jsonobject.getString("title");
                String description = jsonobject.getString("description");
                User declarer = new User(jsonobject.getJSONObject("declarer").getString("name"));
                String category = jsonobject.getString("category");
                LocalDate declarationDate = LocalDate.parse(jsonobject.getString("date"));
                int likes = jsonobject.getInt("likes");
                String emergency= jsonobject.getString("emergency");
                Incident incidentCreated=new Incident(title,description,declarer, likes, getCategory(category), declarationDate,getEmergency(emergency));
                incidentList.add(incidentCreated);
            }

        } catch (IOException e) {
            Logger.getLogger("Thrower").warning(e.toString());
        }
        return incidentList;
    }

    private Category getCategory(String categoryString){
        for (Category category : Category.values()) {
            if (category.toString().equals(categoryString)){
                return category;
            }
        }
        return null;
    }

    private Emergency getEmergency(String emergencyString){
        for(Emergency emergency: Emergency.values()){
            if(emergency.toString().equals(emergencyString)){
                return emergency;
            }
        }
        return null;
    }


}
