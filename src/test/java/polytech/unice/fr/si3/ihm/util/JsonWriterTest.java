package polytech.unice.fr.si3.ihm.util;

import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import polytech.unice.fr.si3.ihm.factory.IncidentJSONFactory;
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
        JSONObject expected = new JSONObject();
        expected.put("test", "test");
        writer.write(expected, filePath);

        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject jsonObject = new JSONObject(content);
        assertEquals(expected.toString(), jsonObject.toString());

    }

    @Test
    void writeWithTransformedIncidentObject() throws IOException {
        Incident incident = new Incident("title", "description", "declarer");
        writer.write((new IncidentJSONFactory()).produce(incident), filePath);

        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject expected = new JSONObject();
        expected.put("title", "title");
        expected.put("description", "description");
        expected.put("declarer", "declarer");
        JSONObject jsonObject = new JSONObject(content);

        assertEquals(expected.toString(), jsonObject.toString());


    }
}