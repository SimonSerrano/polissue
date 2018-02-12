package polytech.unice.fr.si3.ihm.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import polytech.unice.fr.si3.ihm.factory.IncidentJSONFactory;
import polytech.unice.fr.si3.ihm.model.Category;
import polytech.unice.fr.si3.ihm.model.Incident;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest {

    private JsonWriter writer;

    private String filePath = "src/test/resources/data/incidents.json";

    @BeforeEach
    void setUp() {
        writer = new JsonWriter();
    }

    @AfterEach
    void tearDown() throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();
    }

    @Test
    void write() throws IOException {
        Incident incident = new Incident("title", "description", "declarer", Category.OTHER);
        ObservableList<Incident> incidents= FXCollections.observableArrayList();
        incidents.add(incident);
       writer.write(incidents, filePath);

        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray array=new JSONArray();
        JSONObject expected = new JSONObject();
        expected.put("title", "title");
        expected.put("description", "description");
        expected.put("declarer", "declarer");
        expected.put("category", "OTHER");
        array.put(expected);
        JSONArray jsonObject = new JSONArray(content);

        assertEquals(array.toString(), jsonObject.toString());


    }
}