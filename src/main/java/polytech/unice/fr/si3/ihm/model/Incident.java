package polytech.unice.fr.si3.ihm.model;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.json.JSONObject;

import java.time.LocalDate;

/**
 * Class that model an incident
 */
public class Incident {

    private StringProperty title;
    private StringProperty description;
    private User declarer;
    private int likes;
    private Category category;
    private LocalDate date;
    private Emergency emergency;
    private StringProperty location;

    /**
     * Constructor for an incident
     * @param title the title of the incident
     * @param description the description of the incident
     * @param declarer the declarer of the incident
     * @param likes number of likes of the incident
     * @param category the category of the incident
     * @param date the date of declaration of the incident
     * @param emergency  the type of emergency of the incident ( Very/Less Urgent)
     * @param location the issue location
     */
    public Incident(String title, String description, User declarer, int likes, Category category, LocalDate date, Emergency emergency, String location) {
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
        this.declarer= declarer;
        this.likes = likes;
        this.category = category;
        this.date = date;
        this.emergency=emergency;
        this.location = new SimpleStringProperty(location);
    }

    /**
     * Getter for the incident's title
     * @return the title
     */
    public StringProperty getTitle() {
        return title;
    }

    /**
     * Getter for the incident's description
     * @return the description
     */
    public StringProperty getDescription() {
        return description;
    }

    /**
     * Getter for the incident's declarer
     * @return the declarer
     */
    public User getDeclarer() {
        return declarer;
    }

    /**
     * Getter for the incident's category
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getLikes() {
        return likes;
    }

    public Emergency getEmergency() {
        return emergency;
    }

    public void upvote(){
        likes++;
    }

    public void downvote(){
        likes--;
    }

    public StringProperty getLocation() {
        return location;
    }


    public JSONObject toJson(){
        JSONObject object = new JSONObject();
        object.put("title", title.getValue());
        object.put("description", description.getValue());
        object.put("declarer", declarer.toJson());
        object.put("likes", likes);
        object.put("category", category);
        object.put("date", date.toString());
        object.put("emergency", emergency);
        object.put("location", location.getValue());
        return object;
    }
}
