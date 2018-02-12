package polytech.unice.fr.si3.ihm.model;



/**
 * Class that model an incident
 */
public class Incident {

    private String title;
    private String description;
    private String declarer;
    private Category category;

    /**
     * Constructor for an incident
     * @param title the title of the incident
     * @param description the description of the incident
     * @param declarer the declarer of the incident
     * @param category the category of the incident
     */
    public Incident(String title, String description, String declarer, Category category) {
        this.title = title;
        this.description = description;
        this.declarer = declarer;
        this.category = category;
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
    public String getDeclarer() {
        return declarer;
    }

    /**
     * Getter for the incident's category
     * @return the category
     */
    public Category getCategory() {
        return category;
    }
}
