package polytech.unice.fr.si3.ihm.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import polytech.unice.fr.si3.ihm.model.Category;
import polytech.unice.fr.si3.ihm.model.Emergency;
import polytech.unice.fr.si3.ihm.model.Incident;
import polytech.unice.fr.si3.ihm.model.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelBuilderTest {

    private ModelBuilder mb;
    private String filePath = "src/test/resources/data/modelBuilderTest.json";

    @BeforeEach
    void setUp() {
        this.mb=new ModelBuilder();
    }

    @Test
    void readIncidents() {
        Incident expected = new Incident("test", "encoreTest", new User("toujoursTest"), 0, Category.OTHER, LocalDate.parse("2018-03-09"), Emergency.LOW, "");
        assertEquals(expected.getTitle().getValue(),  this.mb.readIncidents(this.filePath).get(0).getTitle().getValue());
        assertEquals(expected.getDeclarer(),  this.mb.readIncidents(this.filePath).get(0).getDeclarer());
        assertEquals(expected.getDescription().getValue(),  this.mb.readIncidents(this.filePath).get(0).getDescription().getValue());

    }
}