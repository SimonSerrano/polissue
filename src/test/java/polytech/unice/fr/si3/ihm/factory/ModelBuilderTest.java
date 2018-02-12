package polytech.unice.fr.si3.ihm.factory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import polytech.unice.fr.si3.ihm.model.Category;
import polytech.unice.fr.si3.ihm.model.Incident;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class ModelBuilderTest {

    private ModelBuilder mb;
    private String filePath = "src/test/resources/data/modelBuilderTest.json";

    @BeforeEach
    void setUp() {
        this.mb=new ModelBuilder();
    }

    @Test
    void readIncidents() throws IOException {
        Incident expected = new Incident("test","encoreTest","toujoursTest", Category.OTHER);
        assertEquals(expected.getTitle(),  this.mb.readIncidents(this.filePath).get(0).getTitle());
        assertEquals(expected.getDeclarer(),  this.mb.readIncidents(this.filePath).get(0).getDeclarer());
        assertEquals(expected.getDescription(),  this.mb.readIncidents(this.filePath).get(0).getDescription());

    }
}