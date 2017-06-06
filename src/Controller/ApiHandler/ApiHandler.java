package Controller.ApiHandler;

import Controller.MainController;
import Service.Classes.HttpResponse;
import Service.Classes.UriTree;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.URI;

public abstract class ApiHandler implements HttpHandler {
    protected UriTree uriTree = new UriTree();

    public ApiHandler()
    {
        MainController.GetAuths();
    }

    public void handle(HttpExchange t) throws IOException {}
    HttpResponse parseRequest(URI uri, String method, String body) throws Exception {
        return null;
    }
}