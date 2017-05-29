package Controller;

import Service.*;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;

public class ApiHandler implements HttpHandler {
    UriTree uriTree = new UriTree();

    @Override
    public void handle(HttpExchange t) throws IOException {
        System.out.println("Request gotten");
        HttpResponse response;
        try {
            response = ParseRequest(t.getRequestURI(), t.getRequestMethod());
        }
        catch (Exception ex) {
            System.out.println("Failed to process request");
            response = new HttpResponse(400, "Failed to process request");
        }
        t.sendResponseHeaders(response.Code, response.Body.length());
        OutputStream os = t.getResponseBody();
        os.write(response.Body.getBytes());
        os.close();
        System.out.println("Send " + response.Body + " response");
    }

    HttpResponse ParseRequest(URI uri, String method) throws BadRequestException {
        Node node = uriTree.top;
        ArrayList<String> params = new ArrayList<>();
        partparse:
        for (String str : uri.toString().split("/")) {
            if (str.isEmpty()) {
                continue partparse;
            }
            for (Node subnode : node.Subnodes) {
                if (str.equals(subnode.Name)) {
                    node = subnode;
                    continue partparse;
                }
            }
            if (node.Subnodes.size() == 0) {
                System.out.println("Too many parameters");
                throw new BadRequestException();
            }
            params.add(str);
            node = node.Subnodes.get(0);
        }
        String[] arrayparams = new String[params.size()];
        params.toArray(arrayparams);
        return node.Actions[UriTree.RequestMethod.get(method)].Process(arrayparams);
    }
}