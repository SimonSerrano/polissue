package polytech.unice.fr.si3.ihm.model;


import java.time.LocalDate;

/**
 * Class that model an incident
 */
public class Incident {

    private String title;
    private String description;
    private User declarer;
    private Category category;
    private LocalDate date;

    /**
     * Constructor for an incident
     * @param title the title of the incident
     * @param description the description of the incident
     * @param declarer the declarer of the incident
     * @param category the category of the incident
     * @param date the date of declaration of the incident
     */
    public Incident(String title, String description, User declarer, Category category, LocalDate date) {
        this.title = title;
        this.description = description;
        this.declarer= declarer;
        this.category = category;
        this.date = date;
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
}
