package Controller.ApiHandler;

import Controller.MainController;
import Service.Classes.HttpResponse;
import Service.Classes.UriTree;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    protected String readBody(HttpExchange t) {
        StringBuilder buf = new StringBuilder();
        try {
            InputStreamReader isr = new InputStreamReader(t.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);

            int b;
            while ((b = br.read()) != -1) {
                buf.append((char) b);
            }
            br.close();
            isr.close();
        } catch (Exception e) {
            return "";
        }
        return buf.toString();
    }
}