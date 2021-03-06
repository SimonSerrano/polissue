package polytech.unice.fr.si3.ihm.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import polytech.unice.fr.si3.ihm.model.Category;
import polytech.unice.fr.si3.ihm.model.Emergency;
import polytech.unice.fr.si3.ihm.model.Incident;
import polytech.unice.fr.si3.ihm.model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonWriterTest {

    private JsonWriter writer;

    private String filePath = "src/test/resources/data/INCIDENTS.json";

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
        Incident incident = new Incident("title", "description", new User("declarer"), 0, Category.OTHER, LocalDate.parse("2018-03-09"), Emergency.LOW, "");
        ObservableList<Incident> incidents= FXCollections.observableArrayList();
        incidents.add(incident);
        writer.write(incidents, filePath);

        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray array=new JSONArray();
        JSONObject expected = new JSONObject();
        JSONObject expectedUser = new JSONObject();
        expected.put("title", "title");
        expected.put("description", "description");
        expectedUser.put("name", "declarer");
        expected.put("declarer", expectedUser);
        expected.put("category", "OTHER");
        expected.put("date", "2018-03-09");
        expected.put("emergency", "LOW");
        expected.put("location", "");
        expected.put("likes",0);
        array.put(expected);
        JSONArray jsonObject = new JSONArray(content);

        assertEquals(array.toString(), jsonObject.toString());


    }
}