package polytech.unice.fr.si3.ihm.util;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import polytech.unice.fr.si3.ihm.factory.IncidentJSONFactory;
import polytech.unice.fr.si3.ihm.model.Incident;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonWriterTest {

    private JsonWriter writer;

    private String filePath = "src/test/resources/data/incidents.json";

    @BeforeEach
    void setUp() {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write("[]\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer = new JsonWriter();

    }


    @AfterEach
    void tearDown() throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();
    }

    /**
     * Try and write a test object to the incident list
     *
     * @throws IOException
     */
    @Test
    void write() throws IOException {


        JSONObject expected = new JSONObject();

        expected.put("test", "test");
        writer.write(expected, filePath);

        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray jsonObject = new JSONArray(content);
        assertEquals(expected.toString(), jsonObject.get(0).toString());

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
        JSONArray jsonObject = new JSONArray(content);

        assertEquals(expected.toString(), jsonObject.get(0).toString());


    }
}