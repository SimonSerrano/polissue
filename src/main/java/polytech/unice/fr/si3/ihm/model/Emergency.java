package polytech.unice.fr.si3.ihm.model;

public enum Emergency {
    CRITICAL(3),
    HIGH(2),
    MEDIUM(1),
    LOW(0);

    public int index;

    Emergency(int index){
        this.index=index;
    }

    public int getIndex() {
        return index;
    }
}
