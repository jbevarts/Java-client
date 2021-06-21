package service;

import connector.CatsHttpConnector;
import inject.InjectionContext;
import models.Facts;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ClientTest {

    @Mock
    private CatsHttpConnector catsConnector;

    @InjectMocks
    private ClientServiceImpl service;

    private static Facts[] factsArray;

    @BeforeAll
    static void setup() {
        Facts[] factsArr = new Facts[1];
        Facts testFacts = new Facts();
        testFacts.setText("test text");
        factsArr[0] = testFacts;
        factsArray = factsArr;
    }

    @Test
    public void sanityTest() {
        assertNotNull(catsConnector);
        assertNotNull(service);
        when(catsConnector.fetchCatFacts(Mockito.anyString(), Mockito.anyInt())).thenReturn(factsArray);
        service.validate();
    }

}
