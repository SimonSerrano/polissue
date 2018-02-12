package polytech.unice.fr.si3.ihm.factory;


import org.json.JSONArray;
import org.json.JSONObject;
import polytech.unice.fr.si3.ihm.model.Category;
import polytech.unice.fr.si3.ihm.model.Incident;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
     * Method that reads the file containing all the incidents registered
     *
     */
    public List<Incident> readIncidents(String dataFilePath){
        List<Incident>incidentList=new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(dataFilePath)));
            JSONArray jsonIncidents = new JSONArray(content);

            for (int i = 0; i < jsonIncidents.length(); i++) {
                JSONObject jsonobject = jsonIncidents.getJSONObject(i);
                String title = jsonobject.getString("title");
                String description = jsonobject.getString("description");
                String declarer = jsonobject.getString("declarer");
                String category = jsonobject.getString("category");
                Incident incidentCreated=new Incident(title,description,declarer, getCategory(category));
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


}
