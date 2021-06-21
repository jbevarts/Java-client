package connector;

import inject.InjectionContext;
import models.Facts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.CommonUtil;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectorTest {

//    @BeforeEach
//    void init() {
//        InjectionContext.get();
//    }
    @Test
    public void sanityTest() {
        int qty = 2;
        String type = "cat";

        CatsHttpConnector connector = new CatsConnectorImpl("https://cat-fact.herokuapp.com");
        Facts[] response = connector.fetchCatFacts(type, qty);
        assertNotNull(response);
        assertEquals(qty, response.length);
        assertTrue(Arrays.asList(response).stream().allMatch(elem -> elem.getType().equals(type)));

    }

}
