package service;

import com.google.inject.Inject;
import connector.CatsHttpConnector;
import util.CommonUtil;

import java.util.Arrays;


public class ClientServiceImpl implements ClientService {

    @Inject
    private CatsHttpConnector catsConnector;

    @Override
    public void validate() {
        // validate request
    }

    @Override
    public void handleRequest(String[] args) {
        // parse some args
        catsConnector.fetchCatFacts("cat", 2);
    }
}
