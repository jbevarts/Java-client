package service;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Logging;

import java.io.IOException;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClientTest {

    @Test
    public void sanityTest() {
        Logging.enableLogging();

        HttpRequestFactory requestFactory
                = new NetHttpTransport().createRequestFactory();
        try {
            HttpRequest request = requestFactory.buildGetRequest(
                    new GenericUrl("https://github.com"));
            String rawResponse = request.execute().parseAsString();

        } catch (HttpResponseException e) {
            System.err.println(e.getStatusMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
