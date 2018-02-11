package polytech.unice.fr.si3.ihm.factory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        JSONArray expected = new JSONArray();
        JSONObject incident = new JSONObject();
        incident.put("title", "test");
        incident.put("description", "encoreTest");
        incident.put("declarer", "toujoursTest");

        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray jsonArray = new JSONArray(content);

        expected.put(incident);
        assertEquals(expected.toString(), jsonArray.toString());

    }
}