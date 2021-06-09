package service;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import config.InjectionContext;
import util.Logging;

import java.io.IOException;
import java.util.Arrays;

public class Client {
    final InjectionContext injectionContext = InjectionContext.get();

    public static void main(String[] args) {
        Logging.enableLogging();

        System.out.println("hello world");
        Arrays.stream(args).forEach(elem -> System.out.println(elem));

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
