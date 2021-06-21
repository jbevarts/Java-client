package handlers;

import inject.InjectionContext;
import service.ClientService;
import service.ClientServiceImpl;


public class Client {
    static ClientService clientService = InjectionContext.get().instanceOf(ClientServiceImpl.class);
    public static void main(String[] args) {
        clientService.handleRequest(args);
    }
}
