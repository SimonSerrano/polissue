package polytech.unice.fr.si3.ihm.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import polytech.unice.fr.si3.ihm.model.Incident;

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
        Incident expected = new Incident("test","encoreTest","toujoursTest");
        assertEquals(expected.getTitle(),  this.mb.readIncidents(this.filePath).get(0).getTitle());
        assertEquals(expected.getDeclarer(),  this.mb.readIncidents(this.filePath).get(0).getDeclarer());
        assertEquals(expected.getDescription(),  this.mb.readIncidents(this.filePath).get(0).getDescription());

    }
}