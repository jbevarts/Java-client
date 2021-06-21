package connector;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.inject.Inject;
import models.Facts;

import java.io.IOException;

public interface CatsHttpConnector {
    Facts[] fetchCatFacts(String catType, int quantity);

}
