package polytech.unice.fr.si3.ihm.factory;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import polytech.unice.fr.si3.ihm.model.Incident;

import static org.junit.jupiter.api.Assertions.*;

class IncidentJSONFactoryTest {

    private IncidentJSONFactory incidentJSONFactory;

    @BeforeEach
    void setUp() {
    incidentJSONFactory = new IncidentJSONFactory();
    }

    @Test
    void produce() {

        Incident incident = new Incident("title", "description", "declarer");
        JSONObject expected = new JSONObject();
        expected.put("title", "title");
        expected.put("description", "description");
        expected.put("declarer", "declarer");

        JSONObject jsonObject = incidentJSONFactory.produce(incident);

        assertEquals(expected.toString(), jsonObject.toString());

    }

}