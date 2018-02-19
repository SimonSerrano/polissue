package polytech.unice.fr.si3.ihm.model;

public enum Filters {
    LIKES,
    EMERGENCY,
    DATE,
    NOTHING;

    private boolean clicked;

    Filters(){
        this.clicked =false;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public boolean isClicked() {
        return clicked;
    }
}
