package polytech.unice.fr.si3.ihm.model;


import java.time.LocalDate;

/**
 * Class that model an incident
 */
public class Incident {

    private String title;
    private String description;
    private User declarer;
    private int likes;
    private Category category;
    private LocalDate date;
    private Emergency emergency;
    /**
     * Constructor for an incident
     * @param title the title of the incident
     * @param description the description of the incident
     * @param declarer the declarer of the incident
     * @param likes
     * @param category the category of the incident
     * @param date the date of declaration of the incident
     * @param emergency  the type of emergency of the incident ( Very/Less Urgent)
     */
    public Incident(String title, String description, User declarer, int likes, Category category, LocalDate date,Emergency emergency) {
        this.title = title;
        this.description = description;
        this.declarer= declarer;
        this.likes = likes;
        this.category = category;
        this.date = date;
        this.emergency=emergency;
    }

    /**
     * Getter for the incident's title
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for the incident's description
     * @return the description
     */
    public String getDescription() {
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
}
